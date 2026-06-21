package com.ruoyi.teach.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 跌倒报警设备对象 sys_fall_device
 *
 * @author ruoyi
 */
@Data
public class SysFallDevice implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 设备ID */
    private Long deviceId;

    /** 设备名称 */
    private String deviceName;

    /** 设备编码 */
    private String deviceCode;

    /** 设备类型: wearable-穿戴式, camera-摄像头, ambient-环境传感器 */
    private String deviceType;

    /** 设备型号 */
    private String deviceModel;

    /** 生产厂家 */
    private String manufacturer;

    /** MAC地址 */
    private String macAddress;

    /** IP地址 */
    private String ipAddress;

    /** 经度 */
    private BigDecimal longitude;

    /** 纬度 */
    private BigDecimal latitude;

    /** 安装位置 */
    private String location;

    /** 绑定用户ID */
    private Long userId;

    /** 绑定用户姓名 */
    private String userName;

    /** 紧急联系电话 */
    private String userPhone;

    /** 状态: 0-正常, 1-离线, 2-故障 */
    private String status;

    /** 电池电量百分比 */
    private Integer batteryLevel;

    /** 最后心跳时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastHeartbeat;

    /** 备注 */
    private String remark;

    /** 创建者 */
    private String createBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新者 */
    private String updateBy;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 设备类型字典文本 */
    private String deviceTypeText;

    /** 状态字典文本 */
    private String statusText;

    /** 今日报警数 */
    private Integer todayAlarmCount;
}
