package Connection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {

    private Connection connect() {
        // Ruta donde está al db creada
        String url = "jdbc:sqlite:C:/**RUTA DB";
        // EJEMPLO: String url =
        // "jdbc:sqlite:C:/Users/KRISTE~1/Documents/MINTIC/CICLO-II/CP_15/db/almacen.db";

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

    public void insert(String sql) {
        connect();
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println(e.getMessage());
        }
    }

    public ResultSet select(String sql) {
        connect();
        try (Connection conn = this.connect(); Statement stmt = conn.createStatement()) {
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("ERROR");
            System.out.println(e.getMessage());
        }
        return null;
    }
}
