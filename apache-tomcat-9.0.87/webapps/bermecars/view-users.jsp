<%@ page import="com.bermecar.dao.Database" %>
<%@ page import="com.bermecar.dao.UserDao" %>
<%@ page import="com.bermecar.domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<body>
    <main>
        <%
          int id = Integer.parseInt(request.getParameter("id"));
          Database.connect();
          User user = Database.jdbi.withExtension(UserDao.class, dao -> dao.getUser(id));
        %>
        <div class="container my-5">
            <div class="card text-center">
                <div class="card-header">Usuario</div>
                <div class="card-body">
                    <h5 class="card-title">Nombre de usuario: <%= user.getUsername() %></h5>
                    <h6 class="card-text">Telefono: <%= user.getTelephone() %></h6>
                    <h6 class="card-text">Email: <%= user.getEmail() %></h6>
                    <a href="removeuser?id=<%= user.getId()%>" class="btn btn-primary">Borrar</a>
                    <a href="admin-edit-users.jsp?id=<%= user.getId() %>" type="button" class="btn btn-sm btn-black m-2">Editar</a>
                </div>
            </div>
        </div>

    </main>
</body>