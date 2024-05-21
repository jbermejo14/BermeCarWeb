<%@ page import="com.bermecar.dao.Database" %>
<%@ page import="com.bermecar.dao.ReservationDao" %>
<%@ page import="com.bermecar.domain.Reservation" %>
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
        <h1>Reservas</h1>
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
            List<Reservation> reservations = null;
            if (search.isEmpty()) {
                reservations = Database.jdbi.withExtension(ReservationDao.class, dao -> dao.getAllReservations());
            } else {
                final String searchTerm = search;
                reservations = Database.jdbi.withExtension(ReservationDao.class, dao -> dao.getReservations(searchTerm));
            }
            %>
                <%
                    if (role.equals("admin")) {
                %>
                    <a href="add-reservation.jsp" class="btn btn-primary">Añadir</a>
                <%
                   }
                %>
               <%
                for (Reservation reservation : reservations) {
            %>

    <div class="container">
        <div class="list-group">
            <a href="view-reservation.jsp?id=<%= reservation.getId() %>" type="button" class="btn btn-sm btn-black m-2">
                <div class="d-flex w-100 justify-content-between">
                    <h6 class="mb-1">Reservation Nº: <%=reservation.getId()%></h6>
                    <p class="mb-1"><%=reservation.getDatetime()%></p>
                    <p class="mb-1"><%=reservation.getUser().getUsername()%></p>
                    <p class="mb-1"><%=reservation.getCar().getBrand()%></p>
                    <p class="mb-1"><%=reservation.getCar().getModel()%></p>
                </div>
            </a>
        </div>
    </div>
    <%
        }
    %>

</main>