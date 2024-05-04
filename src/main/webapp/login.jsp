<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="includes/header.jsp"%>

<script type="text/javascript">
$(document).ready(function() {
    $("form").on("submit", function(event) {
        event.preventDefault();
        const formValue = $(this).serialize();
        $.ajax("login", {
            type: "POST",
            data: formValue,
            statusCode: {
                200: function(response) {
                    if (response === "ok") {
                        window.location.href = "/bermecars";
                    } else {
                        $("#result").html(response);
                    }
                }
            }
        });
    });
});
</script>

<main class="form-signin w-100 m-auto p-5">
    <form class="p-5">
        <h1 class="h3 mb-3 fw-normal">Iniciar sesión</h1>

        <div class="form-floating">
            <input type="text" name="username" class="form-control" id="floatingInput" placeholder="Usuario">
            <label for="floatingInput">Usuario</label>
        </div>
        <div class="form-floating py-2">
            <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Contraseña">
            <label for="floatingPassword">Contraseña</label>
        </div>

        <button class="btn btn-primary w-100 py-2" type="submit">Iniciar sesión</button>
    </form>
    <br/>
    <div id="result"></div>
</main>