<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bermecars</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>


</head>
<style>
    header{
        background-color: #000 !important;
        color: #fff;
    }
</style>
<%
    HttpSession currentSession = request.getSession();
    String role = "anonymous";
    int userId = 0;
    if (currentSession.getAttribute("role") != null) {
        role = currentSession.getAttribute("role").toString();
    }
    if (currentSession.getAttribute("id") != null) {
        userId = Integer.parseInt(currentSession.getAttribute("id").toString());
    }
%>
<header data-bs-theme="dark">
<%
    if (role.equals("user")) {
%>

    <div class="navbar bg-black shadow-sm">
        <div class="container">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
              <li><a href="/bermecars" class="nav-link px-2 text-secondary">Home</a></li>
              <li><a href="reservation.jsp" class="nav-link px-2 text-white">Reservas</a></li>
              <li><a href="user-profile.jsp" class="nav-link px-2 text-white">Perfil</a></li>
        </div>
        <button type="button" class="btn btn-outline-light me-5"><a href="logout" title="logout" class="text-white text-decoration-none">Logout</a></button>
    </div>

<%
    } if (role.equals("admin")){
%>

    <div class="navbar bg-dark shadow-sm">
        <div class="container">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
              <li><a href="/bermecars" class="nav-link px-2 text-secondary">Home</a></li>
              <li><a href="reservation.jsp" class="nav-link px-2 text-white">Reservas</a></li>
              <li><a href="user-profile.jsp" class="nav-link px-2 text-white">Perfil</a></li>
              <li><a href="edit-car.jsp" class="nav-link px-2 text-white">Editar</a></li>
        </div>

        <button type="button" class="btn btn-outline-light text-white me-2 mr-2"><a href="logout" title="logout" class="text-decoration-none">Logout</a></button>
    </div>

<%
    }
%>
</header>