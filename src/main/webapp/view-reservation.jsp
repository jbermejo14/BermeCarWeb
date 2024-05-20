<%@ page import="com.bermecar.dao.Database" %>
<%@ page import="com.bermecar.dao.ReservationDao" %>
<%@ page import="com.bermecar.domain.Reservation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@include file="includes/header.jsp"%>

<body>
    <main>
        <%
          int id = Integer.parseInt(request.getParameter("id"));
          Database.connect();
          Reservation reservation = Database.jdbi.withExtension(ReservationDao.class, dao -> dao.getReservation(id));
        %>
        <div class="container my-5">
            <div class="card text-center">
                <div class="card-header">Reserva</div>
                <div class="card-body">
                    <h6 class="mb-1">Reserva Nº: <%=reservation.getId()%></h6>
                    <p class="mb-1"><%=reservation.getDatetime()%></p>
                    <a href="removereservation?id=<%= reservation.getId()%>" class="btn btn-primary">Borrar</a>
                </div>
            </div>
        </div>
    </main>
</body>