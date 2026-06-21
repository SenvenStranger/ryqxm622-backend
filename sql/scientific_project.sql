-- ================================================
-- 科研项目管理模块 - 数据库表
-- 仿照跌倒报警器 falldowndevice 模块结构
-- ================================================

-- ----------------------------
-- 1. 项目信息表
-- ----------------------------
DROP TABLE IF EXISTS `sys_scientific_project`;
CREATE TABLE `sys_scientific_project` (
  `project_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目ID',
  `project_code` varchar(64) NOT NULL COMMENT '项目编号',
  `project_name` varchar(200) NOT NULL COMMENT '项目名称',
  `project_type` varchar(20) DEFAULT NULL COMMENT '项目类型(国家级/省部级/厅局级/校级)',
  `project_level` varchar(10) DEFAULT NULL COMMENT '项目级别(重点/一般)',
  `subject_category` varchar(50) DEFAULT NULL COMMENT '学科分类',
  `source_from` varchar(50) DEFAULT NULL COMMENT '项目来源',
  `funding_amount` decimal(10,2) DEFAULT NULL COMMENT '资助金额(万元)',
  `start_date` date DEFAULT NULL COMMENT '开始日期',
  `end_date` date DEFAULT NULL COMMENT '结束日期',
  `project_status` char(1) DEFAULT '0' COMMENT '项目状态(0筹备/1进行中/2已完成/3已终止)',
  `principal_name` varchar(50) DEFAULT NULL COMMENT '负责人姓名',
  `principal_phone` varchar(20) DEFAULT NULL COMMENT '负责人电话',
  `principal_email` varchar(100) DEFAULT NULL COMMENT '负责人邮箱',
  `dept_id` bigint(20) DEFAULT NULL COMMENT '所属部门',
  `research_direction` varchar(200) DEFAULT NULL COMMENT '研究方向',
  `project_intro` text COMMENT '项目简介',
  `objectives` text COMMENT '研究目标',
  `methods` text COMMENT '研究方法',
  `innovations` text COMMENT '创新点',
  `image_url` varchar(500) DEFAULT NULL COMMENT '项目封面图',
  `attachments` varchar(1000) DEFAULT NULL COMMENT '附件路径',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志(0存在/1删除)',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`project_id`),
  UNIQUE KEY `uk_project_code` (`project_code`),
  KEY `idx_project_status` (`project_status`),
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB COMMENT='科研项目信息表';

-- ----------------------------
-- 2. 里程碑/进度记录表
-- ----------------------------
DROP TABLE IF EXISTS `sys_project_milestone`;
CREATE TABLE `sys_project_milestone` (
  `milestone_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '里程碑ID',
  `project_id` bigint(20) NOT NULL COMMENT '项目ID',
  `milestone_name` varchar(200) NOT NULL COMMENT '里程碑名称',
  `milestone_type` varchar(20) DEFAULT NULL COMMENT '里程碑类型(开题/中期/结题/阶段)',
  `plan_date` date DEFAULT NULL COMMENT '计划日期',
  `actual_date` date DEFAULT NULL COMMENT '实际完成日期',
  `milestone_status` char(1) DEFAULT '0' COMMENT '状态(0待完成/1已完成/2延期)',
  `progress_percent` int(3) DEFAULT 0 COMMENT '完成进度(0-100)',
  `description` text COMMENT '里程碑描述',
  `achievements` text COMMENT '完成成果',
  `problems` text COMMENT '存在问题',
  `next_plan` text COMMENT '下一步计划',
  `attachment_urls` varchar(1000) DEFAULT NULL COMMENT '附件',
  `submit_by` varchar(64) DEFAULT NULL COMMENT '提交人',
  `submit_time` datetime DEFAULT NULL COMMENT '提交时间',
  `review_by` varchar(64) DEFAULT NULL COMMENT '审核人',
  `review_time` datetime DEFAULT NULL COMMENT '审核时间',
  `review_result` varchar(50) DEFAULT NULL COMMENT '审核结果',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`milestone_id`),
  KEY `idx_project_id` (`project_id`),
  KEY `idx_status` (`milestone_status`)
) ENGINE=InnoDB COMMENT='项目里程碑表';

