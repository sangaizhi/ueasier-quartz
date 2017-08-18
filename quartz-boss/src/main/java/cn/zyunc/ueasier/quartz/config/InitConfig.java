package cn.zyunc.ueasier.quartz.config;

import java.util.List;
import java.util.Objects;

import cn.zyunc.ueasier.quartz.constants.IsConcurrent;
import cn.zyunc.ueasier.quartz.constants.JobStatus;
import org.quartz.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import cn.zyunc.ueasier.quartz.model.ScheduleJob;
import cn.zyunc.ueasier.quartz.qo.ScheduleJobQO;
import cn.zyunc.ueasier.quartz.service.impl.ScheduleJobServiceImpl;
import cn.zyunc.ueasier.quartz.vo.ScheduleJobVO;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * @author sangaizhi
 * @date 2017/8/11
 */
public class InitConfig implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private SchedulerFactoryBean schedulerFactoryBean;

	@Autowired
	private JobManager jobManager;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		try {
			ApplicationContext applicationContext = event.getApplicationContext();
			ScheduleJobServiceImpl scheduleJobService = (ScheduleJobServiceImpl) applicationContext
				.getBean("scheduleJobService");
			if (null == applicationContext.getParent()) {
				// 区分 spring 和 springMVC的父子容器，避免同一个 job 会被加载两次
				List<ScheduleJobVO> jobList = scheduleJobService.queryList(new ScheduleJobQO());
				for (ScheduleJobVO job : jobList) {
					ScheduleJob scheduleJob = new ScheduleJob();
					BeanUtils.copyProperties(job, scheduleJob);
					jobManager.addJob(scheduleJob);
				}
			}
		} catch (SchedulerException e) {
			e.printStackTrace();
		}
	}
	public void addJob(ScheduleJob job) throws SchedulerException {
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
}
