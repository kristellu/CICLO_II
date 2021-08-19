import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Medic extends Person{ // Aqui la clase Medic debe heredar de la clase Person
    private String eps;
    private String alert;
    private String treatment;

    public Medic(String name, String id, int age, String city, String eps, String alert, String treatment) {
        super(name, id, age, city);
        this.eps = eps;
        this.alert = alert;
        this.treatment = treatment;
    }

    public String getEps() {
        return this.eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getAlert() {
        return this.alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getTreatment() {
        return this.treatment;
    }

    public static Medic getMedic(String id) {
        Connection conn = Connect.getConnection();
        Medic md = null;

        String query = "SELECT * FROM Medic WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                md = new Medic(rs.getString("name"),
                               rs.getString("id"),
                               rs.getInt("age"),
                               rs.getString("city"),
                               rs.getString("eps"),
                               rs.getString("alert"),
                               rs.getString("treatment"));
            }
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return md;
    }

    public static ArrayList<Medic> getAllMedics() {
        Connection conn = Connect.getConnection();
        ArrayList<Medic> mds = new ArrayList<Medic>();

        String query = "SELECT * FROM Medic";

        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Medic md = new Medic(rs.getString("name"),
                                     rs.getString("id"),
                                     rs.getInt("age"),
                                     rs.getString("city"),
                                     rs.getString("eps"),
                                     rs.getString("alert"),
                                     rs.getString("treatment"));
                mds.add(md);
            }
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return mds;
    }

    public static void deleteMedic(String id) {
        Connection conn = Connect.getConnection();
        String query = "DELETE FROM Medic WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void saveMedic(String name, String id, int age, String city, String eps, String alert, String treatment) {
        Connection conn = Connect.getConnection();
        String query = "INSERT INTO Medic "
                     + "(name, id, age, city, eps, alert, treatment) "
                     + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, id);
            stmt.setInt(3, age);
            stmt.setString(4, city);
            stmt.setString(5, eps);
            stmt.setString(6, alert);
            stmt.setString(7, treatment);

            stmt.executeUpdate();
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void editMedic(String searchID, String name, String id, int age, String city, String eps, String alert, String treatment) {
        Connection conn = Connect.getConnection();
        String query = "UPDATE Medic SET "
                     + "name = ?, "
                     + "id = ?, "
                     + "age = ?, "
                     + "city = ?, "
                     + "eps = ?, "
                     + "alert = ?, "
                     + "treatment = ? "
                     + "WHERE id = ?";
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, id);
            stmt.setInt(3, age);
            stmt.setString(4, city);
            stmt.setString(5, eps);
            stmt.setString(6, alert);
            stmt.setString(7, treatment);
            stmt.setString(8, searchID);

            stmt.executeUpdate();
            conn.close();
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

}
