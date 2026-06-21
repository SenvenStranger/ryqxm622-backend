package com.ruoyi.teach.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.teach.domain.SysProjectMember;
import com.ruoyi.teach.service.ISysProjectMemberService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目团队成员Controller
 * 
 * @author ruoyi
 */
@Api(tags = "项目团队成员管理")
@RestController
@RequestMapping("/teach/project/member")
public class SysProjectMemberController extends BaseController {

    @Autowired
    private ISysProjectMemberService memberService;

    /**
     * 获取成员列表
     */
    @ApiOperation("获取成员列表")
    @PreAuthorize("@ss.hasPermi('teach:member:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysProjectMember member) {
        startPage();
        List<SysProjectMember> list = memberService.selectMemberList(member);
        return getDataTable(list);
    }

    /**
     * 获取成员详情
     */
    @ApiOperation("获取成员详情")
    @PreAuthorize("@ss.hasPermi('teach:member:query')")
    @GetMapping("/{memberId}")
    public AjaxResult getInfo(@PathVariable Long memberId) {
        return success(memberService.selectMemberById(memberId));
    }

    /**
     * 新增成员
     */
    @ApiOperation("新增成员")
    @PreAuthorize("@ss.hasPermi('teach:member:add')")
    @Log(title = "团队成员", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysProjectMember member) {
        return toAjax(memberService.insertMember(member));
    }

    /**
     * 修改成员
     */
    @ApiOperation("修改成员")
    @PreAuthorize("@ss.hasPermi('teach:member:edit')")
    @Log(title = "团队成员", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysProjectMember member) {
        return toAjax(memberService.updateMember(member));
    }

    /**
     * 删除成员
     */
    @ApiOperation("删除成员")
    @PreAuthorize("@ss.hasPermi('teach:member:remove')")
    @Log(title = "团队成员", businessType = BusinessType.DELETE)
    @DeleteMapping("/{memberIds}")
    public AjaxResult remove(@PathVariable Long[] memberIds) {
        return toAjax(memberService.deleteMemberByIds(memberIds));
    }
}
