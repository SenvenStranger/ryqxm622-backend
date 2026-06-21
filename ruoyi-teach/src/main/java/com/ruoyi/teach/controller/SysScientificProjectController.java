package com.ruoyi.teach.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.teach.domain.SysScientificProject;
import com.ruoyi.teach.service.ISysScientificProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 科研项目管理Controller
 * 
 * @author ruoyi
 */
@Api(tags = "科研项目管理")
@RestController
@RequestMapping("/teach/scientific/project")
public class SysScientificProjectController extends BaseController {

    @Autowired
    private ISysScientificProjectService projectService;

    /**
     * 获取项目列表
     */
    @ApiOperation("获取项目列表")
    @PreAuthorize("@ss.hasPermi('teach:project:query')")
    @GetMapping("/list")
    public TableDataInfo list(SysScientificProject project) {
        startPage();
        List<SysScientificProject> list = projectService.selectProjectList(project);
        return getDataTable(list);
    }

    /**
     * 导出项目列表
     */
    @ApiOperation("导出项目列表")
    @PreAuthorize("@ss.hasPermi('teach:project:export')")
    @Log(title = "项目管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysScientificProject project) {
        List<SysScientificProject> list = projectService.selectProjectListForExport(project);
        ExcelUtil<SysScientificProject> util = new ExcelUtil<>(SysScientificProject.class);
        util.exportExcel(response, list, "科研项目数据");
    }

    /**
     * 获取项目详细信息
     */
    @ApiOperation("获取项目详细信息")
    @PreAuthorize("@ss.hasPermi('teach:project:query')")
    @GetMapping("/{projectId}")
    public AjaxResult getInfo(@PathVariable Long projectId) {
        return success(projectService.selectProjectById(projectId));
    }

    /**
     * 新增项目
     */
    @ApiOperation("新增项目")
    @PreAuthorize("@ss.hasPermi('teach:project:add')")
    @Log(title = "项目管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysScientificProject project) {
        if (projectService.selectProjectByCode(project.getProjectCode()) != null) {
            return error("项目编号已存在");
        }
        return toAjax(projectService.insertProject(project));
    }

    /**
     * 修改项目
     */
    @ApiOperation("修改项目")
    @PreAuthorize("@ss.hasPermi('teach:project:edit')")
    @Log(title = "项目管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysScientificProject project) {
        return toAjax(projectService.updateProject(project));
    }

    /**
     * 删除项目
     */
    @ApiOperation("删除项目")
    @PreAuthorize("@ss.hasPermi('teach:project:remove')")
    @Log(title = "项目管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{projectIds}")
    public AjaxResult remove(@PathVariable Long[] projectIds) {
        return toAjax(projectService.deleteProjectByIds(projectIds));
    }

    /**
     * 获取所有项目(下拉选择)
     */
    @ApiOperation("获取所有项目")
    @GetMapping("/all")
    public AjaxResult all() {
        return success(projectService.selectProjectAll());
    }

    /**
     * 获取项目统计
     */
    @ApiOperation("获取项目统计")
    @GetMapping("/statistics")
    public AjaxResult statistics() {
        return success(projectService.getProjectStatistics());
    }
}
