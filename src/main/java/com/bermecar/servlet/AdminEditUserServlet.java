package com.bermecar.servlet;
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

@WebServlet("/admin-edit-user")
@MultipartConfig
public class AdminEditUserServlet extends HttpServlet {

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
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            int telephone = Integer.parseInt(request.getParameter("telephone"));
            Database.connect();
            int affectedRows = Database.jdbi.withExtension(UserDao.class,
                    dao -> dao.updateUser(username, password, email, telephone, id));
            sendMessage("Usuario modificado correctamente" + id, response);
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            sendError("Internal Server Error" + id, response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            sendError("Error conectando con la base de datos" + id, response);
        }
    }
}
