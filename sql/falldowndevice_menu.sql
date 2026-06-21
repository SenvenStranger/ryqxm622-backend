-- ================================================
-- 跌倒报警器模块 - 菜单SQL
-- 科研项目：基于物联网的智能跌倒检测系统
-- ================================================

-- ----------------------------
-- 1. 添加跌倒报警一级菜单
-- ----------------------------
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (2000, '跌倒报警器', 0, 5, 'falldown', NULL, 1, 0, 'M', '0', '', 'el-icon-bell', 'admin', NOW(), '', NULL, '跌倒报警器模块');

-- ----------------------------
-- 2. 添加设备管理菜单
-- ----------------------------
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (2001, '设备管理', 2000, 1, 'device', 'teach/falldowndevice/index', 1, 0, 'C', '0', '', 'el-icon-connection', 'admin', NOW(), '', NULL, '设备管理菜单');

-- 设备管理按钮权限
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (20011, '设备查询', 2001, 1, '', '', 1, 0, 'F', '0', 'teach:device:query', '#', 'admin', NOW(), '', NULL, '');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (20012, '设备新增', 2001, 2, '', '', 1, 0, 'F', '0', 'teach:device:add', '#', 'admin', NOW(), '', NULL, '');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (20013, '设备修改', 2001, 3, '', '', 1, 0, 'F', '0', 'teach:device:edit', '#', 'admin', NOW(), '', NULL, '');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (20014, '设备删除', 2001, 4, '', '', 1, 0, 'F', '0', 'teach:device:remove', '#', 'admin', NOW(), '', NULL, '');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (20015, '设备导出', 2001, 5, '', '', 1, 0, 'F', '0', 'teach:device:export', '#', 'admin', NOW(), '', NULL, '');

-- ----------------------------
-- 3. 添加报警记录菜单
-- ----------------------------
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (2002, '报警记录', 2000, 2, 'alarm', 'teach/falldowndevice/alarm', 1, 0, 'C', '0', '', 'el-icon-bell', 'admin', NOW(), '', NULL, '报警记录菜单');

-- 报警记录按钮权限
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (20021, '报警查询', 2002, 1, '', '', 1, 0, 'F', '0', 'teach:alarm:query', '#', 'admin', NOW(), '', NULL, '');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (20022, '报警处理', 2002, 2, '', '', 1, 0, 'F', '0', 'teach:alarm:handle', '#', 'admin', NOW(), '', NULL, '');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (20023, '报警删除', 2002, 3, '', '', 1, 0, 'F', '0', 'teach:alarm:remove', '#', 'admin', NOW(), '', NULL, '');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (20024, '报警导出', 2002, 4, '', '', 1, 0, 'F', '0', 'teach:alarm:export', '#', 'admin', NOW(), '', NULL, '');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `update_by`, `update_time`, `remark`)
VALUES (20025, '报警统计', 2002, 5, '', '', 1, 0, 'F', '0', 'teach:alarm:statistics', '#', 'admin', NOW(), '', NULL, '');

-- ----------------------------
-- 4. 给admin角色分配权限
-- ----------------------------
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`)
SELECT 1, `menu_id` FROM `sys_menu` WHERE `menu_id` IN (2000, 2001, 20011, 20012, 20013, 20014, 20015, 2002, 20021, 20022, 20023, 20024, 20025);
