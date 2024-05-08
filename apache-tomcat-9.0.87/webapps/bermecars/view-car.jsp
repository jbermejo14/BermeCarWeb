<%@ page import="com.bermecar.dao.Database" %>
<%@ page import="com.bermecar.dao.CarDao" %>
<%@ page import="com.bermecar.domain.Car" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<body>
    <main>
        <%
          int id = Integer.parseInt(request.getParameter("id"));
          Database.connect();
          Car car = Database.jdbi.withExtension(CarDao.class, dao -> dao.getCar(id));
        %>
        <div class="container">
            <div class="card text-center">
                <div class="card-header">Coche</div>
                <div class="card-body">
                    <img src="../bermecar-pictures/<%= car.getPhoto() %>"/>
                    <h5 class="card-title"><%= car.getBrand() %></h5>
                    <p class="card-text"><%= car.getModel() %></p>
                    <p class="card-text"><%= car.getYear() %></p>
                    <p class="card-text"><%= car.getPrice() %></p>
                    <a href="reservecar?id=<%= car.getId() %>" class="btn btn-primary">Reservar</a>
                    <%
                        if (role.equals("admin")) {
                    %>
                        <a href="removecar?id=<%= car.getId()%>" class="btn btn-primary">Borrar</a>
                    <%
                       }
                    %>
                </div>
            </div>
        </div>
    </main>
</body>