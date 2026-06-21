package com.ruoyi.teach.service;

import com.ruoyi.teach.domain.SysFallDevice;
import java.util.List;

/**
 * 设备Service接口
 *
 * @author ruoyi
 */
public interface ISysFallDeviceService {

    /**
     * 查询设备
     */
    SysFallDevice selectDeviceById(Long deviceId);

    /**
     * 根据设备编码查询
     */
    SysFallDevice selectDeviceByCode(String deviceCode);

    /**
     * 查询设备列表
     */
    List<SysFallDevice> selectDeviceList(SysFallDevice device);

    /**
     * 查询所有设备
     */
    List<SysFallDevice> selectDeviceAll();

    /**
     * 新增设备
     */
    int insertDevice(SysFallDevice device);

    /**
     * 修改设备
     */
    int updateDevice(SysFallDevice device);

    /**
     * 删除设备
     */
    int deleteDeviceById(Long deviceId);

    /**
     * 批量删除设备
     */
    int deleteDeviceByIds(Long[] deviceIds);

    /**
     * 更新设备心跳
     */
    int updateHeartbeat(Long deviceId);

    /**
     * 导出设备列表
     */
    List<SysFallDevice> selectDeviceListForExport(SysFallDevice device);
}
