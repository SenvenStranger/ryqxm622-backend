package com.ruoyi.teach.service;

import com.ruoyi.teach.domain.SysFallAlarm;
import java.util.List;

/**
 * 报警记录Service接口
 *
 * @author ruoyi
 */
public interface ISysFallAlarmService {

    /**
     * 查询报警记录
     */
    SysFallAlarm selectAlarmById(Long alarmId);

    /**
     * 查询报警列表
     */
    List<SysFallAlarm> selectAlarmList(SysFallAlarm alarm);

    /**
     * 查询今日报警
     */
    List<SysFallAlarm> selectTodayAlarms();

    /**
     * 新增报警
     */
    int insertAlarm(SysFallAlarm alarm);

    /**
     * 处理报警
     */
    int handleAlarm(Long alarmId, String status, String handleResult);

    /**
     * 删除报警
     */
    int deleteAlarmById(Long alarmId);

    /**
     * 批量删除报警
     */
    int deleteAlarmByIds(Long[] alarmIds);

    /**
     * 导出报警列表
     */
    List<SysFallAlarm> selectAlarmListForExport(SysFallAlarm alarm);

    /**
     * 获取报警统计
     */
    Object getAlarmStatistics();
}
