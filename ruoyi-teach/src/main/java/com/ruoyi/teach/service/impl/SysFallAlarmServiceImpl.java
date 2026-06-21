package com.ruoyi.teach.service.impl;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.teach.domain.SysFallAlarm;
import com.ruoyi.teach.mapper.SysFallAlarmMapper;
import com.ruoyi.teach.service.ISysFallAlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报警记录Service实现
 *
 * @author ruoyi
 */
@Service
public class SysFallAlarmServiceImpl implements ISysFallAlarmService {

    @Autowired
    private SysFallAlarmMapper alarmMapper;

    /**
     * 查询报警记录
     */
    @Override
    public SysFallAlarm selectAlarmById(Long alarmId) {
        return alarmMapper.selectAlarmById(alarmId);
    }

    /**
     * 查询报警列表
     */
    @Override
    public List<SysFallAlarm> selectAlarmList(SysFallAlarm alarm) {
        return alarmMapper.selectAlarmList(alarm);
    }

    /**
     * 查询今日报警
     */
    @Override
    public List<SysFallAlarm> selectTodayAlarms() {
        return alarmMapper.selectTodayAlarmStats();
    }

    /**
     * 新增报警
     */
    @Override
    public int insertAlarm(SysFallAlarm alarm) {
        alarm.setCreateBy(StringUtils.isNotNull(SecurityUtils.getUserId()) ? SecurityUtils.getUsername() : "device");
        alarm.setCreateTime(DateUtils.getNowDate());
        return alarmMapper.insertAlarm(alarm);
    }

    /**
     * 处理报警
     */
    @Override
    public int handleAlarm(Long alarmId, String status, String handleResult) {
        String username = SecurityUtils.getUsername();
        return alarmMapper.updateAlarmStatus(alarmId, status, username, handleResult);
    }

    /**
     * 删除报警
     */
    @Override
    public int deleteAlarmById(Long alarmId) {
        return alarmMapper.deleteAlarmById(alarmId);
    }

    /**
     * 批量删除报警
     */
    @Override
    public int deleteAlarmByIds(Long[] alarmIds) {
        return alarmMapper.deleteAlarmByIds(alarmIds);
    }

    /**
     * 导出报警列表
     */
    @Override
    public List<SysFallAlarm> selectAlarmListForExport(SysFallAlarm alarm) {
        return alarmMapper.selectAlarmList(alarm);
    }

    /**
     * 获取报警统计
     */
    @Override
    public Object getAlarmStatistics() {
        List<SysFallAlarm> todayAlarms = alarmMapper.selectTodayAlarmStats();

        Map<String, Object> stats = new HashMap<>();
        stats.put("total", todayAlarms.size());
        stats.put("pending", todayAlarms.stream().filter(a -> "0".equals(a.getAlarmStatus())).count());
        stats.put("handled", todayAlarms.stream().filter(a -> "3".equals(a.getAlarmStatus())).count());
        stats.put("falseAlarm", todayAlarms.stream().filter(a -> "2".equals(a.getAlarmStatus())).count());
        stats.put("todayAlarms", todayAlarms);

        return stats;
    }
}
