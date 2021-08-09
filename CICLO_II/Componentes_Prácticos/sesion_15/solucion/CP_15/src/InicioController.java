import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import Connection.Connect;

public class InicioController {

    @FXML
    private Button createButton;

    @FXML
    private TextField codeProduct;

    @FXML
    private TextField nameProduct;

    @FXML
    private TextField precioCompra;

    @FXML
    private TextField precioVenta;

    @FXML
    private TextField cantBodega;

    @FXML
    private TextField cantMin;

    @FXML
    private TextField cantMax;

    @FXML
    private Button viewButton;

    @FXML
    private TextArea productsList;

    @FXML
    void createProduct(ActionEvent event) {
        Connect objConexion = new Connect();

        Integer code = Integer.parseInt(codeProduct.getText());
        String name = nameProduct.getText();
        Integer pCompra = Integer.parseInt(precioCompra.getText());
        Integer pVenta = Integer.parseInt(precioVenta.getText());
        Integer cBodega = Integer.parseInt(cantBodega.getText());
        Integer cMin = Integer.parseInt(cantMin.getText());
        Integer cMax = Integer.parseInt(cantMax.getText());

        try (Connection conn = objConexion.connect(); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(
                    "INSERT INTO productos (codigo,nombre,precio_compra,precio_venta,cant_bodega,cant_min_requerida,cant_max_inv_permitida) VALUES ("
                            + code + "," + "'" + name + "'" + "," + pCompra + "," + pVenta + "," + cBodega + "," + cMin
                            + "," + cMax + ");");
            System.out.println("Producto creado");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void viewProduct(ActionEvent event) throws SQLException {
        Connect objConexion = new Connect();
        String query = "SELECT * from productos";
        productsList.setEditable(false);
        try (Connection conn = objConexion.connect(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            String products = "";
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1)
                        System.out.print(", ");
                    String columnValue = resultSet.getString(i);
                    products = products + rsmd.getColumnName(i) + ":" + " " + columnValue + "\n";
                }
                productsList.setText(products);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
