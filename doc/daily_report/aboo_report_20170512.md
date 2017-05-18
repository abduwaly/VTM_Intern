## 日报

* 姓名：阿布都外力

* 时间：20170512

### 今日 
     
1.完成了SpringMVC 架构的Milan项目的Validation ，用到如下注解：

	* @Valid	修饰接受的参数
	* @NotNull、@Max、@Min		修饰实例类属性

2.张小伟导师讲解VTM项目中异常处理机制：? extends AbstractHandlerExceptionResolver 

### 明日计划 

1.将mvc的Milan 和 持久层 Camp 整合起来  （由于时间安排变化，今天没能完成）

2.在上面两个工程其中一个中提供一个Service层 （1和2先后循序可能会有变化，视情况而定）

### 今日感想

我用了 @ControllerAdvice 来处理异常，该类会在项目启动时优先加载，所以可以做到同级别Controller的异常捕捉