<%--
  Created by IntelliJ IDEA.
  User: Petro
  Date: 16.05.2015
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Film Registration Form</title>
    <jsp:include page="style.jsp"/>
    <script>
        var optionsCategories = ${categoriesStr};
        var optionsAutors = ${autorsStr};
        function addCategory() {
            var i = Number(document.getElementById("numOfCategories").innerHTML);
            i+=1;
            document.getElementById("numOfCategories").innerHTML = i;
            i-=1;
            document.getElementById("categoriesSelects").innerHTML +="<select id=\"Category_id"+i+"\" name=\"Category_id["+i+"]\">"
            +optionsCategories +"</select>";
        }
        function addAutor() {
            var i = Number(document.getElementById("numOfAutors").innerHTML);
            i+=1;
            document.getElementById("numOfAutors").innerHTML = i;
            i-=1;
            document.getElementById("autorsSelects").innerHTML +="<select id=\"Film_autor_id"+i+"\" name=\"Film_autor_id["+i+"]\">"
            +optionsAutors +"</select>";
        }
    </script>
</head>

<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <h2>Registration Form</h2>

    <form:form method="POST" modelAttribute="film">
        <table class="table">
            <tr>
                <td><label for="title">Title: </label></td>
                <td><form:input path="title" id="title"/></td>
                <td><form:errors path="title" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label><a id="numOfCategories">1</a> categories: </label></td>
                <td id="categoriesSelects">
                    <form:select path="Category_id[0]">
                        <form:options items="${categories}"/>
                    </form:select>
                </td>
                <td>
                    <button onclick="addCategory()" type="button" >addCategory</button>
                </td>
            </tr>

            <tr>
                <td><label for="length">Length: </label></td>
                <td><form:input path="length" id="length"/></td>
                <td><form:errors path="length" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="description">Description: </label></td>
                <td><form:input path="description" id="description"/></td>
                <td><form:errors path="description" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="tiket_price">Tiket price: </label></td>
                <td><form:input path="tiket_price" id="tiket_price"/></td>
                <td><form:errors path="tiket_price" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="central_rental_price">Central rental price: </label></td>
                <td><form:input path="central_rental_price" id="central_rental_price"/></td>
                <td><form:errors path="central_rental_price" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="release_year">Release year: </label></td>
                <td><form:input path="release_year" id="release_year"/></td>
                <td><form:errors path="release_year" cssClass="error"/></td>
            </tr>

            <tr>
                <td><label for="language_id">Language:</label></td>
                <td><form:select path="language_id">
                    <form:options items="${languages}"/>
                </form:select></td>
            </tr>

            <tr>
                <td><label for="original_language_id">Original language: </label></td>
                <td><form:select path="original_language_id">
                    <form:options items="${languages}"/>
                </form:select></td>
            </tr>

            <tr>
                <td><label><a id="numOfAutors">1</a> autors:</label></td>
                <td id="autorsSelects"><form:select path="Film_autor_id[0]">
                    <form:options items="${autor}"/>
                </form:select></td>
                <td>
                    <button onclick="addAutor()" type="button" >addAutor</button>
                </td>
            </tr>

            <tr>
                <td colspan="3"><input type="submit" value="Register"/></td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/filmlist' />">List of All Filmss</a>
</div>
</body>
</html>
