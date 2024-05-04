<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.bermecar.domain.Car" %>
<%@ page import="com.bermecar.dao.CarDao" %>
<%@ page import="java.util.List" %>
<%@ page import="com.bermecar.dao.Database" %>
<%@ page import="com.bermecar.util.CurrencyUtils" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="includes/header.jsp"%>
<!doctype html>
  <head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bermecars</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

  </head>
  <body>
      <div class="album py-5 bg-body-tertiary">
        <div class="container">
          <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
            <%
              Database.connect();
              List<Car> cars = Database.jdbi.withExtension(CarDao.class, dao -> dao.getAllCars());
              for (Car car : cars) {
            %>
            <div class="col">
              <div class="card shadow-sm">
                  <img src="../bermecar-pictures/<%= car.getPhoto() %>"/>
                <div class="card-body">
                  <p class="card-text"><strong><%= car.getBrand() %></strong></p>
                  <p class="card-text"><%= car.getModel() %></p>
                  <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                      <a href="view-car.jsp?id=<%= car.getId() %>" type="button" class="btn btn-sm btn-outline-primary">Ver</a>
                                         </div>
                <small class="text-body-secondary"><%= car.getPrice() %> €</small>
                  </div>
                </div>
              </div>
            </div>
            <%
              }
            %>
          </div>
        </div>
      </div>
    </body>
</html>
