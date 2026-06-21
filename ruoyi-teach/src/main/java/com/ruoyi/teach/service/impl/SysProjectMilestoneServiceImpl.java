package com.ruoyi.teach.service.impl;

import com.ruoyi.teach.domain.SysProjectMilestone;
import com.ruoyi.teach.mapper.SysProjectMilestoneMapper;
import com.ruoyi.teach.service.ISysProjectMilestoneService;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 项目里程碑Service实现
 * 
 * @author ruoyi
 */
@Service
public class SysProjectMilestoneServiceImpl implements ISysProjectMilestoneService {

    @Autowired
    private SysProjectMilestoneMapper milestoneMapper;

    @Override
    public List<SysProjectMilestone> selectMilestoneList(SysProjectMilestone milestone) {
        return milestoneMapper.selectMilestoneList(milestone);
    }

    @Override
    public SysProjectMilestone selectMilestoneById(Long milestoneId) {
        return milestoneMapper.selectMilestoneById(milestoneId);
    }

    @Override
    public int insertMilestone(SysProjectMilestone milestone) {
        milestone.setCreateBy(SecurityUtils.getUsername());
        return milestoneMapper.insertMilestone(milestone);
    }

    @Override
    public int updateMilestone(SysProjectMilestone milestone) {
        milestone.setUpdateBy(SecurityUtils.getUsername());
        return milestoneMapper.updateMilestone(milestone);
    }

    @Override
    public int deleteMilestoneById(Long milestoneId) {
        return milestoneMapper.deleteMilestoneById(milestoneId);
    }

    @Override
    public int deleteMilestoneByIds(Long[] milestoneIds) {
        return milestoneMapper.deleteMilestoneByIds(milestoneIds);
    }
}
