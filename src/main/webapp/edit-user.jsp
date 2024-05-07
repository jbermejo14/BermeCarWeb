<%@ page import="com.bermecar.domain.User" %>
<%@ page import="com.bermecar.dao.UserDao" %>
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
                url: "edit-user",
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
    if (request.getSession().getAttribute("id") == null) {
        response.sendRedirect("index.jsp");
    }
  Database.connect();
  final int theUserid = userId;
  User user = Database.jdbi.withExtension(UserDao.class, dao -> dao.getUser(theUserid));
%>

<main>
    <section class="py-5 container">
        <h1>Modificar Perfil</h1>
        <form class="row g-3 needs-validation" method="post" id="edit-form">
            <div class="mb-3">
                <label for="username" class="form-label">Nombre de usuario:</label>
                <input type="text" name="username" class="form-control" id="username"
                    value="<%= user.getUsername() %>">
            </div>

            <div class="mb-3">
                <label for="telephone" class="form-label">Telefono</label>
                <input type="text" name="telephone" class="form-control" id="telephone"
                    value="<%= user.getTelephone() %>">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Contraseña</label>
                <input type="text" name="password" class="form-control" id="password">
            </div>
            <div class="col-12">
                <input type="submit" value="Enviar" id="edit-button"/>
            </div>
        </form>
        <br/>
        <div id="result"></div>
    </section>
</main>

