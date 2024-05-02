<%@ page import="com.bermecar.dao.Database" %>
<%@ page import="com.bermecar.dao.ActivityDao" %>
<%@ page import="com.bermecar.domain.Activity" %>
<%@ page import="com.bermecar.util.CurrencyUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<main>
    <section class="py-5 text-center container">
        <h1>Ver Actividad</h1>
    </section>
        <%
          // TODO Validar si viene el campo id
          int id = Integer.parseInt(request.getParameter("license_plate"));

          Database.connect();
          Car car = Database.jdbi.withExtension(CarDao.class, dao -> dao.getCar(license_plate));
        %>
    <div class="container">
        <div class="card text-center">
            <div class="card-header">
                CAR
            </div>
            <div class="card-body">
                <h5 class="card-title"><%= car.getBrand() %></h5>
                <p class="card-text"><%= car.getModel() %></p>
                <a href="#" class="btn btn-primary">Apuntarme</a>
            </div>
            <div class="card-footer text-body-secondary">
                <small class="text-body-secondary"><%= car.getPrice() %> €</small>
            </div>
        </div>
    </div>
</main>

