<%--
  Created by IntelliJ IDEA.
  User: Petro
  Date: 25.05.2015
  Time: 22:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Get ticket</title>
    <jsp:include page="style.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>


<div class="container">
    <h2>Registration Form</h2>

    <form:form method="POST" modelAttribute="ticket">
        <table class="table">
            <tr>
                <td><label for="customer_id">Customer: </label></td>
                <td><form:select path="customer_id">
                    <form:options items="${customers}"/>
                </form:select></td>
            </tr>

            <tr>
                <td><label for="film_id">Film: </label></td>
                <td><form:select path="film_id">
                    <form:options items="${films}"/>
                </form:select></td>
            </tr>

            <tr>
                <td><label for="cinema_id">Cinema: </label></td>
                <td><form:select path="cinema_id">
                    <form:options items="${cinemas}"/>
                </form:select></td>
            </tr>

            <tr>
                <td><label for="watching_date">Watching date: </label></td>
                <td colspan="2"><form:input type="datetime-local" path="watching_date" id="watching_date"/></td>
            </tr>

            <tr>
                <td><label for="pay">Pay: </label></td>
                <td><form:input path="pay" id="pay"/></td>
                <td><form:errors path="pay" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="remark">Remark: </label></td>
                <td><form:input path="remark" id="remark"/></td>
                <td><form:errors path="remark" cssClass="error"/></td>
            </tr>

            <tr>
                <td colspan="3"><input type="submit" value="Register"/></td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/ticketlist' />">List of All Tickets</a>
</div>


</body>
</html>
