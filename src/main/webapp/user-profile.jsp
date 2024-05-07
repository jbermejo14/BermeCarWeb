<%@ page import="com.bermecar.dao.Database" %>
<%@ page import="com.bermecar.dao.CarDao" %>
<%@ page import="com.bermecar.domain.Car" %>
<%@ page import="com.bermecar.domain.User" %>
<%@ page import="com.bermecar.dao.UserDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<%
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    }
  Database.connect();
  final int theUserid = userId;
  User user = Database.jdbi.withExtension(UserDao.class, dao -> dao.getUser(theUserid));
%>
<main>
    <section class="py-5 text-center container">
        <h1>Tu Perfil:</h1>
    </section>
    <div class="container">
        <h5 class="card-title">Nombre de usuario: <%= user.getUsername() %></h5>
        <h6 class="card-text">Telefono: <%= user.getTelephone() %></h6>
        <a href="edit-user.jsp" class="nav-link px-2">Editar Perfil</a>
    </div>

</main>