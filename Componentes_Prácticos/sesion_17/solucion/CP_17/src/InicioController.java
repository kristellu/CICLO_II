import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import Connection.Connect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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
    private Label error;

    @FXML
    void createProduct(ActionEvent event) {
        Connect objConexion = new Connect();
        String code = codeProduct.getText();
        String name = nameProduct.getText();
        String pCompra = precioCompra.getText();
        String pVenta = precioVenta.getText();
        String cBodega = cantBodega.getText();
        String cMin = cantMin.getText();
        String cMax = cantMax.getText();

        String message = "";

        if (code.isEmpty() || name.isEmpty() || pCompra.isEmpty() || pVenta.isEmpty() || cBodega.isEmpty()
                || cMin.isEmpty()) {
            message = "Error: todos los campos deben existir";
        }

        if (message.isEmpty()) {
            try {
                Integer codigo = Integer.parseInt(code);
                Integer precioCompra = Integer.parseInt(pCompra);
                Integer precioVenta = Integer.parseInt(pVenta);
                Integer cantBodega = Integer.parseInt(cBodega);
                Integer cantMin = Integer.parseInt(cMin);
                Integer cantMax = Integer.parseInt(cMax);
                try (Connection conn = objConexion.connect(); Statement stmt = conn.createStatement()) {
                    stmt.executeUpdate(
                            "INSERT INTO productos (codigo,nombre,precio_compra,precio_venta,cant_bodega,cant_min_requerida,cant_max_inv_permitida) VALUES ("
                                    + codigo + "," + "'" + name + "'" + "," + precioCompra + "," + precioVenta + ","
                                    + cantBodega + "," + cantMin + "," + cantMax + ");");
                    System.out.println("Producto creado");
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

            } catch (NumberFormatException ex) {
                message = "El campo debe ser un número";
                error.setText(message);
            }
        } else {
            error.setText(message);
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
