<!DOCTYPE HTML>
<%@ page import="connectionDB.*" %>
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
<h2>Панель администратора</h2>

<FORM name="input1" accept-charset="UTF-8" METHOD="POST" ACTION="SeanceServlet">
Страна 
<select name="country">
<option value="Украина">Украина</option>
<option value="Россия">Россия</option>
<option value="Белорусь">Белорусь</option>
<option value="Молдова">Молдова</option>
</select>
<br>

Город<input type="text" name="town"><br>
Кинотеатр<input type="text" name="theatre"><br>
Зал<input type="text" name="hall"><br>
Дата сеанса
<select name="date_dd">
<option value="1">01</option>
<option value="2">02</option>
<option value="3">03</option>
<option value="4">04</option>
<option value="5">05</option>
<option value="6">06</option>
<option value="7">07</option>
<option value="8">08</option>
<option value="9">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
<option value="24">24</option>
<option value="25">25</option>
<option value="26">26</option>
<option value="27">27</option>
<option value="28">28</option>
<option value="29">29</option>
<option value="30">30</option>
<option value="31">31</option>
</select>
<select name="date_mm">
<option value="1">01</option>
<option value="2">02</option>
<option value="3">03</option>
<option value="4">04</option>
<option value="5">05</option>
<option value="6">06</option>
<option value="7">07</option>
<option value="8">08</option>
<option value="9">09</option>
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
</select>
<select name="date_yyyy">
<option value="2014">2014</option>
<option value="2015">2015</option>
<option value="2016">2016</option>
</select>
<br>

Время сеанса
<select name="time_hours">
<option value="10">10</option>
<option value="11">11</option>
<option value="12">12</option>
<option value="13">13</option>
<option value="14">14</option>
<option value="15">15</option>
<option value="16">16</option>
<option value="17">17</option>
<option value="18">18</option>
<option value="19">19</option>
<option value="20">20</option>
<option value="21">21</option>
<option value="22">22</option>
<option value="23">23</option>
</select>
<select name="time_minutes">
<option value="0">00</option>
<option value="15">15</option>
<option value="30">30</option>
<option value="45">45</option>
</select>
<br>
Название фильма<input type="text" name="name_seance"><br>
Количество мест<input type="text" name="count_ticket"><br>
Цена билетов<input type="text" name="cost_ticket">грн.<br>
<input type="submit" value="Создать сеанс">
</FORM>

</body>
</html>