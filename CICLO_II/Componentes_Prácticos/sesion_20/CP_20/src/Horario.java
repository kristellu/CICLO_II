import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;

import Connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Horario {

    private int id;
    private String dia;
    private Time hora;

    public Horario(int id, String dia, Time hora) {
        this.id = id;
        this.dia = dia;
        this.hora = hora;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getDia() {
        return dia;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public Time getHora() {
        return hora;
    }

    public static ObservableList<String> selectHorarios() {
        String query = "SELECT * from horarios order by id asc;";
        ObservableList<String> horarios = FXCollections.observableArrayList("Seleccione un horario");

        try (Connection conn = Connect.connect(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                horarios.add(resultSet.getInt("id") + "-" + (resultSet.getString("dia")) + " "
                        + (resultSet.getString("hora")));
            }
            stmt.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return horarios;
    }
}
