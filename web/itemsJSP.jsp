<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<h1>Hello JSP</h1>

<%
    java.util.Date date = new java.util.Date();
%>

<h2>
   THIS IS JSP
    <%=date.toString()%>
</h2>
</body>
</html>