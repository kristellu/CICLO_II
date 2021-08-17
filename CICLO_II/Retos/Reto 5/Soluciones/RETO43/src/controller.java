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
    private Label ageLabel;

    @FXML
    private TextField ageTextField;

    @FXML
    private Label cityLabel;

    @FXML
    private TextField cityTextField;

    @FXML
    private Label epsLabel;

    @FXML
    private TextField epsTextField;

    @FXML
    private Label diseaseLabel;

    @FXML
    private TextField diseaseTextField;

    @FXML
    private Button addPacientButton;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextArea textArea2;

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
    private TextArea textArea3;

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
                                    ageTextField.getText(),
                                    cityTextField.getText(),
                                    epsTextField.getText(),
                                    diseaseTextField.getText());
        //System.out.println(s);
        textArea1.setText(textArea1.getText() + s + "\n");
        nameTextField.setText("");
        idTextField.setText("");
        ageTextField.setText("");
        cityTextField.setText("");
        epsTextField.setText("");
        diseaseTextField.setText("");
    }

    @FXML
    void addPacientToMedicButtonClick(ActionEvent event) {
        Medico md = medicList.getSelectionModel().getSelectedItem();
        md.addPaciente(pIDTextField.getText());
        pIDTextField.setText("");
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
                textArea2.setText(textArea2.getText() + px.getNombre() + " " + px.getCedula() + "\n");
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
        String datitos = textArea1.getText().strip();
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
        textArea2.setText(textArea2.getText() + String.format("%.2f", prom) + "\n");

        arribaProm(datos, prom);
        contEnfermedades(datos, contEnf);

        for (int i = 0; i < 6; i++) {
            System.out.println(enfermedades[i] + " " + contEnf[i]);
            textArea2.setText(textArea2.getText() + enfermedades[i] + " " + contEnf[i] + "\n");
        }

        for (Paciente px : datos) {
            if (px.clasificarEdad().equalsIgnoreCase("joven adulto")) {
                System.out.println(px.getNombre() + " " + px.getCedula());
                textArea2.setText(textArea2.getText() + px.getNombre() + " " + px.getCedula() + "\n");
            }
        }
    }

}
