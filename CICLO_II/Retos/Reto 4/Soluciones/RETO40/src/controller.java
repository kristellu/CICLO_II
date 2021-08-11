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
        Paciente.savePaciente(nameTextField.getText(), idTextField.getText(), nauseasTextField.getText(), vomitsTextField.getText(),
                                abPainTextField.getText(), diarrheaTextField.getText(), feverTextField.getText(), px.diagnosticar());
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
            TextArea2.setText(TextArea2.getText() + string);
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
                TextArea2.setText(TextArea2.getText() + "Staphylococcus aureus" + "\n");
                break;
            case 1:
                System.out.println("Bacillus cereus");
                TextArea2.setText(TextArea2.getText() + "Bacillus cereus" + "\n");
                break;
            case 2:
                System.out.println("Taenia saginata");
                TextArea2.setText(TextArea2.getText() + "Taenia saginata" + "\n");
                break;
            case 3:
                System.out.println("Norovirus");
                TextArea2.setText(TextArea2.getText() + "Norovirus" + "\n");
                break;
            case 4:
                System.out.println("Rotavirus");
                TextArea2.setText(TextArea2.getText() + "Rotavirus" + "\n");
                break;
        }

        System.out.println((pacSD));
        TextArea2.setText(TextArea2.getText() + pacSD + "\n");
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
