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
    private Label nauseasLabel;

    @FXML
    private TextField nauseasTextField;

    @FXML
    private Label diarrheaLabel;

    @FXML
    private TextField diarrheaTextField;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label vomitsLabel;

    @FXML
    private TextField vomitsTextField;

    @FXML
    private Label feverLabel;

    @FXML
    private TextField feverTextField;

    @FXML
    private Label abPainLabel;

    @FXML
    private TextField abPainTextField;

    @FXML
    private Button addPatientButton;

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
    private Label resultNauseasLabel;

    @FXML
    private TextField resultNauseasTextField;

    @FXML
    private Label resultDiarrheaLabel;

    @FXML
    private TextField resultDiarrheaTextField;

    @FXML
    private Label resultIdLabel;

    @FXML
    private TextField resultIdTextField;

    @FXML
    private Label resultVomitsLabel;

    @FXML
    private TextField resultVomitsTextField;

    @FXML
    private Label resultFeverLabel;

    @FXML
    private TextField resultFeverTextField;

    @FXML
    private Label resultAbPainLabel;

    @FXML
    private TextField resultAbPainTextField;

    @FXML
    private Label resultDiagnosticLabel;

    @FXML
    private TextField resultDiagnosticTextField;

    @FXML
    void addPatientButtonClick(ActionEvent event) {
        Paciente px = new Paciente(nameTextField.getText(), idTextField.getText(), nauseasTextField.getText(), vomitsTextField.getText(),
                                    abPainTextField.getText(), diarrheaTextField.getText(), feverTextField.getText());
        String[] sintomas = {px.getNauseas(), px.getVomitos(), px.getDolor(), px.getDiarrea(), px.getFiebre()};
        Paciente.savePaciente(nameTextField.getText(), idTextField.getText(), nauseasTextField.getText(), vomitsTextField.getText(),
                                abPainTextField.getText(), diarrheaTextField.getText(), feverTextField.getText(), px.diagnosticar(sintomas));
    }

    @FXML
    void deleteButtonClick(ActionEvent event) {
        String cedula = searchIdTextField.getText();
        Paciente.deletePaciente(cedula);
    }

    @FXML
    void editButtonClick(ActionEvent event) {
        String cedula = searchIdTextField.getText();
        Paciente.editPaciente(cedula,
                              resultNameTextField.getText(),
                              resultIdTextField.getText(),
                              resultNauseasTextField.getText(),
                              resultVomitsTextField.getText(),
                              resultAbPainTextField.getText(),
                              resultDiarrheaTextField.getText(),
                              resultFeverTextField.getText(),
                              resultDiagnosticTextField.getText());
    }

    @FXML
    void getDataButtonClick(ActionEvent event) {
        Paciente[] arrPxs = Paciente.getAllPacientes();
        for (Paciente px : arrPxs) {
            String s = String.join("-", px.getNombre(),
                                        px.getCedula(),
                                        px.getNauseas(),
                                        px.getVomitos(),
                                        px.getDolor(),
                                        px.getDiarrea(),
                                        px.getFiebre());
            System.out.println(s);
            TextArea1.setText(TextArea1.getText() + s + "\n");
        }
    }

    @FXML
    void processDataButtonClick(ActionEvent event) {
        String datitos = TextArea1.getText().strip();
        String[] pacientes = datitos.split("\n");
        Paciente datos[] = new Paciente[pacientes.length];

        int cantNoDiag = 0;
        int[] cantSint = new int[5];

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
            TextArea2.setText(TextArea2.getText() + px.getCedula() + " " + diagnostico + "\n");
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
                TextArea2.setText(TextArea2.getText() + vecSint[i] + "\n");
                break;
            }
        }
        for (int i = 0; i < 5; i++){
            if (cantSint[i] == min) {
                System.out.println(vecSint[i]);
                TextArea2.setText(TextArea2.getText() + vecSint[i] + "\n");
                break;
            }
        }
        System.out.println(pacientes.length - cantNoDiag);
        TextArea2.setText(TextArea2.getText() + (pacientes.length - cantNoDiag) + "\n");
    }

    @FXML
    void searchButtonClick(ActionEvent event) {
        String cedula = searchIdTextField.getText();
        if (!cedula.isEmpty()) {
            Paciente px = Paciente.getPaciente(cedula);
            resultNameTextField.setText(px.getNombre());
            resultIdTextField.setText(px.getCedula());
            resultNauseasTextField.setText(px.getNauseas());
            resultVomitsTextField.setText(px.getVomitos());
            resultAbPainTextField.setText(px.getDolor());
            resultDiarrheaTextField.setText(px.getDiarrea());
            resultFeverTextField.setText(px.getFiebre());
            resultDiagnosticTextField.setText(px.getDiagnostico());
        }
    }

}
