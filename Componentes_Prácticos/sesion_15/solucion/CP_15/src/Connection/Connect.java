package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    public Connection connect() {
        // Ruta donde está al db creada
        String url = "jdbc:sqlite:C:/**RUTA DB";
        // EJEMPLO: String url =
        // "jdbc:sqlite:C:/Users/KRISTE~1/Documents/MINTIC/CICLO-II/CP_15/CP_15/db/almacen.db";

        Connection conn = null;

        try {
            // Creamos la conexión
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been stablished.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
