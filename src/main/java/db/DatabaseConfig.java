package db;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

public class DatabaseConfig {
    private static final Properties properties = new Properties();

    static List<String> tables = new ArrayList<>();

    static
    {
        String [] resources  = new File("src/main/resources").list();
        for (int i = 0; i  < resources.length; i++)
        {
            String resourceName = resources[i];
            try (InputStream input = DatabaseConfig.class.getClassLoader().getResourceAsStream(resourceName))
            {
                if (resourceName.equals("db.properties"))
                {
                    if (input == null) {
                        System.out.println("Sorry, unable to find db.properties");
                        System.exit(1);
                    }

                    properties.load(input);
                    continue;
                }

                String table = new BufferedReader(new InputStreamReader(input))
                        .lines().collect(Collectors.joining("\n"));

                tables.add(table);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static String getDbUrl()
    {
        return properties.getProperty("db.url");
    }

    public static String getDbUsername()
    {
        return properties.getProperty("db.username");
    }

    public static String getDbPassword()
    {
        return properties.getProperty("db.password");
    }
}