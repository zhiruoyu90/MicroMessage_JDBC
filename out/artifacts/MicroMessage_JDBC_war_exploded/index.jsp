<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016-03-08
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base  href="<%=basePath%>" />

<html>
  <head>
    <title></title>
  </head>
  <body>

  </body>
</html>
