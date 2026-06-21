package com.ruoyi.teach.service;

import com.ruoyi.teach.domain.SysProjectMember;
import java.util.List;

/**
 * 项目团队成员Service接口
 * 
 * @author ruoyi
 */
public interface ISysProjectMemberService {

    /**
     * 查询成员列表
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
}
