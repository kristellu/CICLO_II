import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

public class controller {

    @FXML
    private Label mNameLabel;

    @FXML
    private TextField mNameTextField;

    @FXML
    private TextField mIDTextField;

    @FXML
    private TextField mAgeTextField;

    @FXML
    private TextField mCityTextField;

    @FXML
    private Label mIDLabel;

    @FXML
    private Label mAgeLabel;

    @FXML
    private Label mCityLabel;

    @FXML
    private Label epsLabel;

    @FXML
    private TextField epsTextField;

    @FXML
    private Label mClassficationLabel;

    @FXML
    private TextField mClassificationTextField;

    @FXML
    private Label mTreatmentLabel;

    @FXML
    private TextField mTreatmentTextField;

    @FXML
    private Button getAllMedicsButton;

    @FXML
    private Button editMedicButton;

    @FXML
    private Button deleteMedicButton;

    @FXML
    private TextField searchMIDTextField;

    @FXML
    private Label searchMIDLabel;

    @FXML
    private Button searchMedicButton;

    @FXML
    private Label pNameLabel;

    @FXML
    private Label pIDLabel;

    @FXML
    private Label pAgeLabel;

    @FXML
    private Label pCityLabel;

    @FXML
    private Label compositionLabel;

    @FXML
    private Label echogenicityLabel;

    @FXML
    private Label formLabel;

    @FXML
    private Label marginLabel;

    @FXML
    private Label echogenicFociLabel1;

    @FXML
    private Label echogenicFociLabel2;

    @FXML
    private Label echogenicFociLabel3;

    @FXML
    private Label echogenicFociLabel4;

    @FXML
    private Label noduleSizeLabel;

    @FXML
    private TextField pNameTextField;

    @FXML
    private TextField pIDTextField;

    @FXML
    private TextField pAgeTextField;

    @FXML
    private TextField pCityTextField;

    @FXML
    private TextField compositionTextField;

    @FXML
    private TextField echogenicityTextField;

    @FXML
    private TextField formTextField;

    @FXML
    private TextField marginTextField;

    @FXML
    private TextField noduleSizeTextField;

    @FXML
    private CheckBox echogenicFociCheckBox1;

    @FXML
    private CheckBox echogenicFociCheckBox2;

    @FXML
    private CheckBox echogenicFociCheckBox3;

    @FXML
    private CheckBox echogenicFociCheckBox4;

    @FXML
    private Label classificationLabel;

    @FXML
    private TextField classificationTextField;

    @FXML
    private TextField treatmentTextField;

    @FXML
    private Label treatmentLabel;

    @FXML
    private Button getResultButton;

    @FXML
    private Button addPacientButton;

    @FXML
    private Label searchPIDLabel;

    @FXML
    private TextField searchPIDTextField;

    @FXML
    private Button getAllPatientsButton;

    @FXML
    private Button searchPatientButton;

    @FXML
    private TextArea patientTextArea;

    @FXML
    private TextArea medicTextArea;

    @FXML
    void addPacientButtonClick(ActionEvent event) {
        if (classificationTextField.getText().isEmpty() || treatmentTextField.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("¡Los campos de clasificación y tratamiento no pueden estar vacios!");

            alert.showAndWait();
        } else {
            String name = pNameTextField.getText();
            String id = pIDTextField.getText();
            int age = Integer.parseInt(pAgeTextField.getText());
            String city = pCityTextField.getText();
            String composition = compositionTextField.getText();
            String echogenicity = echogenicityTextField.getText();
            String form = formTextField.getText();
            String margin = marginTextField.getText();
            boolean echogenicFoci1 = echogenicFociCheckBox1.isSelected();
            boolean echogenicFoci2 = echogenicFociCheckBox2.isSelected();
            boolean echogenicFoci3 = echogenicFociCheckBox3.isSelected();
            boolean echogenicFoci4 = echogenicFociCheckBox4.isSelected();
            float size = Float.parseFloat(noduleSizeTextField.getText());

            Patient.savePatient(name, id, age, city, composition, echogenicity, form, margin, echogenicFoci1, echogenicFoci2, echogenicFoci3, echogenicFoci4, size);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Paciente agregado");
            alert.setHeaderText(null);
            alert.setContentText("¡Paciente agregado con exito!");

            alert.showAndWait();
        }
    }

