# 学生管理系统（全栈）

一个支持学生信息增删改查的全栈应用，包含前端页面、后端 API 与数据库持久化，并完成线上部署。

## 技术栈
- 前端：React + Vite + JavaScript
- 后端：Spring Boot + JDBC
- 数据库：PostgreSQL（Railway）
- 部署：Railway（后端） + GitHub Pages（前端）
- 工具：Git / Maven / npm

## 核心功能
- 学生信息增删改查（CRUD）
- 清空所有数据接口
- 前端表格展示与交互
- 后端 REST API
- 数据持久化（PostgreSQL）

## 架构说明
- 前端通过 `fetch` 调用后端 API
- 后端提供 REST API 并访问数据库
- 前后端分离部署

## 接口示例
- `GET /students` 查询全部
- `POST /students` 新增学生
- `PUT /students/{name}` 更新分数
- `DELETE /students/{name}` 删除
- `DELETE /students` 清空数据

## 部署地址
- 前端页面：`https://eddiehurryup.github.io/student-api/`
- 后端 API：`https://student-api-production-bcac.up.railway.app`

## 本地开发
后端：
```bash
mvn -q -DskipTests package
mvn -q spring-boot:run
```

前端（React）：
```bash
cd frontend
npm install
npm run dev
```

构建并发布到 GitHub Pages：
```bash
cd frontend
npm run build
```

## 项目经验
- 完成前后端分离与部署上线
- 数据库从 SQLite 迁移到 PostgreSQL
- 处理跨域访问（CORS）
