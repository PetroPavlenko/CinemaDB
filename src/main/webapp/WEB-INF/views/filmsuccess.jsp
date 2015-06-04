<%--
  Created by IntelliJ IDEA.
  User: Petro
  Date: 16.05.2015
  Time: 14:31
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
message : ${filmsuccess}
<br/>
<br/>
Go back to <a href="<c:url value='/filmlist' />">List of All Films</a>

</body>
</html>
