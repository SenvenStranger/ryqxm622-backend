-- ================================================
-- 跌倒报警器模块数据库脚本
-- 科研项目：基于物联网的智能跌倒检测系统
-- ================================================

-- ----------------------------
-- 1. 设备表 sys_fall_device
-- ----------------------------
DROP TABLE IF EXISTS `sys_fall_device`;
CREATE TABLE `sys_fall_device` (
  `device_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '设备ID',
  `device_name` varchar(100) NOT NULL COMMENT '设备名称',
  `device_code` varchar(64) NOT NULL COMMENT '设备编码',
  `device_type` varchar(20) DEFAULT 'wearable' COMMENT '设备类型: wearable-穿戴式, camera-摄像头, ambient-环境传感器',
  `device_model` varchar(100) DEFAULT NULL COMMENT '设备型号',
  `manufacturer` varchar(100) DEFAULT NULL COMMENT '生产厂家',
  `mac_address` varchar(64) DEFAULT NULL COMMENT 'MAC地址',
  `ip_address` varchar(128) DEFAULT NULL COMMENT 'IP地址',
  `longitude` decimal(10,6) DEFAULT NULL COMMENT '经度',
  `latitude` decimal(10,6) DEFAULT NULL COMMENT '纬度',
  `location` varchar(200) DEFAULT NULL COMMENT '安装位置',
  `user_id` bigint(20) DEFAULT NULL COMMENT '绑定用户ID',
  `user_name` varchar(64) DEFAULT NULL COMMENT '绑定用户姓名',
  `user_phone` varchar(32) DEFAULT NULL COMMENT '紧急联系电话',
  `status` char(1) DEFAULT '0' COMMENT '状态: 0-正常, 1-离线, 2-故障',
  `battery_level` int(3) DEFAULT 100 COMMENT '电池电量百分比',
  `last_heartbeat` datetime DEFAULT NULL COMMENT '最后心跳时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`device_id`),
  UNIQUE KEY `uk_device_code` (`device_code`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_status` (`status`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='跌倒报警设备表';

-- ----------------------------
-- 2. 报警记录表 sys_fall_alarm
-- ----------------------------
DROP TABLE IF EXISTS `sys_fall_alarm`;
CREATE TABLE `sys_fall_alarm` (
  `alarm_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '报警ID',
  `device_id` bigint(20) NOT NULL COMMENT '设备ID',
  `device_code` varchar(64) NOT NULL COMMENT '设备编码',
  `device_name` varchar(100) DEFAULT NULL COMMENT '设备名称',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `user_name` varchar(64) DEFAULT NULL COMMENT '用户姓名',
  `alarm_type` varchar(20) NOT NULL COMMENT '报警类型: fall-跌倒, sos-紧急求助, low_battery-低电量, offline-设备离线',
  `alarm_level` char(1) DEFAULT '1' COMMENT '报警级别: 1-低, 2-中, 3-高, 4-紧急',
  `alarm_time` datetime NOT NULL COMMENT '报警时间',
  `fall_probability` decimal(5,2) DEFAULT NULL COMMENT '跌倒概率(%)',
  `fall_type` varchar(20) DEFAULT NULL COMMENT '跌倒类型: forward-前倾, backward-后仰, sideways-侧倾, collapse-猝倒',
  `activity_state` varchar(50) DEFAULT NULL COMMENT '报警前活动状态',
  `heart_rate` int(5) DEFAULT NULL COMMENT '心率(bpm)',
  `longitude` decimal(10,6) DEFAULT NULL COMMENT '报警位置经度',
  `latitude` decimal(10,6) DEFAULT NULL COMMENT '报警位置纬度',
  `location` varchar(200) DEFAULT NULL COMMENT '报警位置描述',
  `image_url` varchar(500) DEFAULT NULL COMMENT '抓拍图片URL',
  `video_url` varchar(500) DEFAULT NULL COMMENT '报警视频URL',
  `alarm_status` char(1) DEFAULT '0' COMMENT '处理状态: 0-待处理, 1-已确认, 2-误报, 3-已处理, 4-已升级',
  `handle_time` datetime DEFAULT NULL COMMENT '处理时间',
  `handle_by` varchar(64) DEFAULT NULL COMMENT '处理人',
  `handle_result` varchar(500) DEFAULT NULL COMMENT '处理结果',
  `notify_contacts` varchar(500) DEFAULT NULL COMMENT '已通知联系人(JSON数组)',
  `notify_status` char(1) DEFAULT '0' COMMENT '通知状态: 0-未通知, 1-已通知, 2-通知失败',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`alarm_id`),
  KEY `idx_device_id` (`device_id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_alarm_time` (`alarm_time`),
  KEY `idx_alarm_status` (`alarm_status`),
  KEY `idx_alarm_type` (`alarm_type`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='跌倒报警记录表';

-- ----------------------------
-- 3. 报警联系人表 sys_fall_contact
-- ----------------------------
DROP TABLE IF EXISTS `sys_fall_contact`;
CREATE TABLE `sys_fall_contact` (
  `contact_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '联系人ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID(被监护人)',
  `user_name` varchar(64) NOT NULL COMMENT '用户姓名',
  `contact_name` varchar(64) NOT NULL COMMENT '联系人姓名',
  `contact_relation` varchar(50) DEFAULT NULL COMMENT '关系: family-家属, friend-朋友, doctor-医生, caregiver-护工',
  `contact_phone` varchar(32) NOT NULL COMMENT '联系电话',
  `contact_email` varchar(100) DEFAULT NULL COMMENT '联系邮箱',
  `is_emergency` char(1) DEFAULT '1' COMMENT '是否紧急联系人: 0-否, 1-是',
  `notify_order` int(2) DEFAULT 1 COMMENT '通知顺序(数字越小优先级越高)',
  `is_enabled` char(1) DEFAULT '1' COMMENT '是否启用: 0-禁用, 1-启用',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`contact_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='报警联系人表';

-- ----------------------------
-- 4. 设备数据统计表 sys_fall_statistics
-- ----------------------------
DROP TABLE IF EXISTS `sys_fall_statistics`;
CREATE TABLE `sys_fall_statistics` (
  `stat_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '统计ID',
  `stat_date` date NOT NULL COMMENT '统计日期',
  `device_id` bigint(20) DEFAULT NULL COMMENT '设备ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `total_alarms` int(11) DEFAULT 0 COMMENT '当日报警总数',
  `fall_count` int(11) DEFAULT 0 COMMENT '跌倒报警数',
  `sos_count` int(11) DEFAULT 0 COMMENT '紧急求助数',
  `false_alarm_count` int(11) DEFAULT 0 COMMENT '误报数',
  `avg_fall_probability` decimal(5,2) DEFAULT 0 COMMENT '平均跌倒概率',
  `device_online_time` int(11) DEFAULT 0 COMMENT '设备在线时长(分钟)',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`stat_id`),
  UNIQUE KEY `uk_date_device` (`stat_date`, `device_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='设备报警统计表';

-- ----------------------------
-- 初始数据
-- ----------------------------
INSERT INTO `sys_fall_device` (`device_name`, `device_code`, `device_type`, `device_model`, `manufacturer`, `location`, `status`, `create_by`, `create_time`) VALUES
('实验室穿戴设备-01', 'FD20240001', 'wearable', 'FallGuard-Pro', '智慧养老科技', '实验室A区', '0', 'admin', NOW()),
('走廊监控摄像头', 'FD20240002', 'camera', 'IPC-TrackX', '海康威视', '3号楼走廊', '0', 'admin', NOW()),
('卧室环境传感器', 'FD20240003', 'ambient', 'SenseMax-A1', '博世传感', '301室卧室', '0', 'admin', NOW());
