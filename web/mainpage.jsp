<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/12/3
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>雲中手的日常</title>
</head>
<body>
<%
    HttpSession hs = request.getSession();
    String username = (String) hs.getAttribute("userExist");
    if (username != null) {
%>
欢迎您:${userExist},来到主页面
<%
} else {//说明用户就没有登陆


%>
没有登陆就不要在这儿瞎溜达
<a href="/logindemo.html">请点击这里回到主页面</a>
<%
    }
%>
</body>
</html>
