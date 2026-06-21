package com.ruoyi.teach.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 跌倒报警记录对象 sys_fall_alarm
 *
 * @author ruoyi
 */
@Data
public class SysFallAlarm implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 报警ID */
    private Long alarmId;

    /** 设备ID */
    private Long deviceId;

    /** 设备编码 */
    private String deviceCode;

    /** 设备名称 */
    private String deviceName;

    /** 用户ID */
    private Long userId;

    /** 用户姓名 */
    private String userName;

    /** 报警类型: fall-跌倒, sos-紧急求助, low_battery-低电量, offline-设备离线 */
    private String alarmType;

    /** 报警级别: 1-低, 2-中, 3-高, 4-紧急 */
    private String alarmLevel;

    /** 报警时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date alarmTime;

    /** 跌倒概率(%) */
    private BigDecimal fallProbability;

    /** 跌倒类型: forward-前倾, backward-后仰, sideways-侧倾, collapse-猝倒 */
    private String fallType;

    /** 报警前活动状态 */
    private String activityState;

    /** 心率(bpm) */
    private Integer heartRate;

    /** 经度 */
    private BigDecimal longitude;

    /** 纬度 */
    private BigDecimal latitude;

    /** 报警位置描述 */
    private String location;

    /** 抓拍图片URL */
    private String imageUrl;

    /** 报警视频URL */
    private String videoUrl;

    /** 处理状态: 0-待处理, 1-已确认, 2-误报, 3-已处理, 4-已升级 */
    private String alarmStatus;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date handleTime;

    /** 处理人 */
    private String handleBy;

    /** 处理结果 */
    private String handleResult;

    /** 已通知联系人(JSON数组) */
    private String notifyContacts;

    /** 通知状态: 0-未通知, 1-已通知, 2-通知失败 */
    private String notifyStatus;

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

    // ============== 字典文本字段 ==============
    private String alarmTypeText;
    private String alarmLevelText;
    private String alarmStatusText;
    private String notifyStatusText;

    // ============== 查询参数 ==============
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date beginAlarmTime;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endAlarmTime;
}
