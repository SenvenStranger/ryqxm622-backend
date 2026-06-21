package com.ruoyi.teach.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.teach.domain.SysScientificProject;
import com.ruoyi.teach.mapper.SysScientificProjectMapper;
import com.ruoyi.teach.service.ISysScientificProjectService;
import com.ruoyi.common.utils.SecurityUtils;

/**
 * 科研项目Service实现
 * 
 * @author ruoyi
 */
@Service
public class SysScientificProjectServiceImpl implements ISysScientificProjectService {

    @Autowired
    private SysScientificProjectMapper projectMapper;

    @Override
    public List<SysScientificProject> selectProjectList(SysScientificProject project) {
        return projectMapper.selectProjectList(project);
    }

    @Override
    public SysScientificProject selectProjectById(Long projectId) {
        return projectMapper.selectProjectById(projectId);
    }

    @Override
    public SysScientificProject selectProjectByCode(String projectCode) {
        return projectMapper.selectProjectByCode(projectCode);
    }

    @Override
    public int insertProject(SysScientificProject project) {
        project.setCreateBy(SecurityUtils.getUsername());
        return projectMapper.insertProject(project);
    }

    @Override
    public int updateProject(SysScientificProject project) {
        project.setUpdateBy(SecurityUtils.getUsername());
        return projectMapper.updateProject(project);
    }

    @Override
    public int deleteProjectById(Long projectId) {
        return projectMapper.deleteProjectById(projectId);
    }

    @Override
    public int deleteProjectByIds(Long[] projectIds) {
        return projectMapper.deleteProjectByIds(projectIds);
    }

    @Override
    public List<SysScientificProject> selectProjectAll() {
        return projectMapper.selectProjectAll();
    }

    @Override
    public Map<String, Object> getProjectStatistics() {
        return projectMapper.selectProjectStatistics();
    }

    @Override
    public List<SysScientificProject> selectProjectListForExport(SysScientificProject project) {
        return projectMapper.selectProjectListForExport(project);
    }
}
