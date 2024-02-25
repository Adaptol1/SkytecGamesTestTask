package db.tables;

import db.DB;
import db.DatabaseConfig;

import java.io.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.stream.Collectors;

public abstract class AbstractTable
{
    public String name;

    public void create()
    {
        try
        {
            InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream(name + ".sql");
            String sql = new BufferedReader(new InputStreamReader(input))
                    .lines().collect(Collectors.joining("\n"));

            Connection conn =  DB.connect();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void drop()
    {
        try
        {
            String sql = "DROP TABLE " + name;
            Connection conn =  DB.connect();
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
            conn.close();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
}