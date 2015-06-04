<%--
  Created by IntelliJ IDEA.
  User: Petro
  Date: 16.05.2015
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Fims</title>
    <jsp:include page="style.jsp"/>
</head>

<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <div class="well well-sm">
        <h2>List of Films</h2>
    </div>

    <div class="container">
        <form:form method="POST" modelAttribute="filmer">
            <div class="list-inline">
                <label>Category:</label>
                <form:select onchange="this.form.submit()" path="Category_id">
                    <form:option value="-1" label="---SELECT PLEASE---"/>
                    <form:option value="0" label="All"/>
                    <form:options items="${categories}"/>
                </form:select>
                <%--<input type="submit" value="Go"/>--%>
            </div>
        </form:form>
    </div>
    <div class="table-responsive">
        <table class="table table-bordered">
            <tr>
                <td>Title</td>
                <td>Category</td>
                <td>Description</td>
                <td>Tiket price</td>
                <td>Central rental price</td>
                <td>Release year</td>
                <td>Language</td>
                <td>Original language</td>
                <td>Autors</td>
                <td>Enters</td>
                <td>Rating</td>
                <td>Profit</td>
                <td>id to delete</td>
            </tr>
            <c:forEach items="${ss}" var="film">
                <tr>
                        ${film}
                </tr>
            </c:forEach>
        </table>
    </div>
    <br/>
    <a href="<c:url value='/newfilm' />">Add New Film</a>
</div>
</body>
</html>
