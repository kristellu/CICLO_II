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
    void enfermedadMasFrecuente(String[] enf, int[] cont) {
        int max = -1;
        for (int i = 0; i < 6; i++) {
            if (cont[i] > max) max = cont[i];
        }
        for (int i = 0; i < 6; i++) {
            if (cont[i] == max) {
                System.out.println(enf[i]);
                TextArea2.setText(TextArea2.getText() + enf[i] + "\n");
                break;
            }
        }
    }

    @FXML
    void enfermedadMenosFrecuente(String[] enf, int[] cont) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            if (cont[i] < min) min = cont[i];
        }
        for (int i = 0; i < 6; i++) {
            if (cont[i] == min) {
                System.out.println(enf[i]);
                TextArea2.setText(TextArea2.getText() + enf[i] + "\n");
                break;
            }
        }
    }

    public static boolean buscarElem(String[] vec, String elem) {
        boolean res = false;
        for (int  i = 0; i  < vec.length; i ++) {
            if (elem.equals(vec[i])) {
                return true;
            }
        }
        return res;
    }

    @FXML
    void contarEPS(Paciente[] pxs) {
        String[] visitadas = new String[pxs.length];
        int pos = 0;
        for (int i = 0; i < pxs.length; i++) visitadas[i] = "";
        for (Paciente px : pxs) {
            if(buscarElem(visitadas, px.getEps()) == false) {
                visitadas[pos] = px.getEps();
                pos += 1;
            }
        }

        int[] cont = new int[pos];
        for (int i = 0; i < pos; i++) {
            for (Paciente px : pxs) {
                if (visitadas[i].equals(px.getEps())) {
                    cont[i] += 1;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < cont.length; i++) {
            if (cont[i] > max) max = cont[i];
        }
        for (int i = 0; i < cont.length; i++) {
            if (cont[i] == max) {
                System.out.println(visitadas[i]);
                TextArea2.setText(TextArea2.getText() + visitadas[i] + "\n");
                break;
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

        contEnfermedades(datos, contEnf);
        enfermedadMasFrecuente(enfermedades, contEnf);
        enfermedadMenosFrecuente(enfermedades, contEnf);
        contarEPS(datos);

        for (Paciente px : datos) {
            if (px.clasificarEdad().equalsIgnoreCase("adulto")) {
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
