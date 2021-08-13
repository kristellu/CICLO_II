import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Paciente extends Persona {
    private String nauseas;
    private String vomitos;
    private String dolor;
    private String diarrea;
    private String fiebre;
    private String diagnostico;

    public Paciente(String nombre, String cedula, String nauseas, String vomitos, String dolor, String diarrea, String fiebre) {
        super(nombre, cedula);
        this.nauseas = nauseas;
        this.vomitos = vomitos;
        this.dolor = dolor;
        this.diarrea = diarrea;
        this.fiebre = fiebre;
    }

    public String getDiarrea() {
        return diarrea;
    }public String getDolor() {
        return dolor;
    }
    public String getFiebre() {
        return fiebre;
    }
    public String getNauseas() {
        return nauseas;
    }
    public String getVomitos() {
        return vomitos;
    }
    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiarrea(String diarrea) {
        this.diarrea = diarrea;
    }
    public void setDolor(String dolor) {
        this.dolor = dolor;
    }
    public void setFiebre(String fiebre) {
        this.fiebre = fiebre;
    }
    public void setNauseas(String nauseas) {
        this.nauseas = nauseas;
    }
    public void setVomitos(String vomitos) {
        this.vomitos = vomitos;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
    public String diagnosticar(){
        String enf="Sin diagnostico";

        //Staphylococcus aureus
        if (nauseas.equalsIgnoreCase("si") && vomitos.equalsIgnoreCase("si") && dolor.equalsIgnoreCase("si")
        && diarrea.equalsIgnoreCase("si") && fiebre.equalsIgnoreCase("si")) {
            enf = "Staphylococcus aureus";
        }
        //Bacillus cereus
        if (nauseas.equalsIgnoreCase("si") && vomitos.equalsIgnoreCase("si")) {
            if (dolor.equalsIgnoreCase("no") && diarrea.equalsIgnoreCase("no") && fiebre.equalsIgnoreCase("no")){
                enf = "Bacillus cereus";
            }
        }

        //Taenia saginata
        if (dolor.equalsIgnoreCase("si") && fiebre.equalsIgnoreCase("si")) {
            if (nauseas.equalsIgnoreCase("no") && vomitos.equalsIgnoreCase("no") && diarrea.equalsIgnoreCase("no")) {
                enf = "Taenia saginata";
            }

        }

        //Norovirus 2 3 6 9
        if (nauseas.equalsIgnoreCase("si") && vomitos.equalsIgnoreCase("si") && diarrea.equalsIgnoreCase("si") &&
        fiebre.equalsIgnoreCase("si")) {
            if (dolor.equalsIgnoreCase("no")) {
                enf = "Norovirus";
            }
        }

        //Rotavirus 3 9 6
        if (vomitos.equalsIgnoreCase("si") && diarrea.equalsIgnoreCase("si")) {
            if (nauseas.equalsIgnoreCase("no") && dolor.equalsIgnoreCase("no") && fiebre.equalsIgnoreCase("no")) {
                enf = "Rotavirus";
                //enf = "Viral";
            }

        }
        return enf;
    }

    public static Paciente getPaciente(String cc) {
        Connection conn = Connect.getConnection();
        String query = "SELECT * FROM Persona WHERE cedula = '" + cc + "';";
        Paciente px = null;
        try{
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                px = new Paciente(result.getString("nombre"), result.getString("cedula"), result.getString("nauseas"), result.getString("vomitos"),
                                           result.getString("dolorAb"), result.getString("diarrea"), result.getString("fiebre"));
                px.setDiagnostico(result.getString("diagnostico"));
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
                Paciente px = new Paciente(resultSet.getString("nombre"), resultSet.getString("cedula"), resultSet.getString("nauseas"), resultSet.getString("vomitos"),
                                  resultSet.getString("dolorAb"), resultSet.getString("diarrea"), resultSet.getString("fiebre"));
                px.setDiagnostico(resultSet.getString("diagnostico"));
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

    public static void savePaciente(String nombre, String cc, String nauseas, String vomitos, String dolorAbs, String diarrea, String fiebre, String diagnostico) {
        Connection conn = Connect.getConnection();
        String query = "INSERT INTO Persona (nombre, cedula, nauseas, vomitos, dolorAb, diarrea, fiebre, diagnostico) VALUES ('" + nombre + "', '" + cc + "', '" + nauseas + "', '" +
                        vomitos + "', '" + dolorAbs + "', '" + diarrea + "', '" + fiebre + "', '" + diagnostico + "');";
        try{
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(query);
            conn.close();
        }
        catch(SQLException e){
            System.err.println(e);
        }
    }

    public static void editPaciente(String searchCC, String nombre, String cc, String nauseas, String vomitos, String dolorAbs, String diarrea, String fiebre, String diagnostico) {
        Connection conn = Connect.getConnection();
        String query = "UPDATE Persona SET nombre = '" + nombre +"', " +
                        "cedula = '" + cc + "', " +
                        "nauseas = '" + nauseas + "', "  +
                        "vomitos = '" + vomitos + "', "  +
                        "dolorAb = '" + dolorAbs + "', " +
                        "diarrea = '" + diarrea + "', " +
                        "fiebre  = '" + fiebre + "', " +
                        "diagnostico = '" + diagnostico + "' " +
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
