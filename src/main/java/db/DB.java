package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    public static Connection connect() throws SQLException
    {
        try
        {
            String jdbcUrl = DatabaseConfig.getDbUrl();
            String user = DatabaseConfig.getDbUsername();
            String password = DatabaseConfig.getDbPassword();

            return DriverManager.getConnection(jdbcUrl, user, password);
        }
        catch (SQLException  e)
        {
            System.err.println(e.getMessage());
            return null;
        }
    }
    public static void initTables()
    {
        for (int i = 0; i < DatabaseConfig.tables.size(); i++)
        {

            try {
                Connection conn =  DB.connect();
                Statement stmt = conn.createStatement();
                stmt.executeUpdate(DatabaseConfig.tables.get(i));
                conn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}