<%--
  Created by IntelliJ IDEA.
  User: Petro
  Date: 18.05.2015
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Cinema Registration Form</title>
    <jsp:include page="style.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>


<div class="container">
    <h2>Registration Form</h2>
    <form:form method="POST" modelAttribute="cinema">
        <table class="table">
            <tr>
                <td><label for="name">Name: </label></td>
                <td><form:input path="name" id="name"/></td>
                <td><form:errors path="name" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="address_id">address:</label></td>
                <td><form:select path="address_id">
                    <%--<form:option value="NONE" label="--- Select ---" />--%>
                    <form:options items="${address}"/>
                </form:select></td>
            </tr>
            <tr>
                <td><label for="area">Area: </label></td>
                <td><form:input path="area" id="area"/></td>
                <td><form:errors path="area" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="comunal_pos">Utilities: </label></td>
                <td><form:input path="comunal_pos" id="comunal_pos"/></td>
                <td><form:errors path="comunal_pos" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="Rent_pay">Rent pay: </label></td>
                <td><form:input path="Rent_pay" id="Rent_pay"/></td>
                <td><form:errors path="Rent_pay" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="product">Product: </label></td>
                <td><form:input path="product" id="product"/></td>
                <td><form:errors path="product" cssClass="error"/></td>
            </tr>


            <tr>
                <td colspan="3"><input type="submit" value="Register"/></td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/cinemalist' />">List of All Filmss</a>
</div>



</body>
</html>
