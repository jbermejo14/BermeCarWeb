<%@ page import="com.bermecar.domain.Reservation" %>
<%@ page import="com.bermecar.dao.ReservationDao" %>
<%@ page import="com.bermecar.dao.Database" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>
<style>
    .btn-black{
        background-color: #000 !important;
        color: #fff;
    }
</style>
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
                url: "add-reservation",
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
    Reservation reservation = null;
    if (request.getParameter("id") == null) {
        id = 0;
    } else {
        id = Integer.parseInt(request.getParameter("id"));
        Database.connect();
        reservation = Database.jdbi.withExtension(ReservationDao.class, dao -> dao.getReservation(id));
    }
%>

<main>
    <section class="py-5 container">
        <h1>Añadir Reserva</h1>
        <form class="row g-3 needs-validation" method="post" enctype="multipart/form-data" id="edit-form">
            <div class="mb-3">
                <label for="datetime" class="form-label">Fecha</label>
                <input type="Date" name="datetime" class="form-control" id="datetime">
            </div>
            <div class="mb-3">
                <label for="id_cars" class="form-label">ID coche</label>
                <input type="text" name="id_cars" class="form-control" id="id_cars">
            </div>
            <div class="mb-3">
                <label for="id_users" class="form-label">ID usuario</label>
                <input type="text" name="id_users" class="form-control" id="id_users">
            </div>
            <div class="col-12">
                <button class="btn btn-black w-100" id="edit-button" type="submit">Enviar</button>
            </div>
        </form>
        <div id="result"></div>
    </section>
</main>

