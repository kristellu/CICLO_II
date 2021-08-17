import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class controller {

    @FXML
    private Label bodyOfWaterLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label typeOfWaterLabel;

    @FXML
    private TextField typeOfWaterTextField;

    @FXML
    private Label cityLabel;

    @FXML
    private TextField cityTextField;

    @FXML
    private Label bodyOfWaterTypeLabel;

    @FXML
    private TextField bodyOfWaterTypeTextField;

    @FXML
    private Label ircaLabel;

    @FXML
    private TextField ircaTextField;

    @FXML
    private Button addBodyOfWaterButton;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    @FXML
    private Label pNameLabel;

    @FXML
    private TextField pNameTextField;

    @FXML
    private Label pIDLabel;

    @FXML
    private TextField pIDTextField;

    @FXML
    private Label populationLabel;

    @FXML
    private TextField populationTextField;

    @FXML
    private ListView<DensidadPoblacional> populationDensityList;

    @FXML
    private TextArea textArea3;

    @FXML
    private Button addPopulationDensityButton;

    @FXML
    private Button addPopulationButton;

    @FXML
    private Button processDataButton;

    @FXML
    void addBodyOfWaterButtonClick(ActionEvent event) {
        String s = String.join(" ", nameTextField.getText(),
                                    idTextField.getText(),
                                    cityTextField.getText(),
                                    bodyOfWaterTypeTextField.getText(),
                                    typeOfWaterTextField.getText(),
                                    ircaTextField.getText());
        //System.out.println(s);
        textArea1.setText(textArea1.getText() + s + "\n");
        nameTextField.setText("");
        idTextField.setText("");
        cityTextField.setText("");
        bodyOfWaterTypeTextField.setText("");
        typeOfWaterTextField.setText("");
        ircaTextField.setText("");
    }

    @FXML
    void addPopulationButtonClick(ActionEvent event) {
        if (!populationTextField.getText().isEmpty()) {
            int cantHab = Integer.parseInt(populationTextField.getText());
            DensidadPoblacional pd = populationDensityList.getSelectionModel().getSelectedItem();
            pd.setCantidadHabitantes(cantHab);
            populationTextField.setText("");
        }
    }

    @FXML
    void addPopulationDensityButtonClick(ActionEvent event) {
        DensidadPoblacional pd = new DensidadPoblacional(Double.parseDouble(pIDTextField.getText()), pNameTextField.getText());
        populationDensityList.getItems().add(pd);
        pNameTextField.setText("");
        pIDTextField.setText("");
    }

    @FXML
    void itemMouseClick(MouseEvent event) {
        DensidadPoblacional pd = populationDensityList.getSelectionModel().getSelectedItem();
        textArea3.setText("");
        textArea3.setText("El nivel de afección en es de tipo: " + String.valueOf(pd.afeccion()));
    }

    @FXML
    void processDataButtonClick(ActionEvent event) {
        String datitos = textArea1.getText().strip();
        String[] cuerposDeAguasS = datitos.split("\n");
        CuerpoDeAgua[] datos = new CuerpoDeAgua[cuerposDeAguasS.length];
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            String[] temp = cuerposDeAguasS[i].split(" ");
            datos[i] = new CuerpoDeAgua(temp[0], Double.parseDouble(temp[1]),
                    temp[2], temp[3], temp[4], Double.parseDouble(temp[5]));
        }


        String nombre;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            nombre = datos[i].getNombre();
            System.out.println(nombre);
            textArea2.setText(textArea2.getText() + nombre +"\n");
        }

        //Numero de cuerpos de agua con nivel de riesgo BAJO o inferior
        double cont = 0;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            if (datos[i].getIrca() <= 14) {
                cont++;
            }

        }
        System.out.println(String.format("%.2f", cont));
        textArea2.setText(textArea2.getText() + String.format("%.2f", cont) +"\n");

        //Nombre de cuerpos de agua con nivel de riesgo BAJO
        double contm = 0;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            if (datos[i].getIrca() > 5 && datos[i].getIrca() <= 14) {
                System.out.print(datos[i].getNombre() + " ");
                textArea2.setText(textArea2.getText() + datos[i].getNombre() + " " + "\n");
                contm++;
            }
        }
        if (contm == 0) {
            System.out.print("NA");
            textArea2.setText(textArea2.getText() + "NA" + "\n");
        }

        //Nombre del cuerpo con irca mas alto e id
        double max = -1;
        String nombre_alto = "";
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            if (datos[i].getIrca() > max) {
                max = datos[i].getIrca();
                nombre_alto = datos[i].getNombre() + " " + String.format("%.2f", datos[i].getId());
            }
        }
        System.out.println("\n" + nombre_alto);
        textArea2.setText(textArea2.getText() + nombre_alto + "\n");
    }

}
