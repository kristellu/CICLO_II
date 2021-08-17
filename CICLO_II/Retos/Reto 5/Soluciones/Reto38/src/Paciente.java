import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Paciente extends Persona{
    private double muestra1;
    private double muestra2;
    private double muestra3;

    public Paciente(String nombre, String cedula, String genero, double muestra1, double muestra2, double muestra3) {
        super(nombre, cedula, genero);
        this.muestra1 = muestra1;
        this.muestra2 = muestra2;
        this.muestra3 = muestra3;
    }

    public double getMuestra1() {
        return muestra1;
    }
    public double getMuestra2() {
        return muestra2;
    }
    public double getMuestra3() {
        return muestra3;
    }
    public void setMuestra1(double muestra1) {
        this.muestra1 = muestra1;
    }
    public void setMuestra2(double muestra2) {
        this.muestra2 = muestra2;
    }
    public void setMuestra3(double muestra3) {
        this.muestra3 = muestra3;
    }
    
    public int getPuntaje(){
        int ptpp=0;

        if (this.getGenero().equals("M")) {
            //Masculino
            if (muestra1 < 0.74 || muestra1 > 1.35) {
                ptpp += 5;
            }
        } else {
            //Femenino
            if (muestra1 < 0.59 || muestra1 > 1.04) {
                ptpp += 5;
            }
        }

        if (this.getGenero().equals("M")) {
            //Masculino
            if (muestra2 < 0.74 || muestra2 > 1.35) {
                ptpp += 5;
            }
        } else {
            //Femenino
            if (muestra2 < 0.59 || muestra2 > 1.04) {
                ptpp += 5;
            }
        }

        if (this.getGenero().equals("M")) {
            //Masculino
            if (muestra3 < 0.74 || muestra3 > 1.35) {
                ptpp += 5;
            }
        } else {
            //Femenino
            if (muestra3 < 0.59 || muestra3 > 1.04) {
                ptpp += 5;
            }
        }

        return ptpp;

    }

    public static int getPuntaje(double m1, double m2, double m3, String genero){
        int ptpp=0;

        if (genero.equals("M")) {
            //Masculino
            if (m1 < 0.74 || m1 > 1.35) {
                ptpp += 5;
            }
        } else {
            //Femenino
            if (m1 < 0.59 || m1 > 1.04) {
                ptpp += 5;
            }
        }

        if (genero.equals("M")) {
            //Masculino
            if (m2 < 0.74 || m2 > 1.35) {
                ptpp += 5;
            }
        } else {
            //Femenino
            if (m2 < 0.59 || m2 > 1.04) {
                ptpp += 5;
            }
        }

        if (genero.equals("M")) {
            //Masculino
            if (m3 < 0.74 || m3 > 1.35) {
                ptpp += 5;
            }
        } else {
            //Femenino
            if (m3 < 0.59 || m3 > 1.04) {
                ptpp += 5;
            }
        }

        return ptpp;

    }
    
    public static void addPaciente(String nombre, String cedula, String genero, String muestra1, String muestra2, String muestra3){
        
        Double m1 =  Double.parseDouble(muestra1);
        Double m2 =  Double.parseDouble(muestra2);
        Double m3 =  Double.parseDouble(muestra3);

        int p = getPuntaje(m1, m2, m3, genero);

        String sql1 = "INSERT INTO Persona (Nombre, Cedula, Genero, Muestra1, Muestra2, Muestra3, Puntaje)" + 
        "VALUES ('" + nombre + "', '" + cedula + "', '" + genero + "', '" + muestra1 + 
        "', '" + muestra2 + "', '" + muestra3 + "', '" + p + "');";

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

    public static void edditPaciente(String cedula, String nombre, String genero, String m1, String m2, String m3 ){
        
        Double m11 =  Double.parseDouble(m1);
        Double m21 =  Double.parseDouble(m2);
        Double m31 =  Double.parseDouble(m3);

        int p = getPuntaje(m11, m21, m31, genero);

        String eddit = "UPDATE Persona " + 
                        "SET Nombre = '" + nombre + "', " +  
                        "Cedula = '" + cedula + "', " + 
                        "Genero = '"+ genero + "', " +  
                        "Muestra1 = '" + m11 + "', " +   
                        "Muestra2 = '" + m21 + "', " +   
                        "Muestra3 = '" + m31 + "', " +    
                        "Puntaje = '" + p + "' " +   
                        " WHERE Cedula = '" + cedula + "';";

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

    public static void deleteEstudiante(String cedula){
        String eddit = "DELETE from Persona " + 
                        " WHERE cedula = " + cedula + ";";

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

    public static Paciente getPaciente(String cedula){
        String sql = "select * from Persona where cedula = "+ cedula;

        Connection conn = Connect.getConnection();
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                Paciente es = new Paciente(rs.getString("Nombre"), 
                                                rs.getString("Cedula"),
                                                rs.getString("Genero"),
                                                rs.getDouble("Muestra1"),
                                                rs.getDouble("Muestra2"),
                                                rs.getDouble("Muestra3"));
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

    public static String getPacientes(){
        String sql = "select * from Persona;";
        String res = "";

        Connection conn = Connect.getConnection();
        try {
            Statement stat = conn.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                String actual = rs.getString("Nombre") +  "-" + 
                rs.getString("Cedula") +  "-" + 
                rs.getString("Genero") +  "-" + 
                rs.getString("Muestra1") +  "-" + 
                rs.getString("Muestra2") +  "-" + 
                rs.getString("Muestra3") + "\n";
                System.out.println(actual);
                res += actual;
                conn.close();
                return res;
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

    
    
}
