package jm.task.core.jdbc.util;
//import com.mysql.cj.xdevapi.SessionFactory;
import org.hibernate.cfg.Environment;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.*;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;*/
import jm.task.core.jdbc.model.User;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class Util {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
                settings.put(Environment.URL, "jdbc:mysql://localhost:3306/mysql");
                settings.put(Environment.USER, "ali");
                settings.put(Environment.PASS, "root");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
                settings.put(Environment.HBM2DDL_AUTO, "");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();

                sessionFactory = (SessionFactory) configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                System.out.println("Пал бу, нет подключения");
            }
        }
        return sessionFactory;
    }


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
