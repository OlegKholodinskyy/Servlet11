<%@ page import="model.Item" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Item management</title>
    <link href="/css/myDesign.css" rel="stylesheet" type="text/css">
</head>
<body>
<div class="form-style-2">
    <form method="post" action="/items">
        <label for="name"> Item name
            <input type="text" id="name" name="name">
        </label>
        <label for="description"> Description
            <input type="text" id="description" name="description">
        </label>
        <input type="submit" value="Add item">
    </form>
</div>

<div class="form-style-2">
    <div class="form-style-2-heading">Table of items</div>


    <table border="1">
        <tr>
            <th>id</th>
            <th>name</th>
            <th>dateCreated</th>
            <th>lastUpdatedDate</th>
            <th>description</th>
            <th>edit</th>
            <th>delete</th>
        </tr>
        <c:forEach items="${items}" var="item">
            <tr>
                <td>${item.id}</td>
                <td>${item.name}</td>
                <td>${item.dateCreated}</td>
                <td>${item.lastUpdatedDate}</td>
                <td>${item.description}</td>
                <td><a href="editItem?id=<c:out value='${item.id}' />">Edit </a></td>
                <td><a href="deleteItem?id=<c:out value='${item.id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

</div>
</div>

</body>
</html>
