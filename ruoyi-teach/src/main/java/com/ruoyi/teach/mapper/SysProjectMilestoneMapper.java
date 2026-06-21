package com.ruoyi.teach.mapper;

import java.util.List;
import com.ruoyi.teach.domain.SysProjectMilestone;

/**
 * 项目里程碑Mapper接口
 * 
 * @author ruoyi
 */
public interface SysProjectMilestoneMapper {

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

    /**
     * 根据项目ID查询里程碑
     */
    List<SysProjectMilestone> selectMilestonesByProjectId(Long projectId);

    /**
     * 统计项目已完成里程碑数（供association使用）
     */
    Integer countCompletedByProjectId(Long projectId);

    /**
     * 获取导出列表
     */
    List<SysProjectMilestone> selectMilestoneListForExport(SysProjectMilestone milestone);
}
