package com.example.MovieSelector;

import javax.management.Query;
import java.sql.*;

public class QuerySQL {
    //TODO create ways to query DB other than select all
    private static final String query_all_users = "SELECT * FROM Users WHERE email=?";

    public static final ResultSet queryUsersLogin(Connection con, PreparedStatement stmt, String email) throws SQLException{
        stmt = con.prepareStatement(query_all_users);
        stmt.setString(1, email);
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public static final ResultSet query_select_users(Statement stmt) throws SQLException{
        String query = "SELECT ? FROM Users";

        return null;
    }
}
