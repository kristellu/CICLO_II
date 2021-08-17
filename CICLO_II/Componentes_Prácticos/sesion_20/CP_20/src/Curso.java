import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Curso {

    private int id;
    private String nombre;
    protected Persona instructor;
    protected Horario horario;

    public Curso(int id, String nombre, Persona instructor, Horario horario) {
        this.id = id;
        this.nombre = nombre;
        this.instructor = instructor;
        this.horario = horario;
    }

    public Curso() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setInstructor(Persona instructor) {
        this.instructor = instructor;
    }

    public Persona getInstructor() {
        return instructor;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public Horario getHorario() {
        return horario;
    }

    @Override
    public String toString() {
        return id + "-" + nombre;
    }

    public static ObservableList<String> selectCursos() {
        String query = "SELECT * from cursos order by id asc;";
        ObservableList<String> cursos = FXCollections.observableArrayList("Seleccione un curso");

        try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                cursos.add(resultSet.getInt("id") + "-" + (resultSet.getString("nombre")));
            }
            stmt.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cursos;
    }

    public static String listaCursos() {
        String query = "SELECT * from cursos order by id asc ;";
        String cursos = "";
        try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();

            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    String columnValue = resultSet.getString(i);
                    cursos = cursos + rsmd.getColumnName(i) + ": " + " " + columnValue + " ";
                    if (i == columnsNumber)
                        cursos = cursos + "\n";
                }
            }
            return cursos;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return cursos;
    }

    public static String createCurso(String nombre, int horario, int instructor) {
        String sql = "INSERT INTO cursos (id,nombre, horario, instructor) VALUES (" + null + ", '" + nombre + "', "
                + horario + ", " + instructor + ");";
        String result = "";

        try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement()) {
            int rs = stmt.executeUpdate(sql);
            stmt.close();
            if (rs == 1) {
                result = "Curso creado satisfactoriamente";
            } else {
                result = "Curso no ha podido ser creado.";
            }
        } catch (SQLException e) {
            result = e.getMessage();
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
        return result;
    }
}
