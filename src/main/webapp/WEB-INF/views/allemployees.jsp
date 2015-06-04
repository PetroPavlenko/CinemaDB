
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>University Enrollments</title>
    <jsp:include page="style.jsp"/>
</head>

<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="well well-sm">
        <h2>List of Employees</h2>
    </div>
    <div class="table-responsive">
        <table class="table table-bordered">
            <tr>
                <td>NAME</td>
                <td>Joining Date</td>
                <td>Salary</td>
                <td>SSN</td>
            </tr>
            <c:forEach items="${employees}" var="employee">
                <tr>
                    <td>${employee.name}</td>
                    <td>${employee.joiningDate}</td>
                    <td>${employee.salary}</td>
                    <td><a href="<c:url value='/delete-${employee.ssn}-employee' />">${employee.ssn}</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <br/>
    <a href="<c:url value='/new' />">Add New Employee</a>
</div>
</body>
</html>