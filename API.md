# 学生管理 API 文档（v1）

**Base URL**：`http://localhost:8080`

**Content-Type**：`application/json`

---

## 1. 查询全部学生

- **URL**：`GET /students`
- **请求参数**：无
- **响应示例**：

```json
[
  {"id":1,"name":"Alice","score":90},
  {"id":2,"name":"Bob","score":80}
]
```

---

## 2. 新增学生

- **URL**：`POST /students`
- **请求体**：

```json
{"name":"Alice","score":90}
```

- **响应示例**：

```json
{"id":0,"name":"Alice","score":90}
```

---

## 3. 更新学生分数

- **URL**：`PUT /students/{name}`
- **路径参数**：`name`（学生姓名）
- **请求体**：

```json
{"score":77}
```

- **响应说明**：
  - `updated`：更新成功
  - `not_found`：未找到该学生

---

## 4. 删除指定学生

- **URL**：`DELETE /students/{name}`
- **路径参数**：`name`（学生姓名）
- **响应说明**：
  - `deleted`：删除成功
  - `not_found`：未找到该学生

---

## 5. 清空所有学生

- **URL**：`DELETE /students`
- **请求参数**：无
- **响应说明**：
  - `deleted_all`：清空成功
  - `empty`：原本就为空

---

## 备注

- `name` 暂未做唯一限制，重复姓名会操作多条记录
- 如需更严格规则，可后续加校验与唯一约束
