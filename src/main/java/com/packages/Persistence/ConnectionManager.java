package com.packages.Persistence;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import java.sql.DriverManager;
import java.sql.SQLException;


//jdbc:postgresql://hostname:port/databaseName
//postgres://YourUserName:YourPassword@YourHostname:5432/YourDatabaseName
// jdbc:postgresql://host:port/dbname?user=postgres&password=postgres

public class ConnectionManager {
    private static ConnectionManager connectionManager;
    private static Connection connection;

    private ConnectionManager() {
//for singleton so doesn't make default constructor
    }

    public static Connection getConnection() {
        if (connection == null) {
            connect();
        } else {
            return connection;
        }
        return null;
    }
        private static Connection connect() {


            try {
                Properties props = new Properties();
                ClassLoader loader = Thread.currentThread().getContextClassLoader();
                InputStream inputStream = loader.getResourceAsStream("jdbc.properties");

                props.load(inputStream);

                Class.forName(props.getProperty("driver"));

                StringBuilder builder = new StringBuilder();
                builder.append("jdbc:postgresql://");
                builder.append(props.getProperty("host"));
                builder.append(":");
                builder.append(props.getProperty("port"));
                builder.append("/");
                builder.append(props.getProperty("dbname"));
                builder.append("?user=");
                builder.append(props.getProperty("username"));
                builder.append("&password=");
                builder.append(props.getProperty("password"));


                connection = DriverManager.getConnection(builder.toString());



            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return connection;
        }
}
