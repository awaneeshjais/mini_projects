<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Онлайн-касса</title>
</head>
<body>
<a href="index.jsp">Окно входа</a>&vert;
<h1>Вас приветствует онлайн-касса продажи-брони билетов!!!</h1>
<hr>

<FORM name="input_login" METHOD="POST" ACTION="enter_page.jsp">
<input type="submit" value="Вход">
</FORM>
<br>
<FORM name="input_reg" METHOD="POST" ACTION="reg_page.jsp">
<input type="submit" value="Регистрация">
</FORM>
<br>
<FORM name="input_admin" METHOD="POST" ACTION="admin_page.jsp">
<input type="submit" value="Добавить сеанс">
</FORM>
<br>
</body>
</html>