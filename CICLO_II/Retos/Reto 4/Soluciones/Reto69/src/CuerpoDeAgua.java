import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CuerpoDeAgua extends ObjetoGeografico{

    private String tipoDeCuerpoDeAgua;
    private String tipoDeAgua;
    private double irca;

    public CuerpoDeAgua(String nombre, double id, String municipio, String tipoDeCuerpoDeAgua, String tipoDeAgua, double irca) {
        super(nombre, id, municipio);
        this.tipoDeCuerpoDeAgua = tipoDeCuerpoDeAgua;
        this.tipoDeAgua = tipoDeAgua;
        this.irca = irca;
    }

    public String getTipoDeCuerpoDeAgua() {
        return this.tipoDeCuerpoDeAgua;
    }

    public String getTipoDeAgua () {
        return this.tipoDeAgua;
    }

    public double getIrca() {
        return irca;
    }

    public void setIrca(double irca) {
        this.irca = irca;
    }

    public String nivel() {
        String nivel_riesgo = "";
        if (irca >= 0 && irca <= 5) {
            nivel_riesgo = "SIN RIESGO";
        }
        if (irca > 5 && irca <= 14) {
            nivel_riesgo = "BAJO";
        }
        if (irca > 14 && irca <= 35) {
            nivel_riesgo = "MEDIO";
        }
        if (irca > 35 && irca <= 80) {
            nivel_riesgo = "ALTO";
        }
        if (irca > 80 && irca <= 100) {
            nivel_riesgo = "INVIABLE SANITARIAMENTE";
        }
        return nivel_riesgo;
    }

    public static CuerpoDeAgua getCuerpoDeAgua(String id) {
        Connection conn = Connect.getConnection();
        String query = "SELECT * FROM CuerpoAgua WHERE id = '" + id + "';";
        CuerpoDeAgua cda = null;
        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                cda = new CuerpoDeAgua(result.getString("nombre"), Double.parseDouble(result.getString("id")), result.getString("municipio"), result.getString("tipoCuerpo"),
                                           result.getString("tipoAgua"), Double.parseDouble(result.getString("irca")));
            }
            conn.close();
        }
        catch(SQLException e){
            System.err.println(e);
        }

        return cda;
    }

    public static CuerpoDeAgua[] getAllCuerposDeAgua() {
        Connection conn = Connect.getConnection();

        CuerpoDeAgua[] cdas = null;
        int cont = 0;

        String queryCant = "SELECT Count(*) As Contador FROM CuerpoAgua";
        String query = "SELECT * FROM CuerpoAgua;";
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(queryCant);
            while(resultSet.next()) {
                cont = resultSet.getInt("Contador");
            }

            cdas = new CuerpoDeAgua[cont];

            stmt.executeQuery(query);
            int i = 0;
            while(resultSet.next()) {
                CuerpoDeAgua cda = new CuerpoDeAgua(resultSet.getString("nombre"), Double.parseDouble(resultSet.getString("id")), resultSet.getString("municipio"), resultSet.getString("tipoCuerpo"),
                                                    resultSet.getString("tipoAgua"), Double.parseDouble(resultSet.getString("irca")));
                cdas[i] = cda;
                i += 1;
            }
            conn.close();
        }
        catch(SQLException e) {
            System.err.println(e);
        }
        return cdas;
    }

    public static void deleteCuerpoDeAgua(String id){
        Connection conn = Connect.getConnection();
        String query = "DELETE FROM CuerpoAgua WHERE id = '" + id + "';";
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        }
        catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void saveCuerpoDeAgua(String nombre, String id, String municipio, String tipoCuerpo, String tipoAgua, String irca) {
        Connection conn = Connect.getConnection();
        String query = "INSERT INTO CuerpoAgua (nombre, id, municipio, tipoCuerpo, tipoAgua, irca) VALUES ('" + nombre + "', '" + id + "', '" + municipio + "', '" +
                        tipoCuerpo + "', '" + tipoAgua + "', '" + irca + "');";
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        }
        catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void editCuerpoDeAgua(String searchID, String nombre, String id, String municipio, String tipoCuerpo, String tipoAgua, String irca) {
        Connection conn = Connect.getConnection();
        String query = "UPDATE CuerpoAgua SET nombre = '" + nombre +"', " +
                        "id = '" + id + "', " +
                        "municipio = '" + municipio + "', "  +
                        "tipoCuerpo = '" + tipoCuerpo + "', "  +
                        "tipoAgua = '" + tipoAgua + "', " +
                        "irca = '" + irca + "' " +
                        "WHERE id = '" + searchID + "';";
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        }
        catch(SQLException e){
            System.err.println(e);
        }
    }

}
