package com.ruoyi.teach.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.teach.domain.SysFallAlarm;
import com.ruoyi.teach.service.ISysFallAlarmService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 报警记录Controller
 *
 * @author ruoyi
 */
@Api(tags = "跌倒报警记录管理")
@RestController
@RequestMapping("/teach/fall/alarm")
public class SysFallAlarmController extends BaseController {

    @Autowired
    private ISysFallAlarmService alarmService;

    /**
     * 获取报警列表
     */
    @ApiOperation("获取报警列表")
    @PreAuthorize("@ss.hasPermi('teach:alarm:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysFallAlarm alarm) {
        startPage();
        List<SysFallAlarm> list = alarmService.selectAlarmList(alarm);
        return getDataTable(list);
    }

    /**
     * 导出报警列表
     */
    @ApiOperation("导出报警列表")
    @PreAuthorize("@ss.hasPermi('teach:alarm:export')")
    @Log(title = "报警记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysFallAlarm alarm) {
        List<SysFallAlarm> list = alarmService.selectAlarmListForExport(alarm);
        ExcelUtil<SysFallAlarm> util = new ExcelUtil<>(SysFallAlarm.class);
        util.exportExcel(response, list, "报警记录数据");
    }

    /**
     * 获取报警详细信息
     */
    @ApiOperation("获取报警详细信息")
    @PreAuthorize("@ss.hasPermi('teach:alarm:query')")
    @GetMapping("/{alarmId}")
    public AjaxResult getInfo(@PathVariable Long alarmId) {
        return success(alarmService.selectAlarmById(alarmId));
    }

    /**
     * 新增报警记录
     */
    @ApiOperation("新增报警")
    @Log(title = "报警记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysFallAlarm alarm) {
        return toAjax(alarmService.insertAlarm(alarm));
    }

    /**
     * 处理报警
     */
    @ApiOperation("处理报警")
    @PreAuthorize("@ss.hasPermi('teach:alarm:handle')")
    @Log(title = "报警处理", businessType = BusinessType.UPDATE)
    @PutMapping("/handle")
    public AjaxResult handle(@RequestBody SysFallAlarm alarm) {
        return toAjax(alarmService.handleAlarm(alarm.getAlarmId(), alarm.getAlarmStatus(), alarm.getHandleResult()));
    }

    /**
     * 删除报警
     */
    @ApiOperation("删除报警")
    @PreAuthorize("@ss.hasPermi('teach:alarm:remove')")
    @Log(title = "报警记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{alarmIds}")
    public AjaxResult remove(@PathVariable Long[] alarmIds) {
        return toAjax(alarmService.deleteAlarmByIds(alarmIds));
    }

    /**
     * 获取报警统计
     */
    @ApiOperation("获取报警统计")
    @PreAuthorize("@ss.hasPermi('teach:alarm:statistics')")
    @GetMapping("/statistics")
    public AjaxResult statistics() {
        return success(alarmService.getAlarmStatistics());
    }

    /**
     * 获取今日报警
     */
    @ApiOperation("获取今日报警")
    @PreAuthorize("@ss.hasPermi('teach:alarm:list')")
    @GetMapping("/today")
    public AjaxResult today() {
        return success(alarmService.selectTodayAlarms());
    }

    /**
     * 设备上报报警接口（供设备调用）
     */
    @ApiOperation("设备上报报警")
    @PostMapping("/report")
    public AjaxResult report(@RequestBody SysFallAlarm alarm) {
        return toAjax(alarmService.insertAlarm(alarm));
    }
}
