## 日报

* 姓名：阿布都外力

* 时间：20170515

### 今日 
     
1.在持久层Camp项目中，抽象出了一个Service层

	DAO层：    《interface》BaseRepository  <--- 《interface》UserRepository <--- UserRepositoryImpl ---> SimpleJPARepository
	Service层：《interface》BaseService <--- 《interface》UserService <--- UserServiceImpl（has a ）[UserRepository]

2. 正在将Milan 和 Camp 整合起来，过程中出现了错误，正在排查，今天未能完成

### 明日计划 

1.完成Milan 和 Camp 两个项目的整合 

2.完成 计划1 的前提下，开始做有关document管理的项目

