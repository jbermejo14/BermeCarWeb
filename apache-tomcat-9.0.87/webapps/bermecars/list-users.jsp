<%@ page import="com.bermecar.dao.Database" %>
<%@ page import="com.bermecar.dao.UserDao" %>
<%@ page import="com.bermecar.domain.User" %>
<%@ page import="java.util.List" %>
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
      $("#search-input").focus();
    });
</script>
<main>
    <section class="py-5 text-center container">
        <h1>Usuarios</h1>
    </section>
    <section class="py-5 text-center container">
        <form class="row g-2" id="search-form" method="GET">
            <div class="mb-1 col">
                <input type="text" class="form-control" placeholder="Búsqueda" name="search" id="search-input">
            </div>
            <div class="col-auto">
                <button type="submit" class="btn btn-black mb-3" id="search-button">Buscar</button>
            </div>
        </form>
    </section>
        <%
            String search = "";
            if (request.getParameter("search") != null)
                search = request.getParameter("search");

            Database.connect();
            List<User> users = null;
            if (search.isEmpty()) {
                users = Database.jdbi.withExtension(UserDao.class, dao -> dao.getAllUsers());
            } else {
                final String searchTerm = search;
                users = Database.jdbi.withExtension(UserDao.class, dao -> dao.getUsers(searchTerm));
            }
                for (User user : users) {
        %>
    <div class="container">
        <div class="list-group">
            <a href="add-users.jsp?id=<%= user.getId() %>" type="button" class="btn btn-sm btn-black m-2">
                <div class="d-flex w-100 justify-content-between">
                    <h6 class="mb-1">User Nº: <%=user.getId()%></h6>
                    <p class="mb-1"><%=user.getUsername()%></p>
                    <p class="mb-1"><%=user.getRole()%></p>
                </div>
            </a>
            <%
                }
            %>
        </div>
    </div>
</main>
