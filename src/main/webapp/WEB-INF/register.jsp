<%--
  Created by IntelliJ IDEA.
  User: samantharamos
  Date: 9/6/23
  Time: 10:24 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register"/>
    </jsp:include>

</head>
<body>
<jsp:include page="partials/navbar.jsp"></jsp:include>

<c:if test="${invalid == true}">
    <h2>please try again</h2>
</c:if>
</body>
</html>