    @FXML
    void addMedicButtonClick(ActionEvent event) {
        if (mNameTextField.getText().isEmpty() || mIDTextField.getText().isEmpty() || mAgeTextField.getText().isEmpty() || mCityTextField.getText().isEmpty()
        || epsTextField.getText().isEmpty() || mClassificationTextField.getText().isEmpty() || mTreatmentTextField.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("¡Los campos de texto no pueden estar vacios!");

            alert.showAndWait();
        } else {
            try {
                String name = mNameTextField.getText(); // Aqui debe btener el texto de la variable mNameTextField
                String id = mIDTextField.getText();
                int age = Integer.parseInt(mAgeTextField.getText());
                String city = mCityTextField.getText(); // Aqui debe btener el texto de la variable mCityTextField
                String eps = epsTextField.getText();
                String classification = mClassificationTextField.getText();
                String treatment = mTreatmentTextField.getText();

                Medic.saveMedic(name, id, age, city, eps, classification, treatment); // Aqui debe enviar como parametro las variables previamente definidas

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Médico agregado");
                alert.setHeaderText(null);
                alert.setContentText("¡Médico agregado con exito!");

                alert.showAndWait();

            } catch (Exception e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("¡El campo edad debe contener un valor numérico valido!");

                alert.showAndWait();
            }
        }
    }

    @FXML
    void deleteMedicButtonClick(ActionEvent event) {
        if (searchMIDTextField.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("¡El campo de cédula se encuentra vacío!");

            alert.showAndWait();
        } else {
            Medic.deleteMedic(searchMIDTextField.getText());

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Médico eliminado");
            alert.setHeaderText(null);
            alert.setContentText("¡Se ha eliminado el médico "+ searchMIDTextField.getText() +" con exito!");

            alert.showAndWait();
        }
    }

    @FXML
    void editMedicButtonClick(ActionEvent event) {
        if (mNameTextField.getText().isEmpty() || mIDTextField.getText().isEmpty() || mAgeTextField.getText().isEmpty() || mCityTextField.getText().isEmpty()
        || epsTextField.getText().isEmpty() || mClassificationTextField.getText().isEmpty() || mTreatmentTextField.getText().isEmpty() || searchMIDTextField.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("¡Verifique que los campos de texto, incluyendo el campo de cédula, no se encuentren vacíos!");

            alert.showAndWait();
        } else {
            try {
                String name = mNameTextField.getText(); // Aqui debe btener el texto de la variable mNameTextField
                String id = mIDTextField.getText();
                int age = Integer.parseInt(mAgeTextField.getText());
                String city = mCityTextField.getText(); // Aqui debe btener el texto de la variable mCityTextField
                String eps = epsTextField.getText();
                String classification = mClassificationTextField.getText();
                String treatment = mTreatmentTextField.getText();
                String searchID = searchMIDTextField.getText();

                Medic.editMedic(searchID, name, id, age, city, eps, classification, treatment); // Aqui debe enviar como parametro las variables previamente definidas

                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Médico editado");
                alert.setHeaderText(null);
                alert.setContentText("¡Se ha editado el médico "+ searchID +" con exito!");

                alert.showAndWait();

            } catch (Exception e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("¡El campo edad debe contener un valor numérico valido!");

                alert.showAndWait();
            }
        }
    }

    @FXML
    void getAllMedicsButtonClick(ActionEvent event) {
        ArrayList<Medic> mds = new ArrayList<Medic>();
        mds = Medic.getAllMedics();
        medicTextArea.setText("");
        medicTextArea.setText("Nombre;Cedula;Edad;Ciudad;EPS;Clasificación;Tratamiento\n");
        for (Medic md : mds) {
            String line = String.join(";", md.getName(), md.getId(), String.valueOf(md.getAge()), md.getCity(), md.getEps(), md.getAlert(), md.getTreatment());
            line = line + "\n";
            medicTextArea.setText(medicTextArea.getText() + line);
        }
    }

