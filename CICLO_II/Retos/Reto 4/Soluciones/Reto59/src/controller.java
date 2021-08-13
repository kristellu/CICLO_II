import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class controller {

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label cityLabel;

    @FXML
    private TextField cityTextField;

    @FXML
    private Label ircaLabel;

    @FXML
    private TextField ircaTextField;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label bodyOfWaterTypeLabel;

    @FXML
    private TextField bodyOfWaterTypeTextField;

    @FXML
    private Label waterTypeLabel;

    @FXML
    private TextField waterTypeTextField;

    @FXML
    private Button addBodyButton;

    @FXML
    private TextArea TextArea1;

    @FXML
    private TextArea TextArea2;

    @FXML
    private Button getDataButton;

    @FXML
    private Button processDataButton;

    @FXML
    private Label searchIdLabel;

    @FXML
    private TextField searchIdTextField;

    @FXML
    private Button searchButton;

    @FXML
    private Label searchResultLabel;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Label resultNameLabel;

    @FXML
    private TextField resultNameTextField;

    @FXML
    private Label resultCityLabel;

    @FXML
    private TextField resultCityTextField;

    @FXML
    private Label resultIrcaLabel;

    @FXML
    private TextField resultIrcaTextField;

    @FXML
    private Label resultIdLabel;

    @FXML
    private TextField resultIdTextField;

    @FXML
    private Label resultBodyOfWaterTypeLabel;

    @FXML
    private TextField resultBodyOfWaterTypeTextField;

    @FXML
    private Label resultEpsLabel;

    @FXML
    private TextField resultWaterTypeTextField;

    @FXML
    void addBodyButtonClick(ActionEvent event) {
        CuerpoDeAgua.saveCuerpoDeAgua(nameTextField.getText(), idTextField.getText(), cityTextField.getText(), bodyOfWaterTypeTextField.getText(),
                                waterTypeTextField.getText(), ircaTextField.getText());
    }

    @FXML
    void deleteButtonClick(ActionEvent event) {
        String id = searchIdTextField.getText();
        CuerpoDeAgua.deleteCuerpoDeAgua(id);
    }

    @FXML
    void editButtonClick(ActionEvent event) {
        String cedula = searchIdTextField.getText();
        CuerpoDeAgua.editCuerpoDeAgua(cedula,
                              resultNameTextField.getText(),
                              resultIdTextField.getText(),
                              resultCityTextField.getText(),
                              resultBodyOfWaterTypeTextField.getText(),
                              resultWaterTypeTextField.getText(),
                              resultIrcaTextField.getText());
    }

    @FXML
    void getDataButtonClick(ActionEvent event) {
        CuerpoDeAgua[] arrCdas = CuerpoDeAgua.getAllCuerposDeAgua();
        for (CuerpoDeAgua cda : arrCdas) {
            String s = String.join(" ", cda.getNombre(),
                                        String.valueOf(cda.getId()),
                                        cda.getMunicipio(),
                                        cda.getTipoDeCuerpoDeAgua(),
                                        cda.getTipoDeAgua(),
                                        String.valueOf(cda.getIrca()));
            System.out.println(s);
            TextArea1.setText(TextArea1.getText() + s + "\n");
        }
    }

    @FXML
    void processDataButtonClick(ActionEvent event) {
        String datitos = TextArea1.getText().strip();
        String[] cuerposDeAguasS = datitos.split("\n");
        CuerpoDeAgua[] datos = new CuerpoDeAgua[cuerposDeAguasS.length];
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            String[] temp = cuerposDeAguasS[i].split(" ");
            datos[i] = new CuerpoDeAgua(temp[0], Double.parseDouble(temp[1]),
                    temp[2], temp[3], temp[4], Double.parseDouble(temp[5]));
        }

		//Nombre y id de cada cuerpo de agua        
        String nombre_id;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            nombre_id = datos[i].getNombre()+" "+String.format("%.2f", datos[i].getId());
            System.out.println(nombre_id);
            TextArea2.setText(TextArea2.getText() + nombre_id +"\n");
        }

        // Numero de cuerpos de agua con nivel de riesgo entre ALTO e INVIABLE SANITARIAMENTE
        double cont = 0;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            if (datos[i].getIrca() > 35 && datos[i].getIrca() <= 100) {
                cont++;
            }

        }
        System.out.println(String.format("%.2f", cont));
        TextArea2.setText(TextArea2.getText() + String.format("%.2f", cont) +"\n");

        //Nombre de cuerpos de agua con nivel de riesgo ALTO
        double contm = 0;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            if (datos[i].getIrca() > 35 && datos[i].getIrca()  <= 80) {
                System.out.print(datos[i].getNombre() + " ");
                TextArea2.setText(TextArea2.getText() + datos[i].getNombre() + " " + "\n");
                contm++;
            }
        }
        if (contm == 0) {
            System.out.print("NA");
            TextArea2.setText(TextArea2.getText() + "NA" + "\n");
        }
		
		//nivel de riesgo mas bajo
        double min = 101;
        String nivel_bajo = "";
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            if (datos[i].getIrca() < min) {
                min = datos[i].getIrca();
                nivel_bajo = datos[i].nivel();                
            }
        }        
        System.out.println("\n"+nivel_bajo);
		TextArea2.setText(TextArea2.getText() + "\n" + nivel_bajo + "\n");

        
    }

    @FXML
    void searchButtonClick(ActionEvent event) {
        String cedula = searchIdTextField.getText();
        if (!cedula.isEmpty()) {
            CuerpoDeAgua cda = CuerpoDeAgua.getCuerpoDeAgua(cedula);
            resultNameTextField.setText(cda.getNombre());
            resultIdTextField.setText(String.valueOf((int)cda.getId()));
            resultCityTextField.setText(cda.getMunicipio());
            resultBodyOfWaterTypeTextField.setText(cda.getTipoDeCuerpoDeAgua());
            resultWaterTypeTextField.setText(cda.getTipoDeAgua());
            resultIrcaTextField.setText(String.valueOf(cda.getIrca()));
        }
    }

}
