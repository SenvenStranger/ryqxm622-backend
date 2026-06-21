# ruoyi-teach
# ruoyi-teach 后端

基于 RuoYi 框架的科研项目管理后台，Spring Boot + MyBatis + MySQL。

## 主要模块

### 科研项目（核心模块）
- `SysScientificProjectController` — 科研项目 CRUD、条件筛选、分页查询
- `SysScientificProjectServiceImpl` — 编号唯一性校验、业务规则
- `SysScientificProjectMapper` — 数据持久层
- 对应前端页面：`src/views/projectinfo/index.vue`

### 项目关联模块
- `SysProjectMemberController` — 项目成员管理
- `SysProjectMilestoneController` — 项目里程碑管理
- `SysProjectDocumentController` — 项目文档管理

### 跌倒检测模块
- `SysFallAlarmController` — 跌倒报警记录
- `SysFallDeviceController` / `FalldownDeviceController` — 跌倒设备管理

### 教学管理模块
- `TeachProjectInfoController` — 教学项目管理
- `TeachDictController` — 教学数据字典
- `TeachMenuController` — 教学菜单配置

### 通用模块（RuoYi 内置）
- 用户管理、角色管理、菜单管理、部门管理
- 字典管理、参数管理、操作日志、登录日志

## 技术栈
- Spring Boot 2.x
- MyBatis
- MySQL
- RuoYi 权限框架（@PreAuthorize 注解鉴权）

## 主要项目结构
```
src/main/java/com/ruoyi/teach/
├── controller/   # 控制层
├── service/      # 业务接口
├── service/impl/ # 业务实现
├── mapper/       # MyBatis Mapper
├── domain/       # 实体类
└── util/         # 工具类
```
