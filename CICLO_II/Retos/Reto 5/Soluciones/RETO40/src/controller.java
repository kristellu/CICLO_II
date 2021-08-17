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

        String diag[] = new String[100];
        String cla[] = new String[100];
        int repDiag[] = new int[5];

        int pacSD = 0;

        for (int i = 0; i < pacientes.length; i++) {
            String[] temp = pacientes[i].split("-");
            Paciente px = new Paciente(temp[0], temp[1], temp[2], temp[3], temp[4], temp[5], temp[6]);
            datos[i] = px;
        }

        for (int j = 0; j < 5; j++) {
            repDiag[j] = 0;
        }

        for (int i = 0; i < pacientes.length; i++) {
            int swD = 0;
            Paciente pac = datos[i];

            //Staphylococcus aureus
            if (pac.getNauseas().equalsIgnoreCase("si") && pac.getVomitos().equalsIgnoreCase("si") && pac.getDolor().equalsIgnoreCase("si")
                    && pac.getDiarrea().equalsIgnoreCase("si") && pac.getFiebre().equalsIgnoreCase("si")) {
                    diag[i] = "Staphylococcus aureus";
                    cla[i] = "Bacteriano";
                    repDiag[0] += 1;
                    swD = 1;
            }
            //Bacillus cereus
            if (pac.getNauseas().equalsIgnoreCase("si") && pac.getVomitos().equalsIgnoreCase("si")) {
                if (pac.getDolor().equalsIgnoreCase("no") && pac.getDiarrea().equalsIgnoreCase("no") && pac.getFiebre().equalsIgnoreCase("no")){
                    diag[i] = "Bacillus cereus";
                    cla[i] = "Bacteriano";
                    swD = 1;
                    repDiag[1] += 1;

                }

            }

            //Taenia saginata
            if (pac.getDolor().equalsIgnoreCase("si") && pac.getFiebre().equalsIgnoreCase("si")) {
                if (pac.getNauseas().equalsIgnoreCase("no") && pac.getVomitos().equalsIgnoreCase("no") && pac.getDiarrea().equalsIgnoreCase("no")) {
                    diag[i] = "Taenia saginata";
                    cla[i] = "Parasitaria";
                    swD = 1;
                    repDiag[2] += 1;

                }

            }

            //Norovirus 2 3 6 9
            if (pac.getNauseas().equalsIgnoreCase("si") && pac.getVomitos().equalsIgnoreCase("si") && pac.getDiarrea().equalsIgnoreCase("si") && pac.getFiebre().equalsIgnoreCase("si")) {
                if (pac.getDolor().equalsIgnoreCase("no")) {
                    diag[i] = "Norovirus";
                    cla[i] = "Viral";
                    swD = 1;
                    repDiag[3] += 1;
                }
            }

            //Rotavirus 3 9 6
            if (pac.getVomitos().equalsIgnoreCase("si") && pac.getDiarrea().equalsIgnoreCase("si")) {
                if (pac.getNauseas().equalsIgnoreCase("no") && pac.getDolor().equalsIgnoreCase("no") && pac.getFiebre().equalsIgnoreCase("no")) {
                    diag[i] = "Rotavirus";
                    cla[i] = "Viral";
                    swD = 1;
                    repDiag[4] += 1;
                }

            }

            if (swD == 0) {
                pacSD++;
                diag[i] = "Sin diagnostico";
                cla[i] = "Sin clasificacion";
            }
        }

        for (int i = 0; i < pacientes.length; i++) {
            System.out.println(datos[i].getCedula() + " " + diag[i]);
            String string = datos[i].getCedula() + " " + diag[i] + "\n";
            textArea2.setText(textArea2.getText() + string);
        }

        int may = -1, numM = 0;
        for (int j = 0; j < 5; j++) {
            if (repDiag[j] > may) {
                may = j;
                numM = j;
            }
        }

        switch (numM) {
            case 0:
                System.out.println("Staphylococcus aureus");
                textArea2.setText(textArea2.getText() + "Staphylococcus aureus" + "\n");
                break;
            case 1:
                System.out.println("Bacillus cereus");
                textArea2.setText(textArea2.getText() + "Bacillus cereus" + "\n");
                break;
            case 2:
                System.out.println("Taenia saginata");
                textArea2.setText(textArea2.getText() + "Taenia saginata" + "\n");
                break;
            case 3:
                System.out.println("Norovirus");
                textArea2.setText(textArea2.getText() + "Norovirus" + "\n");
                break;
            case 4:
                System.out.println("Rotavirus");
                textArea2.setText(textArea2.getText() + "Rotavirus" + "\n");
                break;
        }

        System.out.println((pacSD));
        textArea2.setText(textArea2.getText() + pacSD + "\n");

    }

}
