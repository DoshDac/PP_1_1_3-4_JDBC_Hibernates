package jm.task.core.jdbc.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Util {

    private static Connection connection;
    public static Connection getConnection() {

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "ali", "root");
        } catch (SQLException e) {
            System.out.println("Пал бу, нет подключения");
        }
        return connection;
    }
}
