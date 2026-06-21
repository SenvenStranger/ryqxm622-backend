-- ================================================
-- 科研项目管理模块 - 菜单SQL（路由路径修正为 research）
-- ================================================

-- ----------------------------
-- 1. 添加科研项目一级菜单（path改为research以匹配 /#/research/project）
-- ----------------------------
INSERT INTO `sys_menu` (`menu_id`, `menu_name`, `parent_id`, `order_num`, `path`, `component`, `is_frame`, `is_cache`, `menu_type`, `visible`, `perms`, `icon`, `create_by`, `create_time`, `remark`)
VALUES (2100, '科研项目管理', 0, 6, 'research', NULL, 1, 0, 'M', '0', '', 'el-icon-document-copy', 'admin', NOW(), '科研项目管理模块');

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
-- 3. 给admin角色分配权限
-- ----------------------------
INSERT INTO `sys_role_menu` (`role_id`, `menu_id`)
SELECT 1, `menu_id` FROM `sys_menu` WHERE `menu_id` IN (
  2100, 2101, 21011, 21012, 21013, 21014, 21015
);
