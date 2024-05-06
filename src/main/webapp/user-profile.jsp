<%@ page import="com.bermecar.dao.Database" %>
<%@ page import="com.bermecar.dao.CarDao" %>
<%@ page import="com.bermecar.domain.Car" %>
<%@ page import="com.bermecar.domain.User" %>
<%@ page import="com.bermecar.dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<!doctype html>
<head>
<meta charset="utf-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Album example · Bootstrap v5.3</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<%
    int id;
    User user = null;
    session = request.getSession();
    id = Integer.parseInt(request.getParameter("id"));
    Database.connect();
    user = Database.jdbi.withExtension(UserDao.class, dao -> dao.getUser(id));
%>
<main>
    <section class="py-5 text-center container">
        <h1>Ver Actividad</h1>
    </section>
    <div class="container">
        <div class="card text-center">
            <div class="card-header">
                CAR
            </div>
            <div class="card-body">
                <h5 class="card-title"><%= user.getUsername() %></h5>
                <p class="card-text"><%= user.getTelephone() %></p>
            </div>

        </div>
    </div>
</main>