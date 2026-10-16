# Spring MVC 学习项目

基于 Java 17、Spring Boot 和 Maven 的用户管理练习，演示：

- Controller → Service → DAO 分层与依赖注入。
- 登录参数校验、Session 登录状态、退出登录及访问拦截。
- 用户查询、新增、修改、删除，以及统一响应与字段校验。
- 静态页面和 Cookie 读写示例。

当前业务通过 `SysUserDataUtil` 保存内存数据，重启后恢复示例数据。
项目包含 MyBatis/MySQL 接入配置，但 Mapper XML 尚未实现 SQL；这部分仍是学习中的代码。

## 构建和运行

在本目录执行，需安装 JDK 17 和 Maven：

```sh
mvn test
mvn spring-boot:run
```

默认页面地址：`http://localhost:8080/login.html`。
`app.port` 是自定义配置项；如需修改 HTTP 端口，应设置 `server.port`，并同步调整静态页面中的 API 地址。

## 本地配置

数据库连接支持 `DB_URL`、`DB_USERNAME`、`DB_PASSWORD` 环境变量。
也可以在本目录创建 `application-local.properties`，填写本机配置，例如：

```properties
spring.datasource.password=your-local-database-password
```

该文件被 Git 忽略，且位于资源目录之外，不会被打包进应用。
不要将真实密码、密钥或生产数据写入提交。

## 提交约定

提交源码、测试、`pom.xml`、通用配置和说明文档；不提交 `target/`、IDE 配置、日志及本机凭据。

每次 commit 表达一个完整变更，例如：

```text
feat(auth): 添加登录参数校验
fix(user): 修复用户不存在时的返回结果
test(user): 补充新增用户校验测试
docs: 更新启动说明
```
