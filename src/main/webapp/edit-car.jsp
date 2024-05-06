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
        <% if (id == 0) { %>
            <h1>Registrar nueva Actividad</h1>
        <% } else { %>
            <h1>Modificar Actividad</h1>
        <% } %>
        <form class="row g-3 needs-validation" method="post" enctype="multipart/form-data" id="edit-form">
            <div class="mb-3">
                <label for="name" class="form-label">Marca</label>
                <input type="text" name="name" class="form-control" id="name" placeholder="Ir a caminar"
                    <% if (id != 0) { %> value="<%= car.getBrand() %>"<% } %>>
            </div>

            <div class="mb-3">
                <label for="description" class="form-label">Modelo</label>
                <textarea rows="4" name="description" cols="50" class="form-control" id="description" placeholder="Descripción de la actividad">
<% if (id != 0) { %> <%= car.getModel() %><% } %>
                </textarea>
            </div>

            <div class="col-md-4">
                <label for="license?plate" class="form-label">Matricula</label>
                <input type="date" name="license" class="form-control" id="license" placeholder=""
                   <% if (id != 0) { %> <%= car.getLicense_plate() %><% } %>
            </div>

            <div class="col-md-4">
                <label for="Pais" class="form-label">Pais</label>
                <input type="date" name="date" class="form-control" id="date" placeholder=""
                   <% if (id != 0) { %> <%= car.getCountry() %><% } %>
            </div>
            <div class="col-md-4">
                <label for="year" class="form-label">Año</label>
                <input type="date" name="date" class="form-control" id="date" placeholder=""
                   <% if (id != 0) { %> <%= car.getYear() %><% } %>
            </div>
            <div class="col-md-4">
                <label for="price" class="form-label">Precio</label>
                <input type="text" name="price" class="form-control" id="price" placeholder=""
                    <% if (id != 0) { %> value="<%= car.getPrice() %>"<% } %>>
            </div>

            <div class="col-md-4">
                <label for="photo" class="form-label">Foto</label>
                <input type="file" name="picture" class="form-control" id="picture">
            </div>
            <div class="col-12">
                <input type="submit" value="Enviar" id="edit-button"/>
            </div>
            <input type="hidden" name="id" value="<%= id %>"/>
        </form>
        <br/>
        <div id="result"></div>
    </section>
</main>

