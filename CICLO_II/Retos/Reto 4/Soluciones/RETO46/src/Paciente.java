import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Paciente extends Persona{
    private String eps;
    private String enfermedad;

    public Paciente(String nombre, String cedula, int edad, String ciudad, String eps, String enfermedad) {
        super(nombre, cedula, edad, ciudad);
        this.eps = eps;
        this.enfermedad = enfermedad;
    }

    public String getEps() {
        return eps;
    }

    public String getEnfermedad() {
        return enfermedad;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public void setEnfermedad(String enfermedad) {
        this.enfermedad = enfermedad;
    }

    public String clasificarEdad(){
        String res = "";
        if (this.getEdad() >= 21 && this.getEdad() <= 30) {
            res = "Joven adulto";
        } else if (this.getEdad() > 30 && this.getEdad() <= 60) {
            res =  "Adulto";
        } else if (this.getEdad() > 60) {
            res = "Tercera edad";
        }
        return res;
    }

    public static Paciente getPaciente(String cc) {
        Connection conn = Connect.getConnection();
        String query = "SELECT * FROM Persona WHERE cedula = '" + cc + "';";
        Paciente px = null;
        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                px = new Paciente(result.getString("nombre"), result.getString("cedula"), Integer.parseInt(result.getString("edad")), result.getString("ciudad"),
                                           result.getString("eps"), result.getString("enfermedad"));
            }
            conn.close();
        }
        catch(SQLException e){
            System.err.println(e);
        }

        return px;
    }

    public static Paciente[] getAllPacientes() {
        Connection conn = Connect.getConnection();

        Paciente[] pxs = null;
        int cont = 0;

        String queryCant = "SELECT Count(*) As Contador FROM Persona;";
        String query = "SELECT * FROM Persona;";
        try {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(queryCant);
            while(resultSet.next()) {
                cont = resultSet.getInt("Contador");
            }

            pxs = new Paciente[cont];

            stmt.executeQuery(query);
            int i = 0;
            while(resultSet.next()) {
                Paciente px = new Paciente(resultSet.getString("nombre"), resultSet.getString("cedula"), Integer.parseInt(resultSet.getString("edad")), resultSet.getString("ciudad"),
                                                resultSet.getString("eps"), resultSet.getString("enfermedad"));
                pxs[i] = px;
                i += 1;
            }
            conn.close();
        }
        catch(SQLException e) {
            System.err.println(e);
        }
        return pxs;
    }

    public static void deletePaciente(String cc){
        Connection conn = Connect.getConnection();
        String query = "DELETE FROM Persona WHERE cedula = '" + cc + "';";
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        }
        catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void savePaciente(String nombre, String cc, String edad, String ciudad, String eps, String enfermedad) {
        Connection conn = Connect.getConnection();
        String query = "INSERT INTO Persona (nombre, cedula, edad, ciudad, eps, enfermedad) VALUES ('" + nombre + "', '" + cc + "', '" + edad + "', '" +
                        ciudad + "', '" + eps + "', '" + enfermedad + "');";
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        }
        catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void editPaciente(String searchCC, String nombre, String cc, String edad, String ciudad, String eps, String enfermedad) {
        Connection conn = Connect.getConnection();
        String query = "UPDATE Persona SET nombre = '" + nombre +"', " +
                        "cedula = '" + cc + "', " +
                        "edad = '" + edad + "', "  +
                        "ciudad = '" + ciudad + "', "  +
                        "eps = '" + eps + "', " +
                        "enfermedad = '" + enfermedad + "' " +
                        "WHERE cedula = '" + searchCC + "';";
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
