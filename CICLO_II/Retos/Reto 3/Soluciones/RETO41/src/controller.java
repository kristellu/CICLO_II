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
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label genreLabel;

    @FXML
    private TextField genreTextField;

    @FXML
    private Label nauseaLabel;

    @FXML
    private TextField nauseasTextField;

    @FXML
    private Label vomitLabel;

    @FXML
    private TextField vomitTextField;

    @FXML
    private Label abPainLabel;

    @FXML
    private TextField abPainTextField;

    @FXML
    private Label diarrheaLabel;

    @FXML
    private TextField diarrheaTextField;

    @FXML
    private Label feverLabel;

    @FXML
    private TextField feverTextField;

    @FXML
    private Button processButton;

    @FXML
    private TextArea richTextField1;

    @FXML
    private TextArea richTextField2;

    @FXML
    void clickDataButton(ActionEvent event) {
        String s = String.join("-", nameTextField.getText(),
                                    idTextField.getText(),
                                    genreTextField.getText(),
                                    nauseasTextField.getText(),
                                    vomitTextField.getText(),
                                    abPainTextField.getText(),
                                    diarrheaTextField.getText(),
                                    feverTextField.getText());
        //System.out.println(s);
        richTextField1.setText(richTextField1.getText() + s + "\n");
        nameTextField.setText("");
        idTextField.setText("");
        genreTextField.setText("");
        nauseasTextField.setText("");
        vomitTextField.setText("");
        abPainTextField.setText("");
        diarrheaTextField.setText("");
        feverTextField.setText("");
    }

    @FXML
    void clickProcessButton(ActionEvent event) {
        String datitos = richTextField1.getText().strip();
        String[] pacientes = datitos.split("\n");
        Paciente datos[] = new Paciente[pacientes.length];

        int cantNoDiag = 0;
        int[] cantSint = new int[5];

        // Inicializar contadores en 0
        for (int i = 0; i < 5; i++) cantSint[i] = 0;

        for (int i = 0; i < pacientes.length; i++) {
            String[] temp = pacientes[i].split("-");
            Paciente px = new Paciente(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);

            if (px.getNauseas().equalsIgnoreCase("si")) {
                cantSint[0] += 1;
            }
            if (px.getVomitos().equalsIgnoreCase("si")) {
                cantSint[1] += 1;
            }
            if (px.getDolor().equalsIgnoreCase("si")) {
                cantSint[2] += 1;
            }
            if (px.getDiarrea().equalsIgnoreCase("si")) {
                cantSint[3] += 1;
            }
            if (px.getFiebre().equalsIgnoreCase("si")) {
                cantSint[4] += 1;
            }

            datos[i] = px;
        }

        for (Paciente px : datos) {
            String[] sintomas = {px.getNauseas(), px.getVomitos(), px.getDolor(), px.getDiarrea(), px.getFiebre()};
            String diagnostico = px.diagnosticar(sintomas);
            if (diagnostico.equals("Sin diagnostico")) cantNoDiag += 1;
            System.out.println(px.getCedula() + " " + diagnostico);
            richTextField2.setText(richTextField2.getText() + px.getCedula() + " " + diagnostico + "\n");
        }

        String[] vecSint = {"nauseas", "vomitos", "dolor abdominal", "diarrea", "fiebre"};
        int max, min;
        max = -1; min = 10000;

        for (int i = 0; i < 5; i++) {
            if (max < cantSint[i]) {
                max = cantSint[i];
            }
            if (min > cantSint[i]) {
                min = cantSint[i];
            }
        }
        for (int i = 0; i < 5; i++){
            if (cantSint[i] == max) {
                System.out.println(vecSint[i]);
                richTextField2.setText(richTextField2.getText() + vecSint[i] + "\n");
                break;
            }
        }
        for (int i = 0; i < 5; i++){
            if (cantSint[i] == min) {
                System.out.println(vecSint[i]);
                richTextField2.setText(richTextField2.getText() + vecSint[i] + "\n");
                break;
            }
        }
        System.out.println(pacientes.length - cantNoDiag);
        richTextField2.setText(richTextField2.getText() + (pacientes.length - cantNoDiag) + "\n");

    }

}
