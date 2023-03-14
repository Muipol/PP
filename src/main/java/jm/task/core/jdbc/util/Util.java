package jm.task.core.jdbc.util;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private final static String URL = "jdbc:mysql://localhost:3306/mydb";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    public static Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            System.out.println("Не удалось загрузить класс драйвера");
        }
        try {
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            //System.out.println("Подключене к БД успешно");
            return connection;
        } catch (SQLException e) {
            System.out.println("Не удалось подключиться к БД");
        }
        return null;
    }
}

