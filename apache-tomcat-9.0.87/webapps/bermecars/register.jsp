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
body {
    font-family: "Lato", sans-serif;
}



.main-head{
    height: 150px;
    background: #FFF;

}

.sidenav {
    height: 100%;
    background-color: #000;
    overflow-x: hidden;
    padding-top: 20px;
}


.main {
    padding: 0px 10px;
}

@media screen and (max-height: 450px) {
    .sidenav {padding-top: 15px;}
}

@media screen and (max-width: 450px) {
    .login-form{
        margin-top: 10%;
    }

    .register-form{
        margin-top: 10%;
    }
}

@media screen and (min-width: 768px){
    .main{
        margin-left: 40%;
    }

    .sidenav{
        width: 40%;
        position: fixed;
        z-index: 1;
        top: 0;
        left: 0;
    }

    .login-form{
        margin-top: 10%;
    }

}


.login-main-text{
    margin-top: 20%;
    padding: 60px;
    color: #fff;
}

.login-main-text h2{
    font-weight: 300;
}

.btn-black{
    background-color: #000 !important;
    color: #fff;
}
</style>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    $("form").on("submit", function(event) {
        event.preventDefault();
        const formValue = $(this).serialize();
        $.ajax("register", {
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
<div class="sidenav">
         <div class="login-main-text">
            <h2>Bermecars<br></h2>
            <p>Necesitas una cuenta para acceder</p>
         </div>
      </div>
      <div class="main">
         <div class="col-md-12 col-sm-12">
            <div class="login-form">
                <form class="p-5">
                    <div class="form-group">
                        <input type="text" name="telephone" class="form-control" id="floatingTelephone" placeholder="Telephone">
                        <label for="floatingInput">Telefono</label>
                    </div>
                    <div class="form-group py-2">
                        <input type="text" name="username" class="form-control" id="floatingInput" placeholder="Usuario">
                        <label for="floatingInput">Usuario</label>
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" class="form-control" id="floatingPassword" placeholder="Contraseña">
                        <label for="floatingPassword">Contraseña</label>
                    </div>
                    <button class="btn btn-black w-100" type="submit">Registrarse</button>
                    <p class="h5 fw-normal"><a href="login.jsp" class="nav-link">¿Tienes ya cuenta? Inicia Sesión!</a></p>
                </form>
                <div id="result"></div>
            </div>
         </div>
      </div>
</main>