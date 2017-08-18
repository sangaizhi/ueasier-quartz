package cn.zyunc.ueasier.quartz.controller;

import cn.zyunc.ueasier.quartz.common.ResponseResult;
import cn.zyunc.ueasier.quartz.service.impl.ScheduleJobServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sangaizhi
 * @date 2017/8/14
 */
@Controller
@RequestMapping("/job")
public class JobController {

    @Autowired
    private ScheduleJobServiceImpl scheduleJobService;

    @RequestMapping("/execute")
    public ResponseResult execute(Long id){
        try {
            scheduleJobService.execute(id);
            return ResponseResult.ok();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseResult.fail();
        }
    }

}
