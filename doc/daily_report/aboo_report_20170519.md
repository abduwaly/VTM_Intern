## 日报

* 姓名：阿布都外力

* 时间：20170519

### 今日 
    
1. 对实体类FileInfo 和 表tab_file 的结构进行了变化（添加了extension 和 mime_type字段）
	
2. 因为数据结构发生变化，所以业务也相应的做了变化（比如，上传文件是存进数据库的包含其extension和mime_type）
	 
3. 在下载文件时，Content-type 设置成了文件的mime_type （从数据哭获取）	 

4. 在项目中配置Swagger，实现了项目接口文档的自动生成功能 http://localhost:8080/swagger-ui.html

### 明日计划 

1. 在项目中添加注释

2. 添加 Junit 单元测试

3. 学习Java NIO 相关内容，改写download方法（这一步属于优化工作，低优先级）
 
