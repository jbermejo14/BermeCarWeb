
<%@ page import="com.bermecar.dao.Database" %>
<%@ page import="com.bermecar.dao.ReservationDao" %>
<%@ page import="com.bermecar.domain.Reservation" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<main>
    <section class="py-5 text-center container">
        <h1>Mis Reservas</h1>
    </section>
        <%
            if (request.getSession().getAttribute("id") == null) {
                response.sendRedirect("index.jsp");
            }
          Database.connect();
          final int theUserid = userId;
          List<Reservation> reservations = Database.jdbi.withExtension(ReservationDao.class, dao -> dao.getReservationByUser(theUserid));
        %>
    <div class="container">
        <div class="list-group">
            <%
                for (Reservation reservation : reservations) {
            %>
            <a href="#" class="list-group-item list-group-item-action active" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <h5 class="mb-1"><%=reservation.getDatetime()%></h5>
                </div>
                <p class="mb-1"><%=reservation.getId()%></p>
            </a>
            <%
                }
            %>
        </div>
    </div>
</main>
