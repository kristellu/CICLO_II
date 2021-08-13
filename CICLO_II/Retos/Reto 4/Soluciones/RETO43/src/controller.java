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
    private Label ageLabel;

    @FXML
    private TextField ageTextField;

    @FXML
    private Label diseaseLabel;

    @FXML
    private TextField diseaseTextField;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label cityLabel;

    @FXML
    private TextField cityTextField;

    @FXML
    private Label epsLabel;

    @FXML
    private TextField epsTextField;

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
    private Label resultAgeLabel;

    @FXML
    private TextField resultAgeTextField;

    @FXML
    private Label resultDiseaseLabel;

    @FXML
    private TextField resultDiseaseTextField;

    @FXML
    private Label resultIdLabel;

    @FXML
    private TextField resultIdTextField;

    @FXML
    private Label resultCityLabel;

    @FXML
    private TextField resultCityTextField;

    @FXML
    private Label resultEpsLabel;

    @FXML
    private TextField resultEpsTextField;

    @FXML
    void addPatientButtonClick(ActionEvent event) {
        Paciente.savePaciente(nameTextField.getText(), idTextField.getText(), ageTextField.getText(), cityTextField.getText(),
                                epsTextField.getText(), diseaseTextField.getText());
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
                              resultAgeTextField.getText(),
                              resultCityTextField.getText(),
                              resultEpsTextField.getText(),
                              resultDiseaseTextField.getText());
    }

    @FXML
    void getDataButtonClick(ActionEvent event) {
        Paciente[] arrPxs = Paciente.getAllPacientes();
        for (Paciente px : arrPxs) {
            String s = String.join("-", px.getNombre(),
                                        px.getCedula(),
                                        String.valueOf(px.getEdad()),
                                        px.getCiudad(),
                                        px.getEps(),
                                        px.getEnfermedad());
            System.out.println(s);
            TextArea1.setText(TextArea1.getText() + s + "\n");
        }
    }

    public static float promedio(Paciente[] pxs) {
        float tot = 0;
        for (Paciente px : pxs) {
            tot += px.getEdad();
        }
        return (float) tot/pxs.length;
    }

    @FXML
    void arribaProm(Paciente[] pxs, float promedio) {
        for (Paciente px : pxs) {
            if (px.getEdad() > promedio) {
                System.out.println(px.getNombre() + " " + px.getCedula());
                TextArea2.setText(TextArea2.getText() + px.getNombre() + " " + px.getCedula() + "\n");
            }
        }
    }

    public static void contEnfermedades(Paciente[] pxs, int[] conts) {
        for (Paciente px : pxs) {
            switch (px.getEnfermedad()) {
                case "Cancer":
                    conts[0] += 1;
                    break;
                case "Cardiovasculares":
                    conts[1] += 1;
                    break;
                case "Respiratorias":
                    conts[2] += 1;
                    break;
                case "Cerebrovasculares":
                    conts[3] += 1;
                    break;
                case "Hipertension":
                    conts[4] += 1;
                    break;
                case "Diabetes":
                    conts[5] += 1;
                    break;
            }
        }
    }

    @FXML
    void processDataButtonClick(ActionEvent event) {
        String datitos = TextArea1.getText().strip();
        String[] pacientes = datitos.split("\n");
        Paciente datos[] = new Paciente[pacientes.length];

        String[] enfermedades = {"Cancer", "Cardiovasculares", "Respiratorias", "Cerebrovasculares", "Hipertension", "Diabetes"};
        int[] contEnf = {0, 0, 0, 0, 0, 0};

        for (int i = 0; i < pacientes.length; i++) {
            String[] temp = pacientes[i].split("-");
            Paciente px = new Paciente(temp[0], temp[1], Integer.parseInt(temp[2]), temp[3], temp[4], temp[5]);
            datos[i] = px;
        }

        float prom = promedio(datos);
        System.out.println(String.format("%.2f", prom));
        TextArea2.setText(TextArea2.getText() + String.format("%.2f", prom) + "\n");

        arribaProm(datos, prom);
        contEnfermedades(datos, contEnf);

        for (int i = 0; i < 6; i++) {
            System.out.println(enfermedades[i] + " " + contEnf[i]);
            TextArea2.setText(TextArea2.getText() + enfermedades[i] + " " + contEnf[i] + "\n");
        }

        for (Paciente px : datos) {
            if (px.clasificarEdad().equalsIgnoreCase("joven adulto")) {
                System.out.println(px.getNombre() + " " + px.getCedula());
                TextArea2.setText(TextArea2.getText() + px.getNombre() + " " + px.getCedula() + "\n");
            }
        }
    }

    @FXML
    void searchButtonClick(ActionEvent event) {
        String cedula = searchIdTextField.getText();
        if (!cedula.isEmpty()) {
            Paciente px = Paciente.getPaciente(cedula);
            resultNameTextField.setText(px.getNombre());
            resultIdTextField.setText(px.getCedula());
            resultAgeTextField.setText(String.valueOf(px.getEdad()));
            resultCityTextField.setText(px.getCiudad());
            resultEpsTextField.setText(px.getEps());
            resultDiseaseTextField.setText(px.getEnfermedad());
        }
    }

}
