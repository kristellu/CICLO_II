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

        int[] bac = {0, 0};
        int[] vir = {0, 0};

        for (int i = 0; i < pacientes.length; i++) {
            String[] temp = pacientes[i].split("-");
            Paciente px = new Paciente(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
            datos[i] = px;
        }

        for (Paciente px : datos) {
            String[] sintomas = {px.getNauseas(), px.getVomitos(), px.getDolor(), px.getDiarrea(), px.getFiebre()};
            String diagnostico = px.diagnosticar(sintomas);
            if (diagnostico.equals("Staphylococcus aureus")) {
                bac[0] += 1;
            } else if (diagnostico.equals("Bacillus cereus")) {
                bac[1] += 1;
            } else if (diagnostico.equals("Norovirus")) {
                vir[0] += 1;
            } else if (diagnostico.equals("Rotavirus")) {
                vir[1] += 1;
            }
            System.out.println(px.getCedula() + " " + diagnostico);
            richTextField2.setText(richTextField2.getText() + px.getCedula() + " " + diagnostico + "\n");
        }

        if (bac[0] == 0 && bac[1] == 0) {
            System.out.println("NA");
            richTextField2.setText(richTextField2.getText() + "NA" + "\n");
        } else if (bac[0] > bac[1]) {
            System.out.println("Staphylococcus aureus");
            richTextField2.setText(richTextField2.getText() + "Staphylococcus aureus" + "\n");
        } else {
            System.out.println("Bacillus cereus");
            richTextField2.setText(richTextField2.getText() + "Bacillus cereus" + "\n");
        }

        if (vir[0] == 0 && vir[1] == 0) {
            System.out.println("NA");
            richTextField2.setText(richTextField2.getText() + "NA" + "\n");
        } else if (vir[0] > vir[1]) {
            System.out.println("Norovirus");
            richTextField2.setText(richTextField2.getText() + "Norovirus" + "\n");
        } else {
            System.out.println("Rotavirus");
            richTextField2.setText(richTextField2.getText() + "Rotavirus" + "\n");
        }

    }

}
