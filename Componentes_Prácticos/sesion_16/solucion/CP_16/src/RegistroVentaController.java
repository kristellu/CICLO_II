import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import Connection.Connect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RegistroVentaController {

    @FXML
    private TextField cantidad;

    @FXML
    private Button buttonCrear;

    @FXML
    private ChoiceBox<String> selectProducto;

    @FXML
    private ChoiceBox<String> selectCliente;

    @FXML
    private TextField idCliente;

    @FXML
    private TextField nombreCliente;

    @FXML
    private TextField apellidoCliente;

    @FXML
    private TextField generoCliente;

    @FXML
    private Button buttonCreateClient;

    @FXML
    private Button buttonViewClient;

    ObservableList<String> productos = FXCollections.observableArrayList("Seleccione producto");
    ObservableList<String> clientes = FXCollections.observableArrayList("Seleccione cliente");

    @FXML
    private void initialize() {
        obtenerListaProductos();
        obtenerListaClientes();
    }

    @FXML
    void createClient(ActionEvent event) {
        Connect objConexion = new Connect();

        Integer cedula = Integer.parseInt(idCliente.getText());
        String nombre = nombreCliente.getText();
        String apellido = apellidoCliente.getText();
        String genero = generoCliente.getText();
        objConexion.create("INSERT INTO clientes (cedula,nombre,apellido,genero) VALUES (" + cedula + "," + "'" + nombre
                + "'" + "," + "'" + apellido + "'" + "," + "'" + genero + "'" + ");");
    }

    @FXML
    void createSale(ActionEvent event) {
        Connect objConexion = new Connect();

        Integer cliente = Integer.parseInt(obtenerLlaveSelect(selectCliente.getValue()));
        Integer producto = Integer.parseInt(obtenerLlaveSelect(selectProducto.getValue()));
        Integer cant = Integer.parseInt(cantidad.getText());

        objConexion.create("INSERT INTO ventas (cliente, producto, cantidad ) VALUES (" + cliente + "," + producto + ","
                + cant + ");");
    }

    String obtenerLlaveSelect(String cadena) {
        String[] parts = cadena.split("-");
        String ultima = parts[parts.length - 2];
        return ultima;
    }

    void obtenerListaClientes() {
        Connect objConexion = new Connect();
        String query = "SELECT * from clientes order by id asc;";
        try (Connection conn = objConexion.connect(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                clientes.add(resultSet.getInt("id") + "-" + (resultSet.getString("nombre")));
            }
            selectCliente.setItems(clientes);
            stmt.close();
            resultSet.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    void obtenerListaProductos() {
        Connect objConexion = new Connect();
        String query = "SELECT * from productos order by codigo asc;";
        try (Connection conn = objConexion.connect(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);

            while (resultSet.next()) {
                productos.add(resultSet.getInt("codigo") + "-" + (resultSet.getString("nombre")));
            }
            selectProducto.setItems(productos);
            stmt.close();
            resultSet.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}