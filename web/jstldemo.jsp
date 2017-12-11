<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/12/4
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>jstl练习演示</title>
</head>
<body>


        <c:if test="${not empty userExist}">
            ${userExist},你好!欢迎您来到我的主页.
            ${welcome}
        </c:if>
        <c:if test="${empty userExist}">
            没事就不要瞎晃,我是写了session的.
        </c:if>
</body>
</html>
