package cn.zyunc.ueasier.quartz.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.quartz.*;
import org.quartz.impl.matchers.GroupMatcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import cn.zyunc.ueasier.quartz.constants.IsConcurrent;
import cn.zyunc.ueasier.quartz.constants.JobStatus;
import cn.zyunc.ueasier.quartz.model.ScheduleJob;
import cn.zyunc.ueasier.quartz.vo.ScheduleJobVO;
import org.springframework.stereotype.Component;

/**
 * @author sangaizhi
 * @date 2017/8/11
 */
@Component
public class JobManager {

    @Autowired
    private  SchedulerFactoryBean schedulerFactoryBean;



    public  void addJob(ScheduleJob job) throws SchedulerException {
        if (null == job || !Objects.equals(job.getJobStatus(), JobStatus.RUNNING.getValue())) {
            return;
        }
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        if (null == trigger) {
            Class<? extends Job> clazz = Objects.equals(job.getJobIsConcurrent(), IsConcurrent.YES.getValue()) ? QuartzJobFactory.class
                    : QuartzJobFactoryDisallowConcurrentExecution.class;
            JobDetail jobDetail = JobBuilder.newJob(clazz).withIdentity(job.getJobName(), job.getJobGroup()).build();
            jobDetail.getJobDataMap().put("scheduleJob", job);
            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(job.getJobCron());
            trigger = TriggerBuilder.newTrigger().withIdentity(job.getJobName(), job.getJobGroup())
                    .withSchedule(cronScheduleBuilder).build();
            scheduler.scheduleJob(jobDetail, trigger);
        }else{
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getJobCron());
            trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
            scheduler.rescheduleJob(triggerKey, trigger);
        }
    }

    public List<ScheduleJobVO> getAll() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        GroupMatcher<JobKey> matcher = GroupMatcher.anyJobGroup();
        Set<JobKey> jobKeys = scheduler.getJobKeys(matcher);
        List<ScheduleJobVO> jobList = new ArrayList<ScheduleJobVO>();
        for(JobKey jobKey : jobKeys){
            List<? extends Trigger> triggers = scheduler.getTriggersOfJob(jobKey);
            for(Trigger trigger : triggers){
                ScheduleJobVO job = new ScheduleJobVO();
                job.setJobName(jobKey.getName());
                job.setJobGroup(jobKey.getGroup());
                job.setJobDesc("trigger:" + trigger.getKey());
                Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
                job.setJobStatus(triggerState.name());
                if(trigger instanceof CronTrigger){
                    CronTrigger  cronTrigger = (CronTrigger) trigger;
                    String cronExpression = cronTrigger.getCronExpression();
                    job.setJobCron(cronExpression);
                }
                jobList.add(job);
            }
        }
        return jobList;
    }

    /**
     * 所有正在运行的job
     *
     * @return
     * @throws SchedulerException
     */
    public List<ScheduleJobVO> getRunningJob() throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        List<JobExecutionContext> executingJobs = scheduler.getCurrentlyExecutingJobs();
        List<ScheduleJobVO> jobList = new ArrayList<ScheduleJobVO>(executingJobs.size());
        for (JobExecutionContext executingJob : executingJobs) {
            ScheduleJobVO job = new ScheduleJobVO();
            JobDetail jobDetail = executingJob.getJobDetail();
            JobKey jobKey = jobDetail.getKey();
            Trigger trigger = executingJob.getTrigger();
            job.setJobName(jobKey.getName());
            job.setJobGroup(jobKey.getGroup());
            job.setJobDesc("触发器:" + trigger.getKey());
            Trigger.TriggerState triggerState = scheduler.getTriggerState(trigger.getKey());
            job.setJobStatus(triggerState.name());
            if (trigger instanceof CronTrigger) {
                CronTrigger cronTrigger = (CronTrigger) trigger;
                String cronExpression = cronTrigger.getCronExpression();
                job.setJobCron(cronExpression);
            }
            jobList.add(job);
        }
        return jobList;
    }

    /**
     * 暂停一个job
     *
     * @param job
     * @throws SchedulerException
     */
    public void pauseJob(ScheduleJobVO job) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        scheduler.pauseJob(jobKey);
    }
    /**
     * 恢复一个job
     *
     * @param job
     * @throws SchedulerException
     */
    public void resumeJob(ScheduleJobVO job) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        scheduler.resumeJob(jobKey);
    }

    /**
     * 删除一个job
     *
     * @param job
     * @throws SchedulerException
     */
    public void deleteJob(ScheduleJobVO job) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        scheduler.deleteJob(jobKey);

    }
    /**
     * 立即执行job
     *
     * @param job
     * @throws SchedulerException
     */
    public void runAJobNow(ScheduleJobVO job) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();
        JobKey jobKey = JobKey.jobKey(job.getJobName(), job.getJobGroup());
        scheduler.triggerJob(jobKey);
    }
    /**
     * 更新job时间表达式
     *
     * @param job
     * @throws SchedulerException
     */
    public void updateJobCron(ScheduleJobVO job) throws SchedulerException {
        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());

        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);

        CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getJobCron());

        trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();

        scheduler.rescheduleJob(triggerKey, trigger);
    }
}
