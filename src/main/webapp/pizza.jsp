<%--
  Created by IntelliJ IDEA.
  User: samantharamos
  Date: 8/29/23
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<html>
<head>
    <title>Pizza</title>
</head>
<body>

<form action="pizza-order" method="POST">
    <input type="text" name="cursttype" placeholder="Enter type of crust">
    <input type="text" name="saucelevel" placeholder="Enter how much sauce you want">
    <input type="text" name="cheeseamount" placeholder="Enter how much cheese you want">

    <label for="pepperoni-checkbox">pepperoni</label>
    <input id="pepperoni-checkbox" type="checkbox" name="addons" value="Caramel">
    <label for="sausage-checkbox">sausage</label>
    <input id="sausage-checkbox" type="checkbox" name="addons" value="Creamer">
    <label for="bacon-checkbox">bacon</label>
    <input id="bacon-checkbox" type="checkbox" name="addons" value="Sugar">
    <button type="submit">Submit</button>

</form>


</body>
</html>