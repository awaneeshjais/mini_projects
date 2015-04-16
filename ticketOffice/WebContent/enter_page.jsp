<!DOCTYPE HTML>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Онлайн-касса</title>
</head>
<body>
<a href="index.jsp">Окно входа</a>&vert;
<h1>Кино - касса!!!</h1>
<hr>
<h2>Войти в кассу</h2>

<FORM name="input1" accept-charset="UTF-8" METHOD="POST" ACTION="EnterServlet">
Логин<input type="text" name="login"><br>
Пароль<input type="password" name="pass"><br>
<input type="submit" value="Войти">
</FORM>
</body>
