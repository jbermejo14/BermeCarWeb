package com.bermecar.servlet;
import com.bermecar.dao.CarDao;
import com.bermecar.dao.Database;
import com.bermecar.util.CurrencyUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.UUID;

import static com.bermecar.util.ErrorUtils.sendError;
import static com.bermecar.util.ErrorUtils.sendMessage;

@WebServlet("/edit-car")
@MultipartConfig
public class EditCarServlet extends HttpServlet {

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
            int id = 0;
            if (request.getParameter("id") != null) {
                id = Integer.parseInt(request.getParameter("id"));
            }

            String license_plate = request.getParameter("license_plate");
            String brand = request.getParameter("brand");
            String model = request.getParameter("model");
            String country = request.getParameter("country");
            int year = Integer.parseInt(request.getParameter("year"));
            float price = CurrencyUtils.parse(request.getParameter("price"));

            String finalFilename2 = "test.jpg";
            Database.connect();

            if (id == 0) {
                int affectedRows = Database.jdbi.withExtension(CarDao.class,
                        dao -> dao.addCar(license_plate, brand, model, country, year, price, finalFilename2));
                sendMessage("Actividad registrada correctamente", response);
            } else {
                final int finalId = id;
                int affectedRows = Database.jdbi.withExtension(CarDao.class,
                        dao -> dao.updateCar(license_plate, brand, model, country, year, price, finalFilename2, finalId));
                sendMessage("Actividad modificada correctamente", response);
            }
        } catch (ParseException pe) {
            pe.printStackTrace();
            sendError("El formato de fecha o precio no es correcto", response);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            sendError("Internal Server Error", response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            sendError("Error conectando con la base de datos", response);
        }
    }
}