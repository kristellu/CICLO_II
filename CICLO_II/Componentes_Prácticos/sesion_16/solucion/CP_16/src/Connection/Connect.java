package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {

    public Connection connect() {
        // Ruta donde está al db creada
        String url = "jdbc:sqlite:C:/Users/KRISTE~1/Documents/MINTIC/CICLO-II/CP_16/db/almacenV2.db";

        Connection conn = null;

        try {
            // Creamos la conexión
            conn = DriverManager.getConnection(url);
            // System.out.println("Connection to SQLite has been stablished.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void create(String sql) {
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Elemento creado exitosamente");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
