package com.bermecar.servlet;

import com.bermecar.dao.CarDao;
import com.bermecar.dao.Database;
import com.bermecar.dao.UserDao;
import com.bermecar.domain.User;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

import static com.bermecar.util.ErrorUtils.sendError;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        int telephone = Integer.parseInt(request.getParameter("telephone"));
        String role = "user";

        try {
            Database.connect();
            Database.jdbi.withExtension(UserDao.class, dao -> dao.addUser(username, password, telephone, role));
            User user = Database.jdbi.withExtension(UserDao.class, dao -> dao.getUser(username, password));
            HttpSession session = request.getSession();
            session.setAttribute("id", user.getId());
            session.setAttribute("username", user.getUsername());
            session.setAttribute("role", user.getRole());
            response.getWriter().print("ok");
        } catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
            sendError("Internal Server Error", response);
        } catch (SQLException sqle) {
            sqle.printStackTrace();
            sendError("Error conectando con la base de datos", response);
        }
    }
}
