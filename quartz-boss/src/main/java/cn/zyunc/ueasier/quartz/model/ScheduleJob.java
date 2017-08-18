package cn.zyunc.ueasier.quartz.model;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: ScheduleJob 值对象
 * @author: saz
 * @date: 2017-08-11 16:18:44
 */
public class ScheduleJob implements Serializable {

    
    /**
     * 作业ID 
     */
    private Long jobId;
    
    /**
     * 作业名称 
     */
    private String jobName;
    
    /**
     * 作业分组 
     */
    private String jobGroup;
    
    /**
     * 作业状态：是否启动作业 
     */
    private String jobStatus;
    
    /**
     * 作业的 cron 表达式 
     */
    private String jobCron;
    
    /**
     * 作业描述 
     */
    private String jobDesc;
    
    /**
     * 作业执行的类名 
     */
    private String jobClass;
    
    /**
     * 作业执行的方法名 
     */
    private String jobMethod;
    
    /**
     * 任务是否有状态 
     */
    private String jobIsConcurrent;
    
    /**
     * 任务执行的springbean 
     */
    private String jobSpringId;
    
    /**
     * 作业创建时间 
     */
    private Date createTime;
    
    /**
     * 作业更新时间 
     */
    private Date updateTime;

    
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public Long getJobId() {
        return this.jobId;
    }
    
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobName() {
        return this.jobName;
    }
    
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobGroup() {
        return this.jobGroup;
    }
    
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getJobStatus() {
        return this.jobStatus;
    }
    
    public void setJobCron(String jobCron) {
        this.jobCron = jobCron;
    }

    public String getJobCron() {
        return this.jobCron;
    }
    
    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobDesc() {
        return this.jobDesc;
    }
    
    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }

    public String getJobClass() {
        return this.jobClass;
    }
    
    public void setJobMethod(String jobMethod) {
        this.jobMethod = jobMethod;
    }

    public String getJobMethod() {
        return this.jobMethod;
    }
    
    public void setJobIsConcurrent(String jobIsConcurrent) {
        this.jobIsConcurrent = jobIsConcurrent;
    }

    public String getJobIsConcurrent() {
        return this.jobIsConcurrent;
    }
    
    public void setJobSpringId(String jobSpringId) {
        this.jobSpringId = jobSpringId;
    }

    public String getJobSpringId() {
        return this.jobSpringId;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }
}

