package cn.zyunc.ueasier.quartz;

import cn.zyunc.ueasier.quartz.common.ResponseResult;
import cn.zyunc.ueasier.quartz.service.impl.ScheduleJobServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sangaizhi
 * @date 2017/8/17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:spring-mybatis.xml", "classpath:spring.xml" })
public class JobExecuteTest {

    @Autowired
    private ScheduleJobServiceImpl scheduleJobService;

    @Test
    public void execute(){
        try {
            scheduleJobService.execute(1L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
