package cn.zyunc.ueasier.quartz.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import cn.zyunc.ueasier.quartz.qo.ScheduleJobQO;
import cn.zyunc.ueasier.quartz.vo.ScheduleJobVO;

/**
 * @Description: ScheduleJobDao
 * @author: saz
 * @date: 2017-08-11 16:18:44
 */
@Repository
public interface ScheduleJobDao {
    /**
     * 根据Id查询对象信息
     * 
     * @param id 对象Id
     * @return ScheduleJobVO 对象信息
     * @author: saz
     * @date: 2017-08-11 16:18:44
     */
    ScheduleJobVO getById(Long id);

    /**
     * 根据条件查询对象信息
     * 
     * @param qo ScheduleJobQO查询对象
     * @return ScheduleJobVO 对象信息
     * @author: saz
     * @date: 2017-08-11 16:18:44
     */
    ScheduleJobVO getByCondition(ScheduleJobQO qo);
    
    /**
     * 根据条件统计
     * 
     * @param qo ScheduleJobQO查询对象
     * @return long 记录条数
     * @author: saz
     * @date: 2017-08-11 16:18:44
     */
    long count(ScheduleJobQO qo);

    /**
     * 根据条件查询对象列表
     * 
     * @param qo ScheduleJobQO查询对象
     * @return List<ScheduleJobVO> ScheduleJobVO对象列表
     * @author: saz
     * @date: 2017-08-11 16:18:44
     */
    List<ScheduleJobVO> queryList(ScheduleJobQO qo);
    
    /**
     * 根据条件分页查询对象列表
     * 
     * @param qo ScheduleJobQO查询对象
     * @return List<ScheduleJobVO> ScheduleJobVO对象列表
     * @author: saz
     * @date: 2017-08-11 16:18:44
     */
    List<ScheduleJobVO> queryPage(ScheduleJobQO qo);

    /**
     * 保存对象信息
     * 
     * @param vo ScheduleJobVO对象信息
     * @author: saz
     * @date: 2017-08-11 16:18:44
     */
    void save(ScheduleJobVO vo);

    /**
     * 批量保存对象信息
     * 
     * @param voList ScheduleJobVO对象列表
     * @author: saz
     * @date: 2017-08-11 16:18:44
     */
    void saveBatch(List<ScheduleJobVO> voList);

    /**
     * 根据Id修改对象信息
     * 
     * @param vo ScheduleJobVO对象
     * @author: saz
     * @date: 2017-08-11 16:18:44
     */
    void updateById(ScheduleJobVO vo);
    
    /**
     * 根据Id删除对象信息
     * 
     * @param id ScheduleJobVO对象Id
     * @author: saz
     * @date: 2017-08-11 16:18:44
     */
    void deleteById(Long id);

    /**
     * 根据Id批量删除对象信息
     * 
     * @param ids ScheduleJobVO对象Id集合
     * @author: saz
     * @date: 2017-08-11 16:18:44
     */
    void deleteBatchByIds(List<Long> ids);
}
