<%--
  Created by IntelliJ IDEA.
  User: Petro
  Date: 18.05.2015
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Cinema</title>
    <jsp:include page="style.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="well well-sm">
        <h2>List of Cinema</h2>
    </div>
    <div class="container list-inline">
        <form:form method="POST" modelAttribute="time">
            <div>
                <label>Start time:</label>
                <form:input cssStyle="margin-right: 5px" type="datetime-local" path="startTime" id="startTime"/>
                <label>End time:</label>
                <form:input cssStyle="margin-right: 5px" type="datetime-local" path="endTime" id="endTime"/>
                <label for="cinema_id">Cinema: </label>
                <form:select path="cinema_id">
                    <form:option value="0" label="All"/>
                    <form:options items="${cinemas}"/>
                </form:select>
            </div>
            <input type="submit" value="Go"/>
        </form:form>
        <div class="content-main">
                ${result}
        </div>
    </div>
    <div class="table-responsive" style="margin-top: 10px;">
        <table class="table table-bordered">
            <tr>
                <td>Name</td>
                <td>Address</td>
                <td>Area</td>
                <td>Utilities</td>
                <td>Rent pay</td>
                <td>Product</td>
                <td>Absolut product</td>
                <td>id to delete</td>
            </tr>
            <c:forEach items="${ss}" var="cinema">
                <tr>
                        ${cinema}
                </tr>
            </c:forEach>
        </table>
    </div>
    <br/>
    <a href="<c:url value='/newcinema' />">Add New Cinema</a>
</div>
</body>
</html>
