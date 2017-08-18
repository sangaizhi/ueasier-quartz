package cn.zyunc.ueasier.quartz.config;

import cn.zyunc.ueasier.quartz.util.TaskUtils;
import cn.zyunc.ueasier.quartz.model.ScheduleJob;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuartzJobFactory implements Job {
    public final Logger log = LoggerFactory.getLogger(this.getClass());
  
    @Override  
    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        TaskUtils.execute(scheduleJob);
    }  
}  