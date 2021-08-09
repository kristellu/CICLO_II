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
    private Button addDataButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label cityLabel;

    @FXML
    private TextField cityTextField;

    @FXML
    private Label waterTypeLabel;

    @FXML
    private TextField waterTypeTextField;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label bodyOfWaterTypeLabel;

    @FXML
    private TextField bodyOfWaterTypeTextField;

    @FXML
    private Label ircaLabel;

    @FXML
    private TextField ircaTextField;

    @FXML
    private Button processButton;

    @FXML
    private TextArea richTextField1;

    @FXML
    private TextArea richTextField2;

    @FXML
    void clickDataButton(ActionEvent event) {
        String s = String.join(" ", nameTextField.getText(), idTextField.getText(), cityTextField.getText(),
                bodyOfWaterTypeTextField.getText(), waterTypeTextField.getText(), ircaTextField.getText());
        richTextField1.setText(richTextField1.getText() + s + "\n");
        nameTextField.setText("");
        idTextField.setText("");
        cityTextField.setText("");
        bodyOfWaterTypeTextField.setText("");
        waterTypeTextField.setText("");
        ircaTextField.setText("");
    }

    @FXML
    void clickProcessButton(ActionEvent event) {
        String datitos = richTextField1.getText().strip();
        String[] cuerposDeAguasS = datitos.split("\n");
        CuerpoDeAgua[] datos = new CuerpoDeAgua[cuerposDeAguasS.length];
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            String[] temp = cuerposDeAguasS[i].split(" ");
            datos[i] = new CuerpoDeAgua(temp[0], Double.parseDouble(temp[1]), temp[2], temp[3], temp[4],
                    Double.parseDouble(temp[5]));
        }
        //Nombre e irca de cada cuerpo de agua        
        String nombre_irca;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            nombre_irca = datos[i].getNombre()+" "+String.format("%.2f", datos[i].getIrca());
            System.out.println(nombre_irca);
            richTextField2.setText(richTextField2.getText() + nombre_irca +"\n");
        }        
        
        //Numero de cuerpos de agua con irca mayor o igual a 50
        double cont = 0;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            if (datos[i].getIrca() >= 50) {
                cont++;
            }

        }
        System.out.println(String.format("%.2f", cont));
        richTextField2.setText(richTextField2.getText() + String.format("%.2f", cont) + "\n");       


        //Nombre de los municipios con cuerpos de agua con nivel de riesgo ALTO
        double contm = 0;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            if (datos[i].getIrca() > 35 && datos[i].getIrca() <= 80) {
                System.out.print(datos[i].getMunicipio()+ " ");
                richTextField2.setText(richTextField2.getText() + datos[i].getMunicipio() + " ");
                contm++;
            }
        }
        if (contm == 0) {
            System.out.print("NA");
            richTextField2.setText(richTextField2.getText() + "NA");
        }

        // irca mas alto
        double max = -1;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            if (datos[i].getIrca() > max) {
                max = datos[i].getIrca();
            }
        }
        System.out.println("\n"+String.format("%.2f", max));
        richTextField2.setText(richTextField2.getText() + "\n" +String.format("%.2f", max) + "\n");         

    }

}