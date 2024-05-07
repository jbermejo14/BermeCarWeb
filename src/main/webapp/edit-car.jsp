<%@ page import="com.bermecar.domain.Car" %>
<%@ page import="com.bermecar.dao.CarDao" %>
<%@ page import="com.bermecar.dao.Database" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<script>
    $(document).ready(function () {
        $("#edit-button").click(function (event) {
            event.preventDefault();
            const form = $("#edit-form")[0];
            const data = new FormData(form);

            $("#edit-button").prop("disabled", true);

            $.ajax({
                type: "POST",
                enctype: "multipart/form-data",
                url: "edit-car",
                data: data,
                processData: false,
                contentType: false,
                cache: false,
                timeout: 600000,
                success: function (data) {
                    $("#result").html(data);
                    $("#name").value("");
                    $("#edit-button").prop("disabled", false);
                },
                error: function (error) {
                    $("#result").html(error.responseText);
                    $("#edit-button").prop("disabled", false);
                }
            });
        });
    });
</script>

<%
    if (!role.equals("admin")) {
        response.sendRedirect("/bermecars");
    }

    int id;
    Car car = null;
    if (request.getParameter("id") == null) {
        // Se accede al formulario para crear una nueva actividad
        id = 0;
    } else {
        // Se accede al formulario para editar una actividad existente
        id = Integer.parseInt(request.getParameter("id"));
        Database.connect();
        car = Database.jdbi.withExtension(CarDao.class, dao -> dao.getCar(id));
    }
%>

<main>
    <section class="py-5 container">
        <h1>Registrar nuevo Coche</h1>
        <form class="row g-3 needs-validation" method="post" enctype="multipart/form-data" id="edit-form">
            <div class="mb-3">
                <label for="brand" class="form-label">Marca</label>
                <input type="text" name="brand" class="form-control" id="brand"value="<%= car.getBrand() %>">
            </div>
            <div class="mb-3">
                <label for="model" class="form-label">Modelo</label>
                <input type="text" name="model" class="form-control" id="model"value="<%= car.getModel() %>">
            </div>
            <div class="mb-3">
                <label for="license_plate" class="form-label">Matricula</label>
                <input type="text" name="license_plate" class="form-control" id="license_plate"
                    value="<%= car.getLicense_plate() %>">
            </div>

            <div class="mb-3">
                <label for="country" class="form-label">Pais</label>
                <input type="text" name="country" class="form-control" id="country" value="<%= car.getCountry() %>">
            </div>
            <div class="mb-3">
                <label for="year" class="form-label">Año</label>
                <input type="number" name="year" class="form-control" id="year" value="<%= car.getYear() %>">
            </div>
            <div class="mb-3">
                <label for="price" class="form-label">Precio</label>
                <input type="number" name="price" class="form-control" id="price" value="<%= car.getPrice() %>">
            </div>
            <div class="col-12">
                <input type="submit" value="Enviar" id="edit-button"/>
            </div>
        </form>
        <div id="result"></div>
    </section>
</main>

