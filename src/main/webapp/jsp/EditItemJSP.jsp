<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Edit Item</title>
    <link href="/css/myDesign.css" rel="stylesheet" type="text/css">

</head>
<body>

<div class="form-style-2">
    <form method="post" action="/editItem">

        <label for="id" > id (readonly)
            <input type="text" id="id" name="id" value="${item.id}" readonly>
        </label>
        <br />
        <label for="name"> name (readonly)
            <input type="text" id="name" name="name" value="${item.name}" readonly>
        </label>
        <br />
        <label for="dateCreated"> dateCreated (readonly)
            <input type="text" id="dateCreated" name="dateCreated" value="${item.dateCreated}" readonly>
        </label>
        <br />
        <label for="dateCreated"> lastUpdatedDate (readonly)
            <input type="text" id="lastUpdatedDate" name="dateCreated" value="${item.lastUpdatedDate}" readonly>
        </label>
        <br />
        <label for="description"> description
            <input type="text" id="description" name="description" value="${item.description}">
        </label>

        <input type="submit" value="Edit item">
    </form>
</div>


</body>
</html>
