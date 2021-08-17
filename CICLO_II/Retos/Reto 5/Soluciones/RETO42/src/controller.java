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
    private Label pacientLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label nauseasLabel;

    @FXML
    private TextField nauseasTextField;

    @FXML
    private Label vomitsLabel;

    @FXML
    private TextField vomitsTextField;

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
    private Button addPacientButton;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

    @FXML
    private TextArea textArea3;

    @FXML
    private Label mNameLabel;

    @FXML
    private TextField mNameTextField;

    @FXML
    private Label mIDLabel;

    @FXML
    private TextField mIDTextField;

    @FXML
    private Label pIDLabel;

    @FXML
    private TextField pIDTextField;

    @FXML
    private ListView<Medico> medicList;

    @FXML
    private Button addMedicButton;

    @FXML
    private Button addPacientToMedicButton;

    @FXML
    private Button processDataButton;

    @FXML
    void addMedicButtonClick(ActionEvent event) {
        Medico md = new Medico(mNameTextField.getText(), mIDTextField.getText());
        medicList.getItems().add(md);
        mNameTextField.setText("");
        mIDTextField.setText("");
    }

    @FXML
    public void itemMouseClick(MouseEvent event) {
        Medico md = medicList.getSelectionModel().getSelectedItem();
        textArea3.setText("");
        for (String px : md.getPacientes()) {
            textArea3.setText(textArea3.getText() + px + "\n");
        }
    }

    @FXML
    void addPacientButtonClick(ActionEvent event) {
        String s = String.join("-", nameTextField.getText(),
                                    idTextField.getText(),
                                    nauseasTextField.getText(),
                                    vomitsTextField.getText(),
                                    abPainTextField.getText(),
                                    diarrheaTextField.getText(),
                                    feverTextField.getText());
        //System.out.println(s);
        textArea1.setText(textArea1.getText() + s + "\n");
        nameTextField.setText("");
        idTextField.setText("");
        nauseasTextField.setText("");
        vomitsTextField.setText("");
        abPainTextField.setText("");
        diarrheaTextField.setText("");
        feverTextField.setText("");
    }

    @FXML
    void addPacientToMedicButtonClick(ActionEvent event) {
        Medico md = medicList.getSelectionModel().getSelectedItem();
        md.addPaciente(pIDTextField.getText());
        pIDTextField.setText("");
    }

    @FXML
    void processDataButtonClick(ActionEvent event) {
        String datitos = textArea1.getText().strip();
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
            textArea2.setText(textArea2.getText() + px.getCedula() + " " + diagnostico + "\n");
        }

        if (bac[0] == 0 && bac[1] == 0) {
            System.out.println("NA");
            textArea2.setText(textArea2.getText() + "NA" + "\n");
        } else if (bac[0] > bac[1]) {
            System.out.println("Staphylococcus aureus");
            textArea2.setText(textArea2.getText() + "Staphylococcus aureus" + "\n");
        } else {
            System.out.println("Bacillus cereus");
            textArea2.setText(textArea2.getText() + "Bacillus cereus" + "\n");
        }

        if (vir[0] == 0 && vir[1] == 0) {
            System.out.println("NA");
            textArea2.setText(textArea2.getText() + "NA" + "\n");
        } else if (vir[0] > vir[1]) {
            System.out.println("Norovirus");
            textArea2.setText(textArea2.getText() + "Norovirus" + "\n");
        } else {
            System.out.println("Rotavirus");
            textArea2.setText(textArea2.getText() + "Rotavirus" + "\n");
        }

    }

}
