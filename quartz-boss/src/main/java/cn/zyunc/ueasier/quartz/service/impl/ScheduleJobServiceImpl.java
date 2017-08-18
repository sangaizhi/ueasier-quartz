package cn.zyunc.ueasier.quartz.service.impl;

import java.util.List;

import cn.zyunc.ueasier.quartz.model.ScheduleJob;
import cn.zyunc.ueasier.quartz.test.service.OrderService;
import cn.zyunc.ueasier.quartz.util.TaskUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cn.zyunc.ueasier.quartz.qo.ScheduleJobQO;
import cn.zyunc.ueasier.quartz.vo.ScheduleJobVO;
import cn.zyunc.ueasier.quartz.dao.ScheduleJobDao;

/**
 * @Description: ScheduleJobService 实现类
 * @author: saz
 * @date: 2017-08-11 16:18:44
 */
public class ScheduleJobServiceImpl {

    @Autowired
    private ScheduleJobDao scheduleJobDao;

    @Autowired
    private OrderService orderService;

   
    @Transactional(readOnly = true)
    public ScheduleJobVO getById(Long id) {
        if (id == null) {
            return null;
        }
        return scheduleJobDao.getById(id);
    }
    
   
    @Transactional(readOnly = true)
    public ScheduleJobVO getByCondition(ScheduleJobQO qo) {
        if (qo == null) {
            return null;
        }
        return scheduleJobDao.getByCondition(qo);
    }

   
    @Transactional(readOnly = true)
    public List<ScheduleJobVO> queryList(ScheduleJobQO qo) {
        if (qo == null) {
            return null;
        }
        return scheduleJobDao.queryList(qo);
    }
    
   
    @Transactional(readOnly = true)
    public long count(ScheduleJobQO qo) {
        if (qo == null) {
            return 0;
        }
        return scheduleJobDao.count(qo);
    }
    
   
    @Transactional(readOnly = true)
    public List<ScheduleJobVO> queryPage(ScheduleJobQO qo) {
        if (qo == null) {
            return null;
        }
        return scheduleJobDao.queryPage(qo); 
    }

   
    public void save(ScheduleJobVO vo) {
        if (vo == null) {
            return;
        }
        scheduleJobDao.save(vo);
    }

   
    public void saveBatch(List<ScheduleJobVO> voList) {
        if (CollectionUtils.isEmpty(voList)) {
            return;
        }
        scheduleJobDao.saveBatch(voList);
    }

   
    public void updateById(ScheduleJobVO vo) {
        if (vo == null) {
            return;
        }
        scheduleJobDao.updateById(vo);
    }

   
    public void deleteById(Long id) {
        if (id == null) {
            return;
        }
        scheduleJobDao.deleteById(id);
    }

   
    public void deleteBatchByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)) {
            return;
        }
        scheduleJobDao.deleteBatchByIds(ids);
    }

   
    public void execute(Long id) throws Exception {
        ScheduleJobVO jobVO = this.getById(id);
        if(null == jobVO){
            throw new Exception("没有找到对应的任务");
        }
        ScheduleJob job = new ScheduleJob();
        BeanUtils.copyProperties(jobVO, job);
//        orderService.readAndSaveFromFile("C:\\Users\\Admin\\Desktop\\testFile.txt");
        TaskUtils.execute(job);
    }
}
