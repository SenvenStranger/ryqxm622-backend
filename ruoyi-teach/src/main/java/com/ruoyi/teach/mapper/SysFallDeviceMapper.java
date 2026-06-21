package com.ruoyi.teach.mapper;

import com.ruoyi.teach.domain.SysFallDevice;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 设备Mapper接口
 * 
 * @author ruoyi
 */
public interface SysFallDeviceMapper {

    /**
     * 根据设备ID查询
     */
    SysFallDevice selectDeviceById(@Param("deviceId") Long deviceId);

    /**
     * 根据设备编码查询
     */
    SysFallDevice selectByDeviceCode(@Param("deviceCode") String deviceCode);

    /**
     * 查询设备列表
     */
    List<SysFallDevice> selectDeviceList(SysFallDevice device);

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
    int deleteDeviceById(@Param("deviceId") Long deviceId);

    /**
     * 批量删除设备
     */
    int deleteDeviceByIds(@Param("deviceIds") Long[] deviceIds);

    /**
     * 更新设备心跳
     */
    int updateHeartbeat(@Param("deviceId") Long deviceId);

    /**
     * 更新设备状态
     */
    int updateDeviceStatus(@Param("deviceId") Long deviceId, @Param("status") String status);
}
