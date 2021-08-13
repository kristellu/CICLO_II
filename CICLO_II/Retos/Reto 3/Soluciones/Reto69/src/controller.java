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

        //nivel de riesgo e id de cada cuerpo de agua        
        String nivel_id;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            nivel_id = datos[i].nivel()+" "+String.format("%.2f", datos[i].getId());
            System.out.println(nivel_id);
            richTextField2.setText(richTextField2.getText() + nivel_id +"\n");
        }

        //Numero de cuerpos de agua que requieren la accion de la ALCALDIA
        double cont = 0;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            if (datos[i].getIrca() > 35 && datos[i].getIrca() <= 80) {
                cont++;
            }

        }
        System.out.println(String.format("%.2f", cont));
        richTextField2.setText(richTextField2.getText() + String.format("%.2f", cont) + "\n"); 
                     

         //Irca de los cuerpos que tienen nivel de riesgo BAJO
         double contm = 0;
         for (int i = 0; i < cuerposDeAguasS.length; i++) {
             if (datos[i].getIrca() > 5 && datos[i].getIrca() <= 14) {
                 System.out.println(String.format("%.2f", datos[i].getIrca())+ " ");
                 richTextField2.setText(richTextField2.getText() + String.format("%.2f", datos[i].getIrca()) + " ");
                 contm++;
             }
         }
        if (contm == 0) {
            System.out.print("NA");
            richTextField2.setText(richTextField2.getText() + "NA");
        }

        //irca promedio
        double promedio;
        double suma = 0;
        for (int i = 0; i < cuerposDeAguasS.length; i++) {
            suma+= datos[i].getIrca();            
        }
        promedio = suma/cuerposDeAguasS.length;
        System.out.println("\n"+String.format("%.2f", promedio));
        richTextField2.setText(richTextField2.getText() + "\n" +String.format("%.2f", promedio) + "\n");        

    }

}