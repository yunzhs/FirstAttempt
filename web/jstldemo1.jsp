<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hasee
  Date: 2017/12/4
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    String[]  strsss = {"6000","7000","8000","9000","10000","60000","80000"};
    request.setAttribute("strs", strsss);
    ArrayList<Integer> arr=new ArrayList<Integer>();
    arr.add(1);
    arr.add(13);
    arr.add(15);
    arr.add(16);
    request.setAttribute("arr",arr);
%>

<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${2>1}">
    欢迎您来到我的主页.
</c:if>
<hr/>
<c:forEach items="${strs }" var="s" begin="0" end="10" step="3" varStatus="cnt">
    ${cnt.index }:${s }<br/>
</c:forEach>

<c:forEach items="${arr}" var="arr1" begin="0" end="${arr.size()-1}" varStatus="cnt">
    ${cnt.first}:${arr1}<br/>

</c:forEach>

</body>
</html>
