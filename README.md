# mybatis学习笔记
---
## 系统架构：springboot+mybatis+pageHeler+swagger-ui+mysql
---
## 地址:http://39.108.8.0:8081/swagger-ui.html
---
## 内容包括
### * 插入时返回自增id
### * 批量插入
### * 分页
### * 使用Plugin打印执行的sql
### * 使用TypeHandler在查询和插入时修改字段的值
### * 连表查询
***
## 接口详情
### BaseController
#### * getById 
##### 根据id查user
#### * insertReturnAutoId
##### 插入时将自增id赋值给实体
### BatchController
#### * insertBatch
##### 常用方法：拼接sql:insert sys_user(id,name) values(1,2),(2,3)。速度快，但mysql对sql的长度有限制（max_allowed_packet参数）
#### * insertBatch2
##### 添加事物，遍历集合，一个一个插入。每保存一条记录都需要与数据库建立连接，速度慢
### PageController
#### * pageByLimitClause
#####  模仿自动生成的mapper的orderByClause，添加limitClause，仅限mysql数据库
#### * pageByPageHelper
##### pageHelper插件分页，各类型数据库通用
### PluginController
#### * update
#####  使用插件在打印出执行的sql
### TypeHadnlerController
#### * getByIDUseTypeHandler
##### 查询时修改nickname属性的值
#### * insertUseTypeHandler
##### 插入时修改nickname属性的值
### UnionSelectController
#### * getBlogWithAuthorById
#####  嵌套查询,先查blog表拿到autho_id再查author表,2次查询性能慢，n+1问题（查出了）
#### * getBlogWithAuthorById2
#####  推荐使用。嵌套结果，join一次查询
#### * getAuthorWithBlogsById、
#####  嵌套查询,根据authorId分别查author表和blog表,2次查询性能慢，n+1问题（查出了n个blog+1个author）
#### * getAuthorWithBlogsById2
#####  推荐使用。嵌套结果,join一次查询再封装
#### * getAuthorNameById
#####  嵌套查询,测试懒加载（看控制台打印的sql），解决n+1问题（业务只需要获取authorName，不需要查blog表）
