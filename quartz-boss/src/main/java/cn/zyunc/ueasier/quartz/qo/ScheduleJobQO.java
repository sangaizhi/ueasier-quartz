package cn.zyunc.ueasier.quartz.qo;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: ScheduleJobQO 查询对象
 * @author: saz
 * @date: 2017-08-11 16:18:44
 */
public class ScheduleJobQO implements Serializable {

    
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
     * 作业创建时间
     */
    private Date createTimeBegin;

    /**
     * 作业创建时间
     */
    private Date createTimeEnd;
    /**
     * 作业更新时间
     */
    private Date updateTime;
    
    /**
     * 作业更新时间
     */
    private Date updateTimeBegin;

    /**
     * 作业更新时间
     */
    private Date updateTimeEnd;
    
    public Long getJobId() {
        return this.jobId;
    }
    
    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }
    
    public String getJobName() {
        return this.jobName;
    }
    
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }
    
    public String getJobGroup() {
        return this.jobGroup;
    }
    
    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }
    
    public String getJobStatus() {
        return this.jobStatus;
    }
    
    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }
    
    public String getJobCron() {
        return this.jobCron;
    }
    
    public void setJobCron(String jobCron) {
        this.jobCron = jobCron;
    }
    
    public String getJobDesc() {
        return this.jobDesc;
    }
    
    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }
    
    public String getJobClass() {
        return this.jobClass;
    }
    
    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }
    
    public String getJobMethod() {
        return this.jobMethod;
    }
    
    public void setJobMethod(String jobMethod) {
        this.jobMethod = jobMethod;
    }
    
    public String getJobIsConcurrent() {
        return this.jobIsConcurrent;
    }
    
    public void setJobIsConcurrent(String jobIsConcurrent) {
        this.jobIsConcurrent = jobIsConcurrent;
    }
    
    public String getJobSpringId() {
        return this.jobSpringId;
    }
    
    public void setJobSpringId(String jobSpringId) {
        this.jobSpringId = jobSpringId;
    }
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }  
    
    public Date getCreateTimeBegin() {
        return this.createTimeBegin;
    }
    
    public void setCreateTimeBegin(Date createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }    
    
    public Date getCreateTimeEnd() {
        return this.createTimeEnd;
    }
    
    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }
    public Date getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }  
    
    public Date getUpdateTimeBegin() {
        return this.updateTimeBegin;
    }
    
    public void setUpdateTimeBegin(Date updateTimeBegin) {
        this.updateTimeBegin = updateTimeBegin;
    }    
    
    public Date getUpdateTimeEnd() {
        return this.updateTimeEnd;
    }
    
    public void setUpdateTimeEnd(Date updateTimeEnd) {
        this.updateTimeEnd = updateTimeEnd;
    }
}
