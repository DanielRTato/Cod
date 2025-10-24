package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:postgresql://10.0.9.100:5432/probas";
    private static final String USER = "postgres";
    private static final String PASSWORD = "admin";

    public static Connection conexion() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            return conn;

        } catch (SQLException e) {
            System.out.println("Error en la conexion a la base de datos: " + e.getMessage());
            return null;
        }
    }

}
