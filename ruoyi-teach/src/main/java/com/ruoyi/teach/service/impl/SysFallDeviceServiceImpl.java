package com.ruoyi.teach.service.impl;

import com.ruoyi.teach.domain.SysFallDevice;
import com.ruoyi.teach.mapper.SysFallDeviceMapper;
import com.ruoyi.teach.service.ISysFallDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 设备Service实现
 *
 * @author ruoyi
 */
@Service
public class SysFallDeviceServiceImpl implements ISysFallDeviceService {

    @Autowired
    private SysFallDeviceMapper deviceMapper;

    /**
     * 查询设备
     */
    @Override
    public SysFallDevice selectDeviceById(Long deviceId) {
        return deviceMapper.selectDeviceById(deviceId);
    }

    /**
     * 根据设备编码查询
     */
    @Override
    public SysFallDevice selectDeviceByCode(String deviceCode) {
        return deviceMapper.selectByDeviceCode(deviceCode);
    }

    /**
     * 查询设备列表
     */
    @Override
    public List<SysFallDevice> selectDeviceList(SysFallDevice device) {
        return deviceMapper.selectDeviceList(device);
    }

    /**
     * 查询所有设备
     */
    @Override
    public List<SysFallDevice> selectDeviceAll() {
        return deviceMapper.selectDeviceList(new SysFallDevice());
    }

    /**
     * 新增设备
     */
    @Override
    public int insertDevice(SysFallDevice device) {
        return deviceMapper.insertDevice(device);
    }

    /**
     * 修改设备
     */
    @Override
    public int updateDevice(SysFallDevice device) {
        return deviceMapper.updateDevice(device);
    }

    /**
     * 删除设备
     */
    @Override
    public int deleteDeviceById(Long deviceId) {
        return deviceMapper.deleteDeviceById(deviceId);
    }

    /**
     * 批量删除设备
     */
    @Override
    public int deleteDeviceByIds(Long[] deviceIds) {
        return deviceMapper.deleteDeviceByIds(deviceIds);
    }

    /**
     * 更新设备心跳
     */
    @Override
    public int updateHeartbeat(Long deviceId) {
        return deviceMapper.updateHeartbeat(deviceId);
    }

    /**
     * 导出设备列表
     */
    @Override
    public List<SysFallDevice> selectDeviceListForExport(SysFallDevice device) {
        return deviceMapper.selectDeviceList(device);
    }
}
