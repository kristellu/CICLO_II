import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Persona {

    private int id;
    private int num_identificacion;
    private String nombre;
    private String apellido;
    private String email;
    private int edad;
    protected Curso curso;
    protected Tipo tipo;

    public Persona(int id, int num_identificacion, String nombre, String apellido, String email, int edad, Curso curso,
            Tipo tipo) {
        this.id = id;
        this.num_identificacion = num_identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.tipo = tipo;
        this.curso = curso;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNumIdentificacion(int num_identificacion) {
        this.num_identificacion = num_identificacion;
    }

    public int getNumIdentificacion() {
        return num_identificacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getEdad() {
        return edad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Curso getCurso() {
        return curso;
    }

    public static String createTripulante(int num_identificacion, String nombre, String apellido, int edad, int curso) {
        String sql = "INSERT INTO personas (id,num_identificacion, nombre, apellido,edad,email,tipo,curso) VALUES ("
                + null + ", " + num_identificacion + ", " + "'" + nombre + "'" + ", " + "'" + apellido + "'" + ", "
                + edad + "," + null + ", " + 1 + ", " + curso + ");";
        String result = "";

        try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement()) {
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                result = "Tripulante creado satisfactoriamente";
            } else {
                result = "Tripulante no ha podido ser creado.";
            }
        } catch (SQLException e) {
            result = e.getMessage();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return result;
    }

    public static String updateTripulante(int num_identificacion, String nombre, String apellido, int edad) {
        String sql = "UPDATE personas SET  nombre = '" + nombre + "', apellido = '" + apellido + "'," + "edad =" + edad
                + " WHERE num_identificacion = " + num_identificacion + ";";
        String result = "";

        try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement()) {
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                result = "Tripulante actualizado satisfactoriamente";
            } else {
                result = "Tripulante no encontrado. Valide num de identificación.";
            }
        } catch (SQLException e) {
            result = e.getMessage();
            System.err.println(e.getMessage());
        }
        return result;
    }

    public static String deleteTripulante(int num_identificacion) {
        String sql = "DELETE from personas " + " WHERE num_identificacion = " + num_identificacion + " AND tipo = 1;";
        String result = "";
        try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            if (rs.next()) {
                result = "Tripulante eliminado satisfactoriamente";
            } else {
                result = "Tripulante no existe en la base de datos, valide num de identificación";
            }
        } catch (SQLException e) {
            result = e.getMessage();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return result;
    }

    public static String createInstructor(int num_identificacion, String nombre, String apellido, String email,
            int curso) {
        String sql = "INSERT INTO personas (id,num_identificacion, nombre, apellido,edad,email,tipo,curso) VALUES ("
                + null + ", " + num_identificacion + ", " + "'" + nombre + "'" + ", " + "'" + apellido + "'" + ", "
                + null + "," + "'" + email + "'" + ", " + 2 + ", " + curso + ");";
        String result = "";

        try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement()) {
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                result = "Instructor creado satisfactoriamente";
            } else {
                result = "Instructor no ha podido ser creado.";
            }
        } catch (SQLException e) {
            result = e.getMessage();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return result;
    }

    public static String updateInstructor(int num_identificacion, String nombre, String apellido, String email,
            int curso) {
        String sql = "UPDATE personas SET  nombre = '" + nombre + "', apellido = '" + apellido + "'," + "email ='"
                + email + "',curso ='" + curso + "'WHERE num_identificacion = " + num_identificacion + ";";
        String result = "";

        try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement()) {
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                result = "Instructor actualizado satisfactoriamente";
            } else {
                result = "Instructor no encontrado. Valide num de identificación.";
            }
        } catch (SQLException e) {
            result = e.getMessage();
            System.err.println(e.getMessage());
        }
        return result;
    }

    public static String deleteInstructor(int num_identificacion) {
        String sql = "DELETE from personas " + " WHERE num_identificacion = " + num_identificacion + " AND tipo = 2;";
        String result = "";
        try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            if (rs.next()) {
                result = "Instructor eliminado satisfactoriamente";
            } else {
                result = "Instructor no existe en la base de datos, valide num de identificación";
            }
        } catch (SQLException e) {
            result = e.getMessage();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return result;
    }

    public static ObservableList<String> selectPersonas(int tipo) {
        String query = "SELECT * from personas WHERE tipo = " + tipo + " order by id asc ;";
        ObservableList<String> personas = FXCollections.observableArrayList("Seleccione un instructor");

        try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                personas.add(resultSet.getInt("id") + "-" + (resultSet.getString("nombre")) + " "
                        + (resultSet.getString("apellido")));
            }
            stmt.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return personas;
    }

    public static String listaPersonas(int tipo) {
        String query = "";
        if (tipo == 1) {
            query = "SELECT id, num_identificacion, nombre, apellido, edad, curso from personas WHERE tipo = " + tipo
                    + " order by id asc ;";
        } else {
            query = "SELECT id, num_identificacion, nombre, apellido, email, curso from personas WHERE tipo = " + tipo
                    + " order by id asc ;";
        }

        String personas = "";
        try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = resultSet.getString(i);
                    personas = personas + rsmd.getColumnName(i) + ": " + " " + columnValue + " ";
                    if (i == columnsNumber)
                        personas = personas + "\n";
                }
            }
            return personas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return personas;
    }
}