    @FXML
    void getResultButtonClick(ActionEvent event) {
        if (pNameTextField.getText().isEmpty() || pIDTextField.getText().isEmpty() || pAgeTextField.getText().isEmpty() || pCityTextField.getText().isEmpty()
        || compositionTextField.getText().isEmpty() || echogenicityTextField.getText().isEmpty() || formTextField.getText().isEmpty() || marginTextField.getText().isEmpty()
        || noduleSizeTextField.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("¡Los campos de texto no pueden estar vacios!");

            alert.showAndWait();
        } else {
            try {
                String name = pNameTextField.getText(); // Aqui debe btener el texto de la variable pNameTextField
                String id = pIDTextField.getText();
                int age = Integer.parseInt(pAgeTextField.getText());
                String city = pCityTextField.getText(); // Aqui debe btener el texto de la variable pCityTextField
                String composition = compositionTextField.getText();
                String echogenicity = echogenicityTextField.getText();
                String form = formTextField.getText();
                String margin = marginTextField.getText(); // Aqui debe btener el texto de la variable marginTextField
                boolean echogenicFoci1 = echogenicFociCheckBox1.isSelected();
                boolean echogenicFoci2 = echogenicFociCheckBox2.isSelected();
                boolean echogenicFoci3 = echogenicFociCheckBox3.isSelected();
                boolean echogenicFoci4 = echogenicFociCheckBox4.isSelected();
                float size = Float.parseFloat(noduleSizeTextField.getText());

                Patient px = new Patient(name, id, age, city, composition, echogenicity, form, margin, echogenicFoci1, echogenicFoci2, echogenicFoci3, echogenicFoci4, size);

                classificationTextField.setText("");
                treatmentTextField.setText("");

                String classification = px.getAlert();
                classificationTextField.setText(classification);
                String treatment = px.getTreatment();
                treatmentTextField.setText(treatment); // Aqui debe asignar el tratamiento del paciente instanciado anteriormente
            } catch (Exception e) {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setTitle("ERROR");
                alert.setHeaderText(null);
                alert.setContentText("¡El campo edad o tamaño nodulo deben contener un valor numérico valido!");

                alert.showAndWait();
            }
        }
    }

    @FXML
    void searchMedicButtonClick(ActionEvent event) {
        if (searchMIDTextField.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("¡El campo cedula no puede estar vacío!");

            alert.showAndWait();
        } else {
            String searchID = searchMIDTextField.getText(); // Aqui debe obtener el texto de la variable searchMIDTextField
            Medic md = Medic.getMedic(searchID); // Aqui debe enviar como parametro el texto de la variable searchID
            medicTextArea.setText("");
            medicTextArea.setText("Nombre;Cedula;Edad;Ciudad;EPS;Clasificación;Tratamiento\n");
            String line = String.join(";", md.getName(), md.getId(), String.valueOf(md.getAge()), md.getEps(), md.getCity(), md.getAlert(), md.getTreatment());
            line = line + "\n";
            medicTextArea.setText(medicTextArea.getText() + line);
        }
    }

    @FXML
    void searchPatientButtonClick(ActionEvent event) {
        if (searchPIDTextField.getText().isEmpty()) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText(null);
            alert.setContentText("¡El campo cedula no puede estar vacío!");

            alert.showAndWait();
        } else {
            Patient px = Patient.getPatient(searchPIDTextField.getText());
            patientTextArea.setText("");
            patientTextArea.setText("Nombre;Cedula;Edad;Ciudad;Clasificación;Tratamiento\n");
            String line = String.join(";", px.getName(), px.getId(), String.valueOf(px.getAge()), px.getCity(), px.getAlert(), px.getTreatment());
            line = line + "\n";
            patientTextArea.setText(patientTextArea.getText() + line);
        }
    }

    @FXML
    void getAllPatientsButtonClick(ActionEvent event) {
        ArrayList<Patient> pxs = new ArrayList<Patient>();
        pxs = Patient.getAllPatients();
        patientTextArea.setText("");
        patientTextArea.setText("Nombre;Cedula;Edad;Ciudad;Clasificación;Tratamiento\n");
        for (Patient px : pxs) {
            String line = String.join(";", px.getName(), px.getId(), String.valueOf(px.getAge()), px.getCity(), px.getAlert(), px.getTreatment());
            line = line + "\n";
            patientTextArea.setText(patientTextArea.getText() + line);
        }
    }

}
