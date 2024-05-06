
<%@ page import="com.bermecar.dao.Database" %>
<%@ page import="com.bermecar.dao.BookingDao" %>
<%@ page import="com.bermecar.domain.Booking" %>
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
          final int Id_user = Id_user;
          List<Reservation> reservation = Database.jdbi.withExtension(ReservationDao.class, dao -> dao.getReservationByUser(Id_user));
        %>
    <div class="container">
        <div class="list-group">
            <%
                for (Car car : cars) {
            %>
            <a href="view-activity.jsp?id=<%=booking.getActivity().getId()%>" class="list-group-item list-group-item-action active" aria-current="true">
                <div class="d-flex w-100 justify-content-between">
                    <h5 class="mb-1"><%=reservation.getCar().getBrand()%></h5>
                    <small><%=reservation.getCar().getFecha()%></small>
                </div>
                <p class="mb-1"><%=reservation.getCar().getModel()%></p>
            </a>
            <%
                }
            %>
        </div>
    </div>
</main>
