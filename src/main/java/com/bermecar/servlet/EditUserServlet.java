package com.bermecar.servlet;
import com.bermecar.dao.CarDao;
import com.bermecar.dao.UserDao;
import com.bermecar.dao.Database;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

import static com.bermecar.util.ErrorUtils.sendError;
import static com.bermecar.util.ErrorUtils.sendMessage;

@WebServlet("/edit-user")
@MultipartConfig
public class EditUserServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        int id = 0;
        id = Integer.parseInt(request.getParameter("id"));

        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            int telephone = Integer.parseInt(request.getParameter("telephone"));
            Database.connect();
            final int finalId = id;
            int affectedRows = Database.jdbi.withExtension(UserDao.class,
                    dao -> dao.updateUser(username, password, telephone, finalId));
            sendMessage("Actividad modificada correctamente", response);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            sendError("Internal Server Error", response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            sendError("Error conectando con la base de datos", response);
        }
    }
}
