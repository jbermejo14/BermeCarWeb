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

<%
    if (role.equals("user")) {
%>
<header data-bs-theme="dark">
    <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
              <li><a href="/bermecars" class="nav-link px-2 text-secondary">Home</a></li>
              <li><a href="#" class="nav-link px-2 text-white">Comprar</a></li>
              <li><a href="#" class="nav-link px-2 text-white">Alquilar</a></li>
        </div>
        <button type="button" class="btn btn-outline-light me-2"><a href="logout" title="Iniciar sesión" class="text-decoration-none">Logout</a></button>
    </div>
</header>
<%
    } if (role.equals("admin")){
%>
<header data-bs-theme="dark">
    <div class="navbar navbar-dark bg-dark shadow-sm">
        <div class="container">
            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
              <li><a href="/bermecars" class="nav-link px-2 text-secondary">Home</a></li>
              <li><a href="#" class="nav-link px-2 text-white">Comprar</a></li>
              <li><a href="#" class="nav-link px-2 text-white">Alquilar</a></li>
              <li><a href="#" class="nav-link px-2 text-white">Editar</a></li>
        </div>
        <button type="button" class="btn btn-outline-light me-2"><a href="logout" title="Iniciar sesión" class="text-decoration-none">Logout</a></button>
    </div>
</header>
<%
    }
%>
