<%--
  Created by IntelliJ IDEA.
  User: samantharamos
  Date: 8/28/23
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
    boolean methodIsPost = false;
%>
<%

    if (request.getMethod().equalsIgnoreCase("POST")) {
        methodIsPost = true;
    }
    if (methodIsPost) {

        if (request.getParameter("username").equals("admin") && request.getParameter("password").equals("password")) {
            response.sendRedirect("/profile.jsp");
        }

    }
%>

<html>
<head>
    <title>Log in</title>
    <%@include file="partials/head.jsp"%>
</head>
<body>

<%@ include file="partials/navbar.jsp"%>


<H3>Login Here</H3>

<form action="login.jsp" method="POST">
    <input type="text" name="username" placeholder="enter username">
    <input type="text" name="password" placeholder="enter password">
    <button>Submit</button>

</form>


</body>
</html>