-- ----------------------------
-- 3. 项目团队成员表
-- ----------------------------
DROP TABLE IF EXISTS `sys_project_member`;
CREATE TABLE `sys_project_member` (
  `member_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '成员ID',
  `project_id` bigint(20) NOT NULL COMMENT '项目ID',
  `user_id` bigint(20) DEFAULT NULL COMMENT '用户ID',
  `member_name` varchar(50) NOT NULL COMMENT '成员姓名',
  `member_role` varchar(20) DEFAULT NULL COMMENT '成员角色(负责人/骨干/参与)',
  `title` varchar(50) DEFAULT NULL COMMENT '职称',
  `degree` varchar(20) DEFAULT NULL COMMENT '学历',
  `specialty` varchar(100) DEFAULT NULL COMMENT '专业',
  `workload_hours` decimal(6,2) DEFAULT 0 COMMENT '工作量(小时)',
  `contribution` varchar(200) DEFAULT NULL COMMENT '主要贡献',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `join_date` date DEFAULT NULL COMMENT '加入日期',
  `leave_date` date DEFAULT NULL COMMENT '离开日期',
  `is_active` char(1) DEFAULT '1' COMMENT '是否在研(0否/1是)',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`member_id`),
  KEY `idx_project_id` (`project_id`),
  KEY `idx_user_id` (`user_id`)
) ENGINE=InnoDB COMMENT='项目团队成员表';

-- ----------------------------
-- 4. 项目文档表
-- ----------------------------
DROP TABLE IF EXISTS `sys_project_document`;
CREATE TABLE `sys_project_document` (
  `doc_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文档ID',
  `project_id` bigint(20) NOT NULL COMMENT '项目ID',
  `doc_type` varchar(30) DEFAULT NULL COMMENT '文档类型(申报书/合同/中期报告/结题报告/论文/专利/其他)',
  `doc_name` varchar(200) NOT NULL COMMENT '文档名称',
  `doc_path` varchar(500) NOT NULL COMMENT '文档路径',
  `doc_size` bigint(20) DEFAULT NULL COMMENT '文件大小(Byte)',
  `file_type` varchar(20) DEFAULT NULL COMMENT '文件类型(pdf/word/excel等)',
  `upload_by` varchar(64) DEFAULT NULL COMMENT '上传人',
  `upload_time` datetime DEFAULT NULL COMMENT '上传时间',
  `version` varchar(20) DEFAULT '1.0' COMMENT '版本号',
  `is_public` char(1) DEFAULT '0' COMMENT '是否公开(0否/1是)',
  `description` varchar(500) DEFAULT NULL COMMENT '文档描述',
  `del_flag` char(1) DEFAULT '0' COMMENT '删除标志',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`doc_id`),
  KEY `idx_project_id` (`project_id`),
  KEY `idx_doc_type` (`doc_type`)
) ENGINE=InnoDB COMMENT='项目文档表';

