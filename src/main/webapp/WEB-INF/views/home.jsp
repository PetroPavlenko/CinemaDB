<%--
  Created by IntelliJ IDEA.
  User: Petro
  Date: 18.05.2015
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Fims</title>
    <jsp:include page="style.jsp"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<%--<div class=".container-fluid " style="--%>
    <%--margin:auto;--%>
    <%--margin-top: 4%;--%>
    <%--text-align: center;--%>
    <%--width: 200px;--%>
<%--">--%>
    <%--<ul class="nav nav-pills nav-stacked nav-pills-stacked-example">--%>
        <%--<li role="presentation" class="active"><a href="/">Home</a></li>--%>
        <%--<li role="presentation"><a href="/filmlist">Films</a></li>--%>
        <%--<li role="presentation"><a href="/cinemalist">Cinemas</a></li>--%>
        <%--<li role="presentation"><a href="/ticketlist">Tickets</a></li>--%>
    <%--</ul>--%>
<%--</div>--%>

<div class="container-fluid">
    <pre>
        Завдання
Створити БД для обліку відвідування клієнтом кінотеатру.
Про фільми в БД повинна міститися наступна інформація:
Облік фільмів.
1.	Назва+
2.	Категорія+
3.	Автор+
4.	Час+
5.	Коротка анотація+
6.	Ціна квитка+
7.	Вартість Фільму для прокату в центральній фільмотеці+
Облік відвідувачів
1.	Назва відвіданого фільму+
2.	Категорія+
3.	Автор, Час перегляду+
4.	Прізвище клієнта+
5.	№ паспорта+
6.	Адреса+
7.	Дата перегляду+
8.	Плата+
9.	Телефон+
10.	Зауваження+
Облік кінотеатру
1.	Прізвище та особові дані працівника
2.	Дані про приміщення(площа, адреса, орендна плата)
3.	Інформація про зібрані кошти
4.	Обчислювальні поля: прибуток = зібрані кошти – оренда – комунальні

Необхідно:
1.	Встановити функціональні та багатозначні залежності. За допомогою алгоритму  Codda-Fagina отримати відношення в 3(4) нормальних формах. Створити БД У Вашій папці.
2.	Створити та зв’язати таблиці, за попередньо виділеними ключами.
3.	Створити форму для введення даних. Передбачити перехід на підформу  з описом фільму.
4.	Створити сторінку доступу  для перегляду та попереднього замовлення квитків. Вигляд сторінки на Ваш розсуд.
5.	На мові запитів створити записи для реалізації функціональності програми
Кількість людей що відвідали даний фільм
Встановити рейтинг кожного фільму
Створити запити для пошуку, задавши фільтр по категорії.
•	Підрахувати прибуток на певному фільму(прибуток = сума всіх квитків на фільм – Вартість фільму для прокату в центральній фільмотеці.)
•	Підсумок грошей за 1 день.</pre>
</div>

</body>
</html>