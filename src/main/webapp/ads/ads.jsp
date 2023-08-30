<%--
  Created by IntelliJ IDEA.
  User: samantharamos
  Date: 8/30/23
  Time: 1:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ads</title>

</head>
<body>
<h1>All ads</h1>

<c:forEach var="ad" items="${ads}">
    <h2>${ad.title}</h2>
    <p>${ad.description}</p>
</c:forEach>


</body>
</html>
