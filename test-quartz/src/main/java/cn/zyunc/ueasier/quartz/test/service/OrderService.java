package cn.zyunc.ueasier.quartz.test.service;

import cn.zyunc.ueasier.quartz.test.model.OrderVO;

import java.util.List;

/**
 * created by sangaizhi on 2017/8/17.
 */
public interface OrderService {

    void readAndSaveFromFile(String filePath);

    void saveBatch(List<OrderVO> voList);

}
