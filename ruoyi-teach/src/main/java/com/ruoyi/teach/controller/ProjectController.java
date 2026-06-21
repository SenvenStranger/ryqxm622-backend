package com.ruoyi.teach.controller;

import com.ruoyi.common.core.controller.TeachBaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.teach.domain.entity.TeachProjectInfo;
import com.ruoyi.teach.service.ITeachProjectInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/ProjectInfo")
public class ProjectController extends TeachBaseController {

    private final ITeachProjectInfoService projectInfoService;

    /**
     * 分页查询项目列表
     * GET /ProjectInfo/list
     */
    @GetMapping("/list")
    public AjaxResult list(
            @RequestParam(value = "PrjName", required = false) String prjName,
            @RequestParam(value = "PrjCode", required = false) String prjCode,
            @RequestParam(value = "PrjStatus", required = false) String prjStatus,
            @RequestParam(value = "pageNum", required = false) Integer pageNum,
            @RequestParam(value = "pageSize", required = false) Integer pageSize
    ) {
        startPage(pageNum, pageSize);
        return getPagedData(
                projectInfoService.findByConditions(prjName, prjCode, prjStatus, pageNum, pageSize),
                pageNum,
                pageSize
        );
    }

    /**
     * 根据ID查询项目详情
     * GET /ProjectInfo/detail?Id=1
     */
    @GetMapping("/detail")
    public AjaxResult detail(@RequestParam("Id") Integer id) {
        return success(projectInfoService.findById(id));
    }

    /**
     * 新增项目
     * POST /ProjectInfo/add
     */
    @PostMapping("/add")
    public AjaxResult add(@RequestBody TeachProjectInfo projectInfo) {
        return toAjax(projectInfoService.addProject(projectInfo));
    }

    /**
     * 修改项目
     * POST /ProjectInfo/update
     */
    @PostMapping("/update")
    public AjaxResult update(@RequestBody TeachProjectInfo projectInfo) {
        return toAjax(projectInfoService.updateProject(projectInfo));
    }

    /**
     * 批量删除项目
     * POST /ProjectInfo/delete
     * 请求体: [1, 2, 3] 或单个数字
     */
    @PostMapping("/delete")
    public AjaxResult delete(@RequestBody List<Integer> ids) {
        return toAjax(projectInfoService.deleteByIds(ids));
    }
}
