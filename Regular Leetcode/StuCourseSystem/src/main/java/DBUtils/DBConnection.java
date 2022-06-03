package DBUtils;

import java.sql.*;

public final class DBConnection {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/student_course",
            USERNAME = "root",
            PASSWORD = "root";
    private static Connection connection = null;

    private DBConnection(){
        throw new RuntimeException("Do not instantiate DBConnection");
    }

    public static void init() throws SQLException{
        if (connection == null)
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }

    public static void execUpdate(String update) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeUpdate(update);
    }

    public static ResultSet execQuery(String query) throws SQLException {
        Statement stmt = connection.createStatement();
        stmt.executeQuery(query);
        return stmt.getResultSet();
    }

    public static void disconnect() throws SQLException{
        connection.close();
    }
}
