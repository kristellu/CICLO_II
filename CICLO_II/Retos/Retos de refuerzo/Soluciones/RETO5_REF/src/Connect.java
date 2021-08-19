import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    public static Connection getConnection(){
        Connection conn = null;
        try {
            String url = "D:/jhonj/Documentos/Maestria/Proyecto MINTIC/Ciclo 2/RETOS SEMANALES (VIEJOS)/EDU1076_82/RETO5_REF/src/db/database.db"; // Aqui debe indicar la ruta absoluta hasta el archivo 'database.db'
            conn = DriverManager.getConnection("jdbc:sqlite:" + url);
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos/n" + ex.getMessage());
        }
        return conn;
    }
}
