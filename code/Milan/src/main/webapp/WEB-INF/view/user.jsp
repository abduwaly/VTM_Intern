<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/5/5
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>---User---</title>
</head>
<body>
${name}
<form action="/user/info" method="post">
    <input type="text" name="empNo"/>
    <input type="text" name="empName"/>
    <input type="submit"/>
</form>
</body>
</html>
