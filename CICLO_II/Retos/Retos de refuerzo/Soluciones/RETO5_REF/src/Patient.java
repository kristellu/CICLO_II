import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Patient extends Person{
    private Nodule nodule;
    private String alert;
    private String treatment;

    public Patient(String name, String id, int age, String city, String composition, String echogenicity, String form, String margin, boolean echogenicFoci1, boolean echogenicFoci2, boolean echogenicFoci3, boolean echogenicFoci4, float size) {
        super(name, id, age, city);
        this.nodule = new Nodule(composition, echogenicity, form, margin, echogenicFoci1, echogenicFoci2, echogenicFoci3, echogenicFoci4, size);
        this.alert = nodule.computeAlert();
        this.treatment = nodule.computeTreatment();
    }

    public Nodule getNodule() {
        return this.nodule;
    }

    public String getAlert() {
        return this.alert;
    }

    public String getTreatment() {
        return this.treatment;
    }

    public static Patient getPatient(String id) {
        Connection conn = Connect.getConnection();
        Patient px = null;

        String query = "SELECT * FROM Patient WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id); // Aqui debe enviar como parametro el id

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                px = new Patient(rs.getString("name"),
                                 rs.getString("id"),
                                 rs.getInt("age"),
                                 rs.getString("city"),
                                 rs.getString("composition"),
                                 rs.getString("echogenicity"),
                                 rs.getString("form"),
                                 rs.getString("margin"),
                                 rs.getBoolean("echogenicFoci1"),
                                 rs.getBoolean("echogenicFoci2"),
                                 rs.getBoolean("echogenicFoci3"),
                                 rs.getBoolean("echogenicFoci4"),
                                 rs.getFloat("size"));
            }
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        return px;
    }

    public static ArrayList<Patient> getAllPatients() {
        Connection conn = Connect.getConnection();
        ArrayList<Patient> pxs = new ArrayList<Patient>();

        String query = "SELECT * FROM Patient";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query); // Aqui debe enviar como parametro el query
            while (rs.next()) {
                Patient px = new Patient(rs.getString("name"),
                                         rs.getString("id"),
                                         rs.getInt("age"),
                                         rs.getString("city"),
                                         rs.getString("composition"),
                                         rs.getString("echogenicity"),
                                         rs.getString("form"),
                                         rs.getString("margin"),
                                         rs.getBoolean("echogenicFoci1"),
                                         rs.getBoolean("echogenicFoci2"),
                                         rs.getBoolean("echogenicFoci3"),
                                         rs.getBoolean("echogenicFoci4"),
                                         rs.getFloat("size"));
                pxs.add(px);
            }
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return pxs;
    }

    public static void deletePacient(String id) {
        Connection conn = Connect.getConnection();
        String query = "DELETE FROM Patient WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query); // Aqui debe enviar como parametro el query
            stmt.setString(1, id); // Aqui debe enviar como parametro el id
            stmt.executeUpdate();
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void savePatient(String name, String id, int age, String city, String composition, String echogenicity, String form, String margin, boolean echogenicFoci1, boolean echogenicFoci2, boolean echogenicFoci3, boolean echogenicFoci4, float size) {
        Connection conn = Connect.getConnection();
        String query = "INSERT INTO Patient "
                     + "(name, id, age, city, composition, echogenicity, form, margin, echogenicFoci1, echogenicFoci2, echogenicFoci3, echogenicFoci4, size, alert, treatment) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name); // Aqui debe enviar como parametro el nombre
            stmt.setString(2, id); // Aqui debe enviar como parametro el id
            stmt.setInt(3, age);
            stmt.setString(4, city); // Aqui debe enviar como parametro la ciudad
            stmt.setString(5, composition);
            stmt.setString(6, echogenicity);
            stmt.setString(7, form);
            stmt.setString(8, margin); // Aqui debe enviar como parametro el margen
            stmt.setBoolean(9, echogenicFoci1);
            stmt.setBoolean(10, echogenicFoci2); // Aqui debe enviar como parametro el foco ecogenico 2
            stmt.setBoolean(11, echogenicFoci3); // Aqui debe enviar como parametro el foco ecogenico 3
            stmt.setBoolean(12, echogenicFoci4);
            stmt.setFloat(13, size);
            Patient px = new Patient(name, id, age, city, composition, echogenicity, form, margin, echogenicFoci1, echogenicFoci2, echogenicFoci3, echogenicFoci4, size); // Aqui debe instanciar un paciente
            stmt.setString(14, px.getAlert());
            stmt.setString(15, px.getTreatment()); // Aqui debe obtener el tratamiento del paciente con el metodo getTreatment de la instancia del paciente

            stmt.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void editPatient(String searchID, String name, String id, int age, String city, String composition, String echogenicity, String form, String margin, boolean echogenicFoci1, boolean echogenicFoci2, boolean echogenicFoci3, boolean echogenicFoci4, float size) {
        Connection conn = Connect.getConnection();
        String query = "UPDATE Patient SET "
                     + "name = ?, "
                     + "id = ?, "
                     + "age = ?, "
                     + "city = ?, "
                     + "composition = ?, "
                     + "echogenicity = ?, "
                     + "form = ?, "
                     + "margin = ?, "
                     + "echogenicFoci1 = ?, "
                     + "echogenicFoci2 = ?, "
                     + "echogenicFoci3 = ?, "
                     + "echogenicFoci4 = ?, "
                     + "size = ?, "
                     + "alert = ?, "
                     + "treatment = ? "
                     + "WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name); // Aqui debe enviar como parametro el nombre
            stmt.setString(2, id); // Aqui debe enviar como parametro el id
            stmt.setInt(3, age); // Aqui debe enviar como parametro la edad
            stmt.setString(4, city); // Aqui debe enviar como parametro la ciudad
            stmt.setString(5, composition); // Aqui debe enviar como parametro la composicion
            stmt.setString(6, echogenicity); // Aqui debe enviar como parametro la ecogenicidad
            stmt.setString(7, form); // Aqui debe enviar como parametro la forma
            stmt.setString(8, margin); // Aqui debe enviar como parametro el margen
            stmt.setBoolean(9, echogenicFoci1); // Aqui debe enviar como parametro el foco ecogenico 1
            stmt.setBoolean(10, echogenicFoci2); // Aqui debe enviar como parametro el foco ecogenico 2
            stmt.setBoolean(11, echogenicFoci3); // Aqui debe enviar como parametro el foco ecogenico 3
            stmt.setBoolean(12, echogenicFoci4); // Aqui debe enviar como parametro el foco ecogenico 4
            stmt.setFloat(13, size); // Aqui debe enviar como parametro el tamaño
            Patient px = new Patient(name, id, age, city, composition, echogenicity, form, margin, echogenicFoci1, echogenicFoci2, echogenicFoci3, echogenicFoci4, size); // Aqui debe instanciar un paciente
            stmt.setString(14, px.getAlert()); // Aqui debe enviar como parametro la alerta del paciente con el metodo getAlert de la intancia
            stmt.setString(15, px.getTreatment()); // Aqui debe enviar como parametro el tratamiento del paciente con el metodo getTreatment de la instancia
            stmt.setString(16, searchID);

            stmt.executeUpdate();
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
