package com.ruoyi.teach.service;

import com.ruoyi.teach.domain.entity.TeachProjectInfo;

import java.util.List;

public interface ITeachProjectInfoService {

    List<TeachProjectInfo> findByConditions(
            String prjName, String prjCode, String prjStatus,
            Integer pageNum, Integer pageSize);

    TeachProjectInfo findById(Integer id);

    int addProject(TeachProjectInfo projectInfo);

    int updateProject(TeachProjectInfo projectInfo);

    int deleteByIds(List<Integer> ids);
}
