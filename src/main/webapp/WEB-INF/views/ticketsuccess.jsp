<%--
  Created by IntelliJ IDEA.
  User: Petro
  Date: 25.05.2015
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration Confirmation Page</title>
    <jsp:include page="style.jsp"/>
</head>
<body>

<jsp:include page="header.jsp"/>
message : ${ticketsuccess}
<br/>
<br/>
Go back to <a href="<c:url value='/ticketlist' />">List of All Tickets</a>
</body>
</html>
