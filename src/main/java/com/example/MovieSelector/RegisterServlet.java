package com.example.MovieSelector;

import javax.servlet.*;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet(name="RegisterServlet", value="/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    private static final long serialVersionUID = 3L;
    private String firstname;
    private String surname;
    private String email;
    private String password;


    //TODO fix problem with Servlet not registering
    //TODO check that this actually can connect to DB
//    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
//        res.setContentType("text/html");
//        PrintWriter out = res.getWriter();
//
//        firstname = req.getParameter("firstname");
//        surname = req.getParameter("surname");
//        email = req.getParameter("email");
//        password = req.getParameter("password");
//
//        try {
//            registerUser(firstname, surname, email, password);
//        } catch (SQLException | ServletException e) {
//            System.out.println("Error Registering User");
//            e.printStackTrace();
//        }
//        out.println("Register successful");
//        res.sendRedirect(req.getContextPath() + "/login.jsp");
//    }

//    public void registerUser(String firstname, String surname, String email, String password) throws SQLException, IOException, ServletException {
//        Statement stmt = JDBCServlet.open();
//        String newUser = "INSERT INTO movieSelector.Users (firstname, surname, email, password)"
//                + "VALUES ( '"+firstname+"' , '"+surname+"' , '"+email+"' , '"+password+"' )";
//        ResultSet rs = stmt.executeQuery(newUser);
//        rs.next();
//        System.out.println(rs);
//        JDBCServlet.close();
//
//    }

}
