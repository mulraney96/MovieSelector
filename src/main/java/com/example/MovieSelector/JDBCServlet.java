package com.example.MovieSelector;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.sql.*;
//import oracle.jdbc.driver.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet(name="JDBCServlet", value="/JDBCServlet")
public class JDBCServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static Connection con = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static Connection open() throws ServletException, IOException{
        try {
            con = DatabaseConnection.initializeDatabase();
        }
        catch (Exception e) {
            System.out.println("\nAn error has occurred during the connection phase!  "
                    + "This is most likely due to your CLASSPATH being set wrong and the"
                    + " Oracle classes unable to be found.  Otherwise the database itself may be down.  "
                    + "Try telneting to port 1521 and see if it is up!");
            e.printStackTrace();
            System.exit(0);
            return null;
        }

        return con;
    }


    public static void close() {
        try {
            if (con != null) DatabaseConnection.closeDatabase(con);
            System.out.println("\n.........Closing Connection to SSD DataBase");
        }
        catch (Exception ex) {
            System.out.println("An error occurred while closing down connection/statement");
            System.out.println(ex);
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<HTML><HEAD><TITLE>Database Servlet</TITLE></HEAD>");
        out.println("<BODY><H1>Database Values</H1>");

        // Now we add our database code!
        try {
            con = DatabaseConnection.initializeDatabase();
        }
        catch (Exception e) {
            out.println("An error has occurred during the connection phase! Did you upload your Oracle Drivers?");
        }

        try {
            out.println("Connection Successful..... creating statement....");
            stmt = con.createStatement();
            rs = stmt.executeQuery("SELECT * FROM Users");

            while (rs.next())
                out.println("<BR>Name=" + rs.getString("FIRSTNAME") + " " + rs.getString("SURNAME"));
        }
        catch (Exception e) {
            out.println("<BR>An error has occurred during the Statement/ResultSet phase.  Please check the syntax and study the Exception details!");
        }

        finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) DatabaseConnection.closeDatabase(con);
            }
            catch (Exception ex) {
                out.println("<BR>An error occurred while closing down connection/statement");
            }
        }

        out.println("</BODY></HTML>");
        out.close();
    }


    }



