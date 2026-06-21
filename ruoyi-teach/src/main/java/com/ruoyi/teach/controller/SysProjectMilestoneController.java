package com.ruoyi.teach.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.teach.domain.SysProjectMilestone;
import com.ruoyi.teach.service.ISysProjectMilestoneService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目里程碑Controller
 * 
 * @author ruoyi
 */
@Api(tags = "项目里程碑管理")
@RestController
@RequestMapping("/teach/project/milestone")
public class SysProjectMilestoneController extends BaseController {

    @Autowired
    private ISysProjectMilestoneService milestoneService;

    /**
     * 获取里程碑列表
     */
    @ApiOperation("获取里程碑列表")
    @PreAuthorize("@ss.hasPermi('teach:milestone:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysProjectMilestone milestone) {
        startPage();
        List<SysProjectMilestone> list = milestoneService.selectMilestoneList(milestone);
        return getDataTable(list);
    }

    /**
     * 获取里程碑详情
     */
    @ApiOperation("获取里程碑详情")
    @PreAuthorize("@ss.hasPermi('teach:milestone:query')")
    @GetMapping("/{milestoneId}")
    public AjaxResult getInfo(@PathVariable Long milestoneId) {
        return success(milestoneService.selectMilestoneById(milestoneId));
    }

    /**
     * 新增里程碑
     */
    @ApiOperation("新增里程碑")
    @PreAuthorize("@ss.hasPermi('teach:milestone:add')")
    @Log(title = "里程碑", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysProjectMilestone milestone) {
        return toAjax(milestoneService.insertMilestone(milestone));
    }

    /**
     * 修改里程碑
     */
    @ApiOperation("修改里程碑")
    @PreAuthorize("@ss.hasPermi('teach:milestone:edit')")
    @Log(title = "里程碑", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysProjectMilestone milestone) {
        return toAjax(milestoneService.updateMilestone(milestone));
    }

    /**
     * 删除里程碑
     */
    @ApiOperation("删除里程碑")
    @PreAuthorize("@ss.hasPermi('teach:milestone:remove')")
    @Log(title = "里程碑", businessType = BusinessType.DELETE)
    @DeleteMapping("/{milestoneIds}")
    public AjaxResult remove(@PathVariable Long[] milestoneIds) {
        return toAjax(milestoneService.deleteMilestoneByIds(milestoneIds));
    }
}