-- ----------------------------
-- 5. 项目统计表
-- ----------------------------
DROP TABLE IF EXISTS `sys_project_statistics`;
CREATE TABLE `sys_project_statistics` (
  `stat_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '统计ID',
  `stat_date` date NOT NULL COMMENT '统计日期',
  `total_projects` int(11) DEFAULT 0 COMMENT '项目总数',
  `active_projects` int(11) DEFAULT 0 COMMENT '在研项目数',
  `completed_projects` int(11) DEFAULT 0 COMMENT '已完成项目数',
  `total_funding` decimal(15,2) DEFAULT 0 COMMENT '累计资助金额(万元)',
  `new_projects` int(11) DEFAULT 0 COMMENT '新增项目数',
  `milestones_due` int(11) DEFAULT 0 COMMENT '待完成里程碑数',
  `milestones_completed` int(11) DEFAULT 0 COMMENT '已完成里程碑数',
  `total_members` int(11) DEFAULT 0 COMMENT '参与人员数',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`stat_id`),
  UNIQUE KEY `uk_stat_date` (`stat_date`)
) ENGINE=InnoDB COMMENT='项目统计表';

-- ----------------------------
-- 6. 初始数据
-- ----------------------------
INSERT INTO `sys_scientific_project` (`project_id`, `project_code`, `project_name`, `project_type`, `project_level`, `subject_category`, `source_from`, `funding_amount`, `start_date`, `end_date`, `project_status`, `principal_name`, `principal_phone`, `dept_id`, `research_direction`, `project_intro`, `create_by`, `create_time`) VALUES
(1, 'KY20240001', '基于深度学习的智能医疗影像诊断系统研究', '省部级', '重点', '计算机科学与技术', '省科技厅', 50.00, '2024-01-01', '2026-12-31', '1', '张教授', '13800138001', 105, '人工智能', '本研究旨在开发基于深度学习的医疗影像智能诊断系统，提高诊断效率和准确率。', 'admin', NOW()),
(2, 'KY20240002', '新型可降解生物材料研发', '厅局级', '一般', '材料科学与工程', '市科技局', 20.00, '2024-03-01', '2026-02-28', '1', '李研究员', '13800138002', 106, '生物材料', '开发具有自主知识产权的新型可降解生物材料。', 'admin', NOW()),
(3, 'KY20240003', '智慧城市建设关键技术研究', '国家级', '重点', '信息与通信工程', '国家自然科学基金委', 200.00, '2023-06-01', '2026-05-31', '1', '王院士', '13800138003', 107, '智慧城市', '针对智慧城市建设中的关键技术问题开展系统研究。', 'admin', NOW());

INSERT INTO `sys_project_milestone` (`milestone_id`, `project_id`, `milestone_name`, `milestone_type`, `plan_date`, `actual_date`, `milestone_status`, `progress_percent`, `description`, `submit_by`, `submit_time`) VALUES
(1, 1, '项目开题', '开题', '2024-02-01', '2024-01-15', '1', 100, '完成项目开题报告和实施方案', 'admin', NOW()),
(2, 1, '数据集构建', '阶段', '2024-06-01', '2024-06-15', '1', 100, '完成医疗影像数据集的收集和标注', 'admin', NOW()),
(3, 1, '模型设计与训练', '阶段', '2024-12-01', NULL, '0', 60, '完成深度学习模型的设计和初步训练', 'admin', NOW()),
(4, 1, '中期检查', '中期', '2025-06-01', NULL, '0', 0, '项目中期检查汇报', 'admin', NOW()),
(5, 2, '项目开题', '开题', '2024-04-01', '2024-03-20', '1', 100, '完成开题报告', 'admin', NOW()),
(6, 2, '材料合成', '阶段', '2024-09-01', NULL, '0', 45, '新型材料合成实验', 'admin', NOW()),
(7, 3, '需求分析', '阶段', '2023-08-01', '2023-07-20', '1', 100, '完成智慧城市需求分析报告', 'admin', NOW()),
(8, 3, '架构设计', '阶段', '2023-12-01', '2024-01-10', '1', 100, '完成系统架构设计', 'admin', NOW()),
(9, 3, '平台开发', '阶段', '2025-06-01', NULL, '0', 35, '核心平台开发', 'admin', NOW()),
(10, 3, '中期检查', '中期', '2024-12-01', NULL, '0', 0, '国家项目中期检查', 'admin', NOW());

INSERT INTO `sys_project_member` (`member_id`, `project_id`, `user_id`, `member_name`, `member_role`, `title`, `degree`, `specialty`, `workload_hours`, `phone`, `join_date`) VALUES
(1, 1, 1, '张教授', '负责人', '教授', '博士', '计算机视觉', 500.00, '13800138001', '2024-01-01'),
(2, 1, NULL, '刘博士', '骨干', '副研究员', '博士', '深度学习', 400.00, '13800138004', '2024-01-01'),
(3, 1, NULL, '陈硕士', '参与', '无', '硕士', '图像处理', 200.00, '13800138005', '2024-02-01'),
(4, 2, NULL, '李研究员', '负责人', '研究员', '博士', '材料科学', 450.00, '13800138002', '2024-03-01'),
(5, 2, NULL, '赵工程师', '骨干', '高级工程师', '硕士', '材料合成', 350.00, '13800138006', '2024-03-01'),
(6, 3, NULL, '王院士', '负责人', '院士', '博士', '通信工程', 600.00, '13800138007', '2023-06-01'),
(7, 3, NULL, '周教授', '骨干', '教授', '博士', '物联网', 400.00, '13800138008', '2023-06-01');
