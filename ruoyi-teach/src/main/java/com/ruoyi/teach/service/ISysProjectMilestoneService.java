package com.ruoyi.teach.service;

import com.ruoyi.teach.domain.SysProjectMilestone;
import java.util.List;

/**
 * 项目里程碑Service接口
 * 
 * @author ruoyi
 */
public interface ISysProjectMilestoneService {

    /**
     * 查询里程碑列表
     */
    List<SysProjectMilestone> selectMilestoneList(SysProjectMilestone milestone);

    /**
     * 查询里程碑详情
     */
    SysProjectMilestone selectMilestoneById(Long milestoneId);

    /**
     * 新增里程碑
     */
    int insertMilestone(SysProjectMilestone milestone);

    /**
     * 修改里程碑
     */
    int updateMilestone(SysProjectMilestone milestone);

    /**
     * 删除里程碑
     */
    int deleteMilestoneById(Long milestoneId);

    /**
     * 批量删除里程碑
     */
    int deleteMilestoneByIds(Long[] milestoneIds);
}
