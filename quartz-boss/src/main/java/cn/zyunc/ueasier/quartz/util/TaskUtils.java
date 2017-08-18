package cn.zyunc.ueasier.quartz.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.zyunc.ueasier.quartz.model.ScheduleJob;

public class TaskUtils {


	public final static Logger log = LoggerFactory.getLogger(TaskUtils.class);

	/**
	 * 通过反射调用scheduleJob中定义的方法
	 * 
	 * @param scheduleJob
	 */
	public static void execute(ScheduleJob scheduleJob) {
		Object object = null;
		Class clazz = null;
		if (StringUtils.isNotBlank(scheduleJob.getJobSpringId())) {
			object = SpringUtils.getBean(scheduleJob.getJobSpringId());
		} else if (StringUtils.isNotBlank(scheduleJob.getJobClass())) {
			try {
				clazz = Class.forName(scheduleJob.getJobClass()); // TestExecutor
				// 任务执行器的实例对象
				Map<String, Class> map = SpringUtils.getBeansByType(clazz); // TestExecutor instance
				if(null != map){
					object = map.values().iterator().next();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block  
				e.printStackTrace();
			}
		}
		if (object == null) {
			log.error("任务名称【{}】未启动成功，请检查是否配置正确！", scheduleJob.getJobName());
			return;
		}
		clazz = object.getClass();
		Method method = null;
		try {
			method = clazz.getDeclaredMethod(scheduleJob.getJobMethod());
		} catch (NoSuchMethodException e) {
			log.error("任务名称【{}】未启动成功，方法名设置错误！", scheduleJob.getJobName());
		} catch (SecurityException e) {
			log.error("任务名称【{}】未启动成功，方法名设置错误！", scheduleJob.getJobName());
			e.printStackTrace();
		}
		if (method != null) {
			try {
				method.invoke(object);
			} catch (IllegalAccessException e) {
				log.error("任务名称【{}】执行失败！", scheduleJob.getJobName());
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				log.error("任务名称【{}】执行失败！参数错误", scheduleJob.getJobName());
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				log.error("任务名称【{}】执行失败！反射调用失败", scheduleJob.getJobName());
				e.printStackTrace();
			}
		}

	}
}