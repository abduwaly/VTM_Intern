## 日报

* 姓名：阿布都外力

* 时间：20170516

### 今日 
     
1. 用Maven的pom将Milan 和 Camp 整合起来，昨天出现的Exeception也已经解决
	
	错误原因：忘了在Milan的applicationContext.xml中import Camp的applicationContext.xml   //血的教训！！！
	
2. 跟张小伟导师沟通了Document管理系统的需求，整理了一下思路，创建了数据库表tab_file和实例类FileInfo
	
	String file_name, long last_modified, String type, long length

3. 完成了Document管理系统的所有查询功能(Controller层、Service层、持久层)，如下： 

	findALL、searchByFilename、searchByLastModified、searchByType、searchByLen

### 明日计划 

1. 完成了Document管理系统的上传文档的功能




