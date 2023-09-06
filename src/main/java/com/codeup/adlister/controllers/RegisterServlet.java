package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.dao.Users;
import com.codeup.adlister.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean invalid = Boolean.parseBoolean(request.getParameter("invalid"));
        request.setAttribute("invalid", invalid);
        // TODO: show the registration form
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        // TODO: ensure the submitted information is valid
        boolean invalidInputs =
                username.isEmpty() ||
                email.isEmpty() ||
                password.isEmpty() ||
                !password.equals(confirmPassword)
         ;

        if(invalidInputs){
            response.sendRedirect("/register?invalid=true");
            return;
        }

        // TODO: create a new user based off of the submitted information

        User newUser = new User(username, email, password);

        // TODO: if a user was successfully created, send them to the login page

        Users usersDao = DaoFactory.getUsersDao();
//        usersDao.insert("/login");


    }
}
