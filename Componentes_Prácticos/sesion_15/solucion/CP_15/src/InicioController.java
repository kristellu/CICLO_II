import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Connection.Connect;

public class InicioController {

    String url = "jdbc:sqlite:C:/Users/KRISTE~1/Documents/MINTIC/CICLO-II/CP_15/db";

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
    private Label productList;

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

        objConexion.insert(
                "INSERT INTO productos (codigo,nombre,precio_compra,precio_venta,cant_bodega,cant_min_requerida,cant_max_inv_permitida) VALUES ("
                        + code + "," + "'" + name + "'" + "," + pCompra + "," + pVenta + "," + cBodega + "," + cMin
                        + "," + cMax + ");");
    }

    @FXML
    void viewProduct(ActionEvent event) {
        Connect objConexion = new Connect();
        productList.setText("Productos: " + objConexion.select("SELECT * from productos;"));
    }

    // public static void main(String[] args) {
    // connect();
    // }
}
