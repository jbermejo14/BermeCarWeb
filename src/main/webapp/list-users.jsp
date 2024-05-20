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
<main>
    <section class="py-5 text-center container">
        <h1>Usuarios</h1>
    </section>
        <%
            if (request.getSession().getAttribute("id") == null) {
                response.sendRedirect("index.jsp");
            }
          Database.connect();
          List<User> users = null;
          users = Database.jdbi.withExtension(UserDao.class, dao -> dao.getAllUsers());
        %>
    <div class="container">
        <div class="list-group">
            <%
                for (User user : users) {
            %>
            <a href="add-users.jsp?id=<%= user.getId() %>" type="button" class="btn btn-sm btn-black m-2">
                <div class="d-flex w-100 justify-content-between">
                    <h6 class="mb-1">User Nº: <%=user.getId()%></h6>
                    <p class="mb-1"><%=user.getUsername()%></p>
                    <p class="mb-1"><%=user.getTelephone()%></p>
                    <p class="mb-1"><%=user.getRole()%></p>
                </div>
            </a>
            <%
                }
            %>
        </div>
    </div>
</main>
