package com.ruoyi.teach.mapper;

import java.util.List;
import com.ruoyi.teach.domain.SysProjectMember;

/**
 * 项目团队成员Mapper接口
 * 
 * @author ruoyi
 */
public interface SysProjectMemberMapper {

    /**
     * 查询团队成员列表
     */
    List<SysProjectMember> selectMemberList(SysProjectMember member);

    /**
     * 查询成员详情
     */
    SysProjectMember selectMemberById(Long memberId);

    /**
     * 新增成员
     */
    int insertMember(SysProjectMember member);

    /**
     * 修改成员
     */
    int updateMember(SysProjectMember member);

    /**
     * 删除成员
     */
    int deleteMemberById(Long memberId);

    /**
     * 批量删除成员
     */
    int deleteMemberByIds(Long[] memberIds);

    /**
     * 根据项目ID查询成员
     */
    List<SysProjectMember> selectMembersByProjectId(Long projectId);

    /**
     * 统计项目成员数（供association使用）
     */
    Integer countByProjectId(Long projectId);
}
