<%--
  Created by IntelliJ IDEA.
  User: Petro
  Date: 21.05.2015
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tickets</title>
    <jsp:include page="style.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="well well-sm">
        <h2>List of Tickets</h2>
    </div>
    <div class="table-responsive">
        <table class="table table-bordered">
            <tr>
                <td>Customer name</td>
                <td>Cinema Name</td>
                <td>Film Name</td>
                <td>Watching date</td>
                <td>Pay</td>
            </tr>
            <c:forEach items="${ss}" var="ticket">
                <tr>
                        ${ticket}
                </tr>
            </c:forEach>
        </table>
    </div>
    <br/>
    <a href="<c:url value='/newticket' />">Add New Ticket</a>
</div>
</body>
</html>
