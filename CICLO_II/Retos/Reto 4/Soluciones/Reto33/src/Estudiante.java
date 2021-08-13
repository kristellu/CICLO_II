import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Estudiante extends Persona {

    private double nota;
    private String materia;
    private int idMateria;

    public Estudiante(){
        super(0, 0, null);
        this.nota = 0;
        this.materia = null;
        this.idMateria = 0;
    }


    public Estudiante(int id, String nombre, int genero, int idMateria, String materia, double nota){
        super(id, genero, nombre);
        this.nota = nota;
        this.idMateria = idMateria;
        this.materia = materia;
    }

    public int contarSobresalientes(){
       /* int res = 0;

        if(notaHistoria > 80 && notaHistoria <=90){
            res++;
        }

        if(notaIdioma > 80 && notaIdioma <=90){
            res++;
        }

        if(notaLiteratura > 80 && notaLiteratura <=90){
            res++;
        }

        return res;*/

        return 0;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public static void addEstudiante(int id, String nombre, int genero, int idMateria, String materia, double nota){
        //Hacer 3 inserciones SQL, una por cada materia.
        String sql1 = "INSERT INTO Persona (Nombre, idEstudiante, idGenero, Materia, idMateria, nota)" + 
        "VALUES ('" + nombre + "', " + id + ", " + genero + ", '" + materia + 
        "', " + idMateria + ", " + nota + ");";

        System.out.println(sql1);

        Connection conn = Connect.getConnection();
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate(sql1);    
            stat.close();
        }catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }


        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    } 

    public static void edditEstudiante(String idEstudiante, String idMateria, String genero, String nombre, String materia, String nota ){
        String eddit = "UPDATE Persona " + 
                        "SET idGenero = " + genero + ", Nombre = '" + nombre + "', " + 
                        "Materia = '"+ materia + "', nota = " + nota + 
                        " WHERE idEstudiante = " + idEstudiante + " and idMateria =" + idMateria + ";";

        System.out.println(eddit);

        Connection conn = Connect.getConnection();
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate(eddit);    
            stat.close();
        }catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }


        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    } 

    public static void deleteEstudiante(String idEstudiante, String idMateria){
        String eddit = "DELETE from Persona " + 
                        " WHERE idEstudiante = " + idEstudiante + " and idMateria =" + idMateria + ";";

        System.out.println(eddit);

        Connection conn = Connect.getConnection();
        try {
            Statement stat = conn.createStatement();
            stat.executeUpdate(eddit);    
            stat.close();
        }catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }


        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    } 

    public static Estudiante getEstudiante(String idEstudiante, String idMateria){
        String sql = "select * from Persona where idEstudiante = "+ idEstudiante +  " and idMateria=" + idMateria;

        Connection conn = Connect.getConnection();
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("idEstudiante") +  "-" + 
                                   rs.getString("Nombre") +  "-" + 
                                   rs.getString("idGenero") +  "-" + 
                                   rs.getString("Materia") +  "-" + 
                                   rs.getString("idMateria") +  "-" + 
                                   rs.getString("nota")
                                   );
                Estudiante es = new Estudiante(rs.getInt("idEstudiante"), 
                                                rs.getString("Nombre"),
                                                rs.getInt("idGenero"),
                                                rs.getInt("idMateria"),
                                                rs.getString("Materia"),
                                                rs.getDouble("nota"));
                conn.close();
                return es;
            }
            
        }catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

    public static String getEstudiantes(){
        String sql = "select * from Persona;";
        String res = "";

        Connection conn = Connect.getConnection();
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                String actual = rs.getInt("idEstudiante") +  " " + 
                rs.getString("Nombre") +  " " + 
                rs.getString("idGenero") +  " " + 
                rs.getString("Materia") +  " " + 
                rs.getString("idMateria") +  " " + 
                rs.getString("nota") + "\n";
                System.out.println(actual);
                res += actual;
            }        
            conn.close();
            return res;
            
        }catch (SQLException e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }

        try {
            conn.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
}
