import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {

    private Connection conn;

    public static Connection getConnection(){
        Connection conn = null;
        try {
            String url = "C:/Users/Asus/Documents/VSCode/Reto4_Sol/Reto37/bd/miBasesita.db"; 
            conn = DriverManager.getConnection("jdbc:sqlite:"+url);
            if (conn!=null) {
                System.out.println("Conectado");
            }
        }catch (SQLException ex) {
            System.err.println("No se ha podido conectar a la base de datos\n"+ex.getMessage());
        }
        
        return conn;
    }

    public void close(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.err.println("No se ha cerrar/n"+ex.getMessage());
        }

    }
    
}
