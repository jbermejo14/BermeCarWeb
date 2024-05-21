package com.bermecar.servlet;
import com.bermecar.dao.CarDao;
import com.bermecar.dao.Database;
import com.bermecar.dao.ReservationDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import static com.bermecar.util.ErrorUtils.sendError;
import static com.bermecar.util.ErrorUtils.sendMessage;

@WebServlet("/add-reservation")
@MultipartConfig
public class AddReservationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        HttpSession currentSession = request.getSession();
        if (currentSession.getAttribute("role") != null) {
            if (!currentSession.getAttribute("role").equals("admin")) {
                response.sendRedirect("/bermecar");
            }
        }

        try {
            Date datetime = Date.valueOf(request.getParameter("datetime"));
            int id_cars = Integer.parseInt(request.getParameter("id_cars"));
            int id_users = Integer.parseInt(request.getParameter("id_users"));
            Database.connect();

            int affectedRows = Database.jdbi.withExtension(ReservationDao.class,
                    dao -> dao.addReservation(datetime, id_cars, id_users));
            sendMessage("Reserva actualizado correctamente", response);

        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            sendError("Internal Server Error", response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            sendError("Error conectando con la base de datos", response);
        }
    }
}
