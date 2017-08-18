package cn.zyunc.ueasier.quartz.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/**
 * @author sangaizhi
 * @date 2017/8/17
 */
public class ResponseResult {

    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 业务响应状态
     */
    private Boolean status;

    // 响应业务状态码
    private Integer code;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    public static ResponseResult build(Boolean status) {
        return build(status, null);
    }

    public static ResponseResult build(Boolean status, Integer code) {
        return build(status, code, null);
    }

    public static ResponseResult build(Boolean status, Integer code, String message) {
        return build(status, code, message, null);
    }

    public static ResponseResult build(Boolean status, Integer code, String message, Object data) {
        return new ResponseResult(status, code, message, data);
    }

    public static ResponseResult ok(String message, Object data){
        return new ResponseResult(true, 200, message, data);
    }

    public static ResponseResult ok(Object data) {
        return new ResponseResult(true, 200, "ok", data);
    }

    public static ResponseResult ok() {
        return new ResponseResult(true, 200, "ok", null);
    }

    public static ResponseResult fail(){
        return new ResponseResult(false, 500, "error", null);
    }
    public static ResponseResult fail(String msg){
        return new ResponseResult(false, 500, msg ,null);
    }
    public static ResponseResult fail(String msg, Object data){
        return new ResponseResult(false, 500, msg, data);
    }

    public ResponseResult(Boolean status, Integer code, String message, Object data) {
        this.status = status;
        this.code = code;
        this.msg = message;
        this.data = data;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 将json结果集转化为ResponseResult对象
     *
     * @param jsonData json数据
     * @param clazz ResponseResult中的object类型
     * @return
     */
    public static ResponseResult formatToPojo(String jsonData, Class<?> clazz) {
        try {
            if (clazz == null) {
                return MAPPER.readValue(jsonData, ResponseResult.class);
            }
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isObject()) {
                obj = MAPPER.readValue(data.traverse(), clazz);
            } else if (data.isTextual()) {
                obj = MAPPER.readValue(data.asText(), clazz);
            }
            return build(jsonNode.get("status").asBoolean(), jsonNode.get("code").asInt(), jsonNode.get("msg").asText(),
                    obj);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 没有object对象的转化
     *
     * @param json
     * @return
     */
    public static ResponseResult format(String json) {
        try {
            return MAPPER.readValue(json, ResponseResult.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Object是集合转化
     *
     * @param jsonData json数据
     * @param clazz 集合中的类型
     * @return
     */
    public static ResponseResult formatToList(String jsonData, Class<?> clazz) {
        try {
            JsonNode jsonNode = MAPPER.readTree(jsonData);
            JsonNode data = jsonNode.get("data");
            Object obj = null;
            if (data.isArray() && data.size() > 0) {
                obj = MAPPER.readValue(data.traverse(),
                        MAPPER.getTypeFactory().constructCollectionType(List.class, clazz));
            }
            return build(jsonNode.get("status").asBoolean(), jsonNode.get("code").asInt(), jsonNode.get("msg").asText(),
                    obj);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "ResponseResult{" + "status=" + status + ", msg='" + msg + '\'' + ", data=" + data + '}';
    }
}
