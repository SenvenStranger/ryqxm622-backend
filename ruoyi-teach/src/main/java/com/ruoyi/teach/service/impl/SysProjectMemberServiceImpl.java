package com.ruoyi.teach.service.impl;

import com.ruoyi.teach.domain.SysProjectMember;
import com.ruoyi.teach.mapper.SysProjectMemberMapper;
import com.ruoyi.teach.service.ISysProjectMemberService;
import com.ruoyi.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 项目团队成员Service实现
 * 
 * @author ruoyi
 */
@Service
public class SysProjectMemberServiceImpl implements ISysProjectMemberService {

    @Autowired
    private SysProjectMemberMapper memberMapper;

    @Override
    public List<SysProjectMember> selectMemberList(SysProjectMember member) {
        return memberMapper.selectMemberList(member);
    }

    @Override
    public SysProjectMember selectMemberById(Long memberId) {
        return memberMapper.selectMemberById(memberId);
    }

    @Override
    public int insertMember(SysProjectMember member) {
        member.setCreateBy(SecurityUtils.getUsername());
        return memberMapper.insertMember(member);
    }

    @Override
    public int updateMember(SysProjectMember member) {
        member.setUpdateBy(SecurityUtils.getUsername());
        return memberMapper.updateMember(member);
    }

    @Override
    public int deleteMemberById(Long memberId) {
        return memberMapper.deleteMemberById(memberId);
    }

    @Override
    public int deleteMemberByIds(Long[] memberIds) {
        return memberMapper.deleteMemberByIds(memberIds);
    }
}
