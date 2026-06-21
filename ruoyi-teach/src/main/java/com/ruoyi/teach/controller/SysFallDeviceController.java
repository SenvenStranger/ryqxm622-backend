package com.ruoyi.teach.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.teach.domain.SysFallDevice;
import com.ruoyi.teach.service.ISysFallDeviceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 设备管理Controller
 *
 * @author ruoyi
 */
@Api(tags = "跌倒报警设备管理")
@RestController
@RequestMapping("/teach/fall/device")
public class SysFallDeviceController extends BaseController {

    @Autowired
    private ISysFallDeviceService deviceService;

    /**
     * 获取设备列表
     */
    @ApiOperation("获取设备列表")
    @PreAuthorize("@ss.hasPermi('teach:device:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysFallDevice device) {
        startPage();
        List<SysFallDevice> list = deviceService.selectDeviceList(device);
        return getDataTable(list);
    }

    /**
     * 导出设备列表
     */
    @ApiOperation("导出设备列表")
    @PreAuthorize("@ss.hasPermi('teach:device:export')")
    @Log(title = "设备管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysFallDevice device) {
        List<SysFallDevice> list = deviceService.selectDeviceListForExport(device);
        ExcelUtil<SysFallDevice> util = new ExcelUtil<>(SysFallDevice.class);
        util.exportExcel(response, list, "设备数据");
    }

    /**
     * 获取设备详细信息
     */
    @ApiOperation("获取设备详细信息")
    @PreAuthorize("@ss.hasPermi('teach:device:query')")
    @GetMapping("/{deviceId}")
    public AjaxResult getInfo(@PathVariable Long deviceId) {
        return success(deviceService.selectDeviceById(deviceId));
    }

    /**
     * 新增设备
     */
    @ApiOperation("新增设备")
    @PreAuthorize("@ss.hasPermi('teach:device:add')")
    @Log(title = "设备管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@Validated @RequestBody SysFallDevice device) {
        // 检查设备编码是否已存在
        if (deviceService.selectDeviceByCode(device.getDeviceCode()) != null) {
            return error("设备编码已存在");
        }
        return toAjax(deviceService.insertDevice(device));
    }

    /**
     * 修改设备
     */
    @ApiOperation("修改设备")
    @PreAuthorize("@ss.hasPermi('teach:device:edit')")
    @Log(title = "设备管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@Validated @RequestBody SysFallDevice device) {
        return toAjax(deviceService.updateDevice(device));
    }

    /**
     * 删除设备
     */
    @ApiOperation("删除设备")
    @PreAuthorize("@ss.hasPermi('teach:device:remove')")
    @Log(title = "设备管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{deviceIds}")
    public AjaxResult remove(@PathVariable Long[] deviceIds) {
        return toAjax(deviceService.deleteDeviceByIds(deviceIds));
    }

    /**
     * 设备心跳接口（供设备调用）
     */
    @ApiOperation("设备心跳")
    @PostMapping("/heartbeat/{deviceCode}")
    public AjaxResult heartbeat(@PathVariable String deviceCode) {
        SysFallDevice device = deviceService.selectDeviceByCode(deviceCode);
        if (device == null) {
            return error("设备不存在");
        }
        deviceService.updateHeartbeat(device.getDeviceId());
        return success();
    }

    /**
     * 获取所有设备（用于下拉选择）
     */
    @ApiOperation("获取所有设备")
    @GetMapping("/all")
    public AjaxResult all() {
        return success(deviceService.selectDeviceAll());
    }
}
