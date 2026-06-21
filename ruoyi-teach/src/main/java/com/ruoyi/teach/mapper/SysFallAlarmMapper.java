package com.ruoyi.teach.mapper;

import com.ruoyi.teach.domain.SysFallAlarm;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 报警记录Mapper接口
 * 
 * @author ruoyi
 */
public interface SysFallAlarmMapper {

    /**
     * 查询报警记录列表
     */
    List<SysFallAlarm> selectAlarmList(SysFallAlarm alarm);

    /**
     * 根据报警ID查询
     */
    SysFallAlarm selectAlarmById(@Param("alarmId") Long alarmId);

    /**
     * 新增报警记录
     */
    int insertAlarm(SysFallAlarm alarm);

    /**
     * 更新报警处理状态
     */
    int updateAlarmStatus(@Param("alarmId") Long alarmId, @Param("status") String status,
                          @Param("handleBy") String handleBy, @Param("handleResult") String handleResult);

    /**
     * 删除报警记录
     */
    int deleteAlarmById(@Param("alarmId") Long alarmId);

    /**
     * 批量删除报警记录
     */
    int deleteAlarmByIds(@Param("alarmIds") Long[] alarmIds);

    /**
     * 查询今日报警统计
     */
    List<SysFallAlarm> selectTodayAlarmStats();
}
