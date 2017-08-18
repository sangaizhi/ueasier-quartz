package cn.zyunc.ueasier.quartz.test.service.impl;

import cn.zyunc.ueasier.commons.utils.DateUtil;
import cn.zyunc.ueasier.quartz.test.util.FileUtil;
import cn.zyunc.ueasier.quartz.test.dao.OrderDao;
import cn.zyunc.ueasier.quartz.test.model.OrderPO;
import cn.zyunc.ueasier.quartz.test.model.OrderVO;
import cn.zyunc.ueasier.quartz.test.model.ReadResult;
import cn.zyunc.ueasier.quartz.test.service.OrderService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sangaizhi
 * @date 2017/8/17
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final int CODE = 0;
    private static final int AMOUNT = 1;
    private static final int USER_ID = 2;
    private static final int USER_NAME = 3;
    private static final int DATE = 4;

    @Autowired
    private OrderDao orderDao;

    public void readAndSaveFromFile(String filePath) {
        try {
            ReadResult readResult = FileUtil.readLine(filePath);
            List<OrderVO> orderVOList = new ArrayList<OrderVO>();
            if(null != readResult){
                for(Object data : readResult.getSuccessDataList()){
                     String orderData = (String) data;
                     String[] orderDataArray = StringUtils.split(orderData, ",");
                     OrderVO orderVO = copyPropertiesFromArray(orderDataArray);
                     if(null != orderVO){
                         orderVOList.add(orderVO);
                     }
                }
            }
            this.saveBatch(orderVOList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public void saveBatch(List<OrderVO> voList) {
        if(CollectionUtils.isEmpty(voList)){
            return;
        }
        List<OrderPO> orderPOList = new ArrayList<OrderPO>();
        OrderPO orderPO;
        for(OrderVO orderVO : voList){
            orderPO = new OrderPO();
            BeanUtils.copyProperties(orderVO, orderPO);
            orderPOList.add(orderPO);
        }
        orderDao.saveBatch(orderPOList);
    }

    private OrderVO copyPropertiesFromArray(String[] array){
        if(null == array || array.length <= 0){
            return null;
        }
        OrderVO orderVO = new OrderVO();
        if(array.length > CODE){
            orderVO.setCode(array[CODE]);
        }
        if(array.length > AMOUNT){
            orderVO.setAmount(BigDecimal.valueOf(Double.valueOf(array[AMOUNT])));
        }
        if(array.length > USER_ID){
            orderVO.setUserId(Long.valueOf(array[USER_ID]));
        }
        if(array.length > USER_NAME){
            orderVO.setUserName(array[USER_NAME]);
        }
        if(array.length > DATE){
            orderVO.setDate(DateUtil.parseDate(array[DATE], "yyyy-MM-dd HH:mm:ss"));
        }
        return orderVO;
    }


}
