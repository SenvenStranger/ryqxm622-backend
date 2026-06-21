package com.ruoyi.teach.mapper;

import java.util.List;
import java.util.Map;
import com.ruoyi.teach.domain.SysScientificProject;

/**
 * 科研项目Mapper接口
 * 
 * @author ruoyi
 */
public interface SysScientificProjectMapper {

    /**
     * 查询科研项目列表
     */
    List<SysScientificProject> selectProjectList(SysScientificProject project);

    /**
     * 查询项目详情
     */
    SysScientificProject selectProjectById(Long projectId);

    /**
     * 根据编号查询
     */
    SysScientificProject selectProjectByCode(String projectCode);

    /**
     * 新增项目
     */
    int insertProject(SysScientificProject project);

    /**
     * 修改项目
     */
    int updateProject(SysScientificProject project);

    /**
     * 删除项目
     */
    int deleteProjectById(Long projectId);

    /**
     * 批量删除项目
     */
    int deleteProjectByIds(Long[] projectIds);

    /**
     * 查询所有项目(下拉选择用)
     */
    List<SysScientificProject> selectProjectAll();

    /**
     * 获取项目统计数据
     */
    Map<String, Object> selectProjectStatistics();

    /**
     * 获取导出列表
     */
    List<SysScientificProject> selectProjectListForExport(SysScientificProject project);
}
