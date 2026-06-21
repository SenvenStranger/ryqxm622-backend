-- ================================================
-- 科研项目管理模块 - 菜单SQL
-- ================================================

-- ----------------------------
-- 1. 添加科研项目一级菜单
-- ----------------------------
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `remark`)
VALUES (2100, '科研项目管理', 0, 6, 'scientific', NULL, 1, 0, 'M', '0', '', 'el-icon-document-copy', 'admin', NOW(), '科研项目管理模块');

-- ----------------------------
-- 2. 添加项目管理菜单
-- ----------------------------
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `remark`)
VALUES (2101, '项目管理', 2100, 1, 'project', 'teach/scientific/project', 1, 0, 'C', '0', '', 'el-icon-folder-opened', 'admin', NOW(), '项目管理菜单');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`) VALUES
(21011, '项目查询', 2101, 1, '', '', 1, 0, 'F', '0', 'teach:project:query', '#', 'admin', NOW()),
(21012, '项目新增', 2101, 2, '', '', 1, 0, 'F', '0', 'teach:project:add', '#', 'admin', NOW()),
(21013, '项目修改', 2101, 3, '', '', 1, 0, 'F', '0', 'teach:project:edit', '#', 'admin', NOW()),
(21014, '项目删除', 2101, 4, '', '', 1, 0, 'F', '0', 'teach:project:remove', '#', 'admin', NOW()),
(21015, '项目导出', 2101, 5, '', '', 1, 0, 'F', '0', 'teach:project:export', '#', 'admin', NOW());

-- ----------------------------
-- 3. 添加里程碑菜单
-- ----------------------------
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `remark`)
VALUES (2102, '里程碑管理', 2100, 2, 'milestone', 'teach/scientific/milestone', 1, 0, 'C', '0', '', 'el-icon-milestone', 'admin', NOW(), '里程碑管理菜单');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`) VALUES
(21021, '里程碑查询', 2102, 1, '', '', 1, 0, 'F', '0', 'teach:milestone:query', '#', 'admin', NOW()),
(21022, '里程碑新增', 2102, 2, '', '', 1, 0, 'F', '0', 'teach:milestone:add', '#', 'admin', NOW()),
(21023, '里程碑修改', 2102, 3, '', '', 1, 0, 'F', '0', 'teach:milestone:edit', '#', 'admin', NOW()),
(21024, '里程碑删除', 2102, 4, '', '', 1, 0, 'F', '0', 'teach:milestone:remove', '#', 'admin', NOW()),
(21025, '里程碑导出', 2102, 5, '', '', 1, 0, 'F', '0', 'teach:milestone:export', '#', 'admin', NOW());

-- ----------------------------
-- 4. 添加团队成员菜单
-- ----------------------------
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `remark`)
VALUES (2103, '团队成员管理', 2100, 3, 'member', 'teach/scientific/member', 1, 0, 'C', '0', '', 'el-icon-user', 'admin', NOW(), '团队成员管理菜单');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`) VALUES
(21031, '成员查询', 2103, 1, '', '', 1, 0, 'F', '0', 'teach:member:query', '#', 'admin', NOW()),
(21032, '成员新增', 2103, 2, '', '', 1, 0, 'F', '0', 'teach:member:add', '#', 'admin', NOW()),
(21033, '成员修改', 2103, 3, '', '', 1, 0, 'F', '0', 'teach:member:edit', '#', 'admin', NOW()),
(21034, '成员删除', 2103, 4, '', '', 1, 0, 'F', '0', 'teach:member:remove', '#', 'admin', NOW());

-- ----------------------------
-- 5. 添加项目文档菜单
-- ----------------------------
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `remark`)
VALUES (2104, '项目文档管理', 2100, 4, 'document', 'teach/scientific/document', 1, 0, 'C', '0', '', 'el-icon-document', 'admin', NOW(), '项目文档管理菜单');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`) VALUES
(21041, '文档查询', 2104, 1, '', '', 1, 0, 'F', '0', 'teach:document:query', '#', 'admin', NOW()),
(21042, '文档上传', 2104, 2, '', '', 1, 0, 'F', '0', 'teach:document:add', '#', 'admin', NOW()),
(21043, '文档删除', 2104, 3, '', '', 1, 0, 'F', '0', 'teach:document:remove', '#', 'admin', NOW()),
(21044, '文档下载', 2104, 4, '', '', 1, 0, 'F', '0', 'teach:document:download', '#', 'admin', NOW());

-- ----------------------------
-- 6. 添加统计菜单
-- ----------------------------
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `remark`)
VALUES (2105, '项目统计', 2100, 5, 'statistics', 'teach/scientific/statistics', 1, 0, 'C', '0', '', 'el-icon-data-analysis', 'admin', NOW(), '项目统计菜单');

INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`) VALUES
(21051, '统计查看', 2105, 1, '', '', 1, 0, 'F', '0', 'teach:statistics:query', '#', 'admin', NOW()),
(21052, '统计导出', 2105, 2, '', '', 1, 0, 'F', '0', 'teach:statistics:export', '#', 'admin', NOW());

-- ----------------------------
-- 7. 给admin角色分配权限
-- ----------------------------
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`)
SELECT 1, `menu_id` FROM `sys_menu` WHERE `menu_id` IN (
  2100, 2101, 21011, 21012, 21013, 21014, 21015,
  2102, 21021, 21022, 21023, 21024, 21025,
  2103, 21031, 21032, 21033, 21034,
  2104, 21041, 21042, 21043, 21044,
  2105, 21051, 21052
);
