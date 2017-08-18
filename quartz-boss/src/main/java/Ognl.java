

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/**
* @ClassName: Ognl
* @Description: Ognl工具类，主要是为了在ognl表达式访问静态方法时可以减少长长的类名称编写
 * Ognl访问静态方法的表达式为: @class@method(args)
 * 示例使用:
 *  <if test="@Ognl@isNotEmpty(userId)">
 *      and user_id = #{userId}
 *  </if>
* @author: wupeng
* @date: 2016年5月26日 下午5:27:50
 */
public class Ognl {

    public static boolean isEmpty(Object o) throws IllegalArgumentException {
        if (o == null)
            return true;

        if (o instanceof String) {
            if (((String) o).length() == 0) {
                return true;
            }
        } else if (o instanceof Collection) {
            if (((Collection<?>) o).isEmpty()) {
                return true;
            }
        } else if (o.getClass().isArray()) {
            if (Array.getLength(o) == 0) {
                return true;
            }
        } else if (o instanceof Map) {
            if (((Map<?, ?>) o).isEmpty()) {
                return true;
            }
        } else {
            return false;
        }

        return false;
    }

    public static boolean isNotEmpty(Object o) {
        return !isEmpty(o);
    }
    
    public static boolean isEquals(Object o, Object x){
        if(o == null || x == null){
            return false;
        }
        if (o instanceof String && x instanceof String) {
            if(o.equals(x)){
                return true;
            }
        }else if(o instanceof Integer && x instanceof Integer){
            if(o.equals(x)){
                return true;
            }
        }else if(o instanceof Double && x instanceof Double){
            if(o.equals(x)){
                return true;
            }
        }
        return false;
    }
}
