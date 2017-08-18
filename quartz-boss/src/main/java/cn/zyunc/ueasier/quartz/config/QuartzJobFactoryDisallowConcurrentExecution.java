package cn.zyunc.ueasier.quartz.config;

import cn.zyunc.ueasier.quartz.util.TaskUtils;
import cn.zyunc.ueasier.quartz.model.ScheduleJob;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@DisallowConcurrentExecution
public class QuartzJobFactoryDisallowConcurrentExecution implements Job {
    public final Logger log = LoggerFactory.getLogger(this.getClass());
  
    public void execute(JobExecutionContext context) throws JobExecutionException {
        ScheduleJob scheduleJob = (ScheduleJob) context.getMergedJobDataMap().get("scheduleJob");
        TaskUtils.execute(scheduleJob);
  
    }  
}  