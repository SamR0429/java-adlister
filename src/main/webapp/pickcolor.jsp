<%--
  Created by IntelliJ IDEA.
  User: samantharamos
  Date: 8/29/23
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Pick Color</title>
</head>
<body>

<h1>Enter your favorite color</h1>

<form method="POST" action="/color">

    <input type="text" name="colorPicked" placeholder="Enter a Color">
    <button type="submit">Submit</button>

</form>


</body>
</html>
