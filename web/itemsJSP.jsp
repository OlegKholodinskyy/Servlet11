<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Items Management</title>
</head>
<body>
<center>
    <h1>Items</h1>
    <h2>
        <a href="new">Add New Item</a>

        <a href="list">List All Items</a>

    </h2>
</center>
<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Items</h2></caption>
        <tr>
            <th>id</th>
            <th>name</th>
            <th>dateCreated</th>
            <th>lastUpdatedDate</th>
            <th>description</th>
        </tr>
        <c:forEach var="user" items="${listUser}">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.name}"/></td>
                <td><c:out value="${user.dateCreated}"/></td>
                <td><c:out value="${user.lastUpdatedDate}"/></td>
                <td><c:out value="${user.description}"/></td>
                <td>
                    <a href="edit?id=<c:out value='${user.id}' />">Edit</a>
                    <a href="delete?id=<c:out value='${user.id}' />">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>