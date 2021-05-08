package com.example.MovieSelector;

import java.sql.*;


public class DatabaseConnection {

    private static String JDBCUrl = "jdbc:mysql://movieselectordb.cz2kjwyb2lus.eu-west-1.rds.amazonaws.com:3306/movieSelector";
    //private static String JDBCUrl = "jdbc:mysql://movieselectordb.cz2kjwyb2lus.eu-west-1.rds.amazonaws.com:3306:tempSchema";
    private static String username = "admin";
    private static String password = "13579Bluecar!";

    private static String driverName = "com.mysql.cj.jdbc.Driver";

    protected static Connection initializeDatabase()
            throws SQLException, ClassNotFoundException {
        Class.forName(driverName);
        Connection con = DriverManager.getConnection(JDBCUrl, username, password);
        return con;
    }

    protected static void closeDatabase(Connection con) throws SQLException, ClassNotFoundException {
        try {
            if (con != null) con.close();
            System.out.println("\n.........Closing Connection to SSD DataBase");
        }
        catch (Exception ex) {
            System.out.println("An error occurred while closing down connection/statement");
        }
    }

    protected static void closeDatabase(Connection con, PreparedStatement stmt, ResultSet rs){
        try{
            if(rs != null) rs.close();
            if(stmt != null) stmt.close();
            if(con != null) con.close();
        }
        catch (Exception ex){
            System.out.println("An error occurred while closing down connection/statement");
            ex.printStackTrace();
        }
    }

}
