package com.bermecar.servlet;

import com.bermecar.dao.CarDao;
import com.bermecar.dao.ReservationDao;
import com.bermecar.dao.Database;
import com.bermecar.domain.Car;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/reservecar")
public class ReserveServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        HttpSession session = request.getSession();
        int userId = Integer.parseInt(session.getAttribute("id").toString());

        try {
            Database.connect();

            Car car = Database.jdbi.withExtension(CarDao.class, dao -> dao.getCar(id));
            Database.jdbi.withExtension(ReservationDao.class, dao -> dao.addReservation(new Date(System.currentTimeMillis()),
                    id, userId));

            response.sendRedirect("reservation.jsp");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        } catch (SQLException sqle) {
            sqle.printStackTrace();
        }
    }
}
