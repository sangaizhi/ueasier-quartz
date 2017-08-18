package cn.zyunc.ueasier.quartz.test.dao;

import cn.zyunc.ueasier.quartz.test.model.OrderPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by sangaizhi on 2017/8/17.
 */
@Repository
public interface OrderDao {

    void saveBatch(List<OrderPO> poList);

}
