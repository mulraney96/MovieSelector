package com.example.MovieSelector;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.*;
import java.sql.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 2L;
    private String email;
    private String password;

    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        email = req.getParameter("email");
        password = req.getParameter("password");

        User user = null;
        try {
            user = validateUser(email, password);
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("An error at the validate user method at Login Servlet.....\n" +
                    "Closing DB Connection....\n");
            e.printStackTrace();
        }


        if (user != null) {
            // login succeeded
            HttpSession session = req.getSession();
            session.setAttribute("theUser", user);  // put the OBJECT on the session
            res.sendRedirect("home.jsp");
        } else {
            // login failed
            // no failure message for now but it will
            // send the user back to try again
            res.sendRedirect("login.html");
        }
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        PrintWriter out = res.getWriter();
        out.println("<HEAD><HEAD/><BODY>You made it<BODY/>");
    }

    /*
     * This method will dummy the login process and return null if unsuccessful or a User object if successful
     */
    private static User validateUser(String email, String password) throws SQLException, ClassNotFoundException, ServletException, IOException {
        Connection con = DatabaseConnection.initializeDatabase();
        PreparedStatement stmt = null;
        ResultSet rs = QuerySQL.queryUsersLogin(con, stmt, email);
        User user = null;
        while (rs.next()) {
            String db_password = rs.getString("password");
            System.out.println("\nIn Validate User: Name=" + email + ", " + db_password);
            if (db_password.contentEquals(password)) {
                user = new User(Integer.parseInt(rs.getString("id")), rs.getString("surname"), rs.getString("firstname"),
                        rs.getString("password"), rs.getString("email"));
                System.out.println("User Created");
                DatabaseConnection.closeDatabase(con, stmt, rs);
                return user;
            }
        }
        DatabaseConnection.closeDatabase(con, stmt, rs);
        return null;
    }
}
