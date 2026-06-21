package com.ruoyi.teach.service.impl;

import com.ruoyi.teach.domain.entity.TeachProjectInfo;
import com.ruoyi.teach.mapper.TeachProjectInfoMapper;
import com.ruoyi.teach.service.ITeachProjectInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeachProjectInfoServiceImpl implements ITeachProjectInfoService {

    private final TeachProjectInfoMapper teachProjectInfoMapper;

    @Override
    public List<TeachProjectInfo> findByConditions(String prjName, String prjCode, String prjStatus,
                                                   Integer pageNum, Integer pageSize) {
        if (pageNum == null || pageSize == null) {
            return Collections.emptyList();
        }
        return teachProjectInfoMapper.findByConditions(prjName, prjCode, prjStatus, pageNum, pageSize);
    }

    @Override
    public TeachProjectInfo findById(Integer id) {
        return teachProjectInfoMapper.findById(id);
    }

    @Override
    public int addProject(TeachProjectInfo projectInfo) {
        return teachProjectInfoMapper.insert(projectInfo);
    }

    @Override
    public int updateProject(TeachProjectInfo projectInfo) {
        return teachProjectInfoMapper.update(projectInfo);
    }

    @Override
    public int deleteByIds(List<Integer> ids) {
        return teachProjectInfoMapper.deleteByIds(ids);
    }
}
