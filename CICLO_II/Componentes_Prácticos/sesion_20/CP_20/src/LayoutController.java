import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class LayoutController {

    @FXML
    private TextField nombreInstructor;

    @FXML
    private TextField apellidoInstructor;

    @FXML
    private TextField idInstructor;

    @FXML
    private TextField emailInstructor;

    @FXML
    private Button createButton;

    @FXML
    private Button updateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextArea listadoInstructores;

    @FXML
    private TextArea listadoTripulantes;

    @FXML
    private TextField nombreTripulante;

    @FXML
    private TextField apellidoTripulante;

    @FXML
    private TextField idTripulante;

    @FXML
    private TextField edadTripulante;

    @FXML
    private ChoiceBox<String> selectCursoTripulante;

    @FXML
    private ChoiceBox<String> selectCursoInstructor;

    @FXML
    private Button createButton1;

    @FXML
    private Button updateButton1;

    @FXML
    private Button deleteButton1;

    @FXML
    private Button clearButton1;

    @FXML
    private TextField nombreCurso;

    @FXML
    private ChoiceBox<String> selectHorario;

    @FXML
    private ChoiceBox<String> selectInstructor;

    @FXML
    private Button clearButton2;

    @FXML
    private Button buttonCrearCurso;

    @FXML
    private TextArea listadoCursos;

    @FXML
    private Label result1;

    @FXML
    private Label result2;

    @FXML
    private Label result3;

    @FXML
    private void initialize() {
        selectHorario.setItems(Horario.selectHorarios());
        selectCursoTripulante.setItems(Curso.selectCursos());
        selectInstructor.setItems(Persona.selectPersonas(2));
        selectCursoInstructor.setItems(Curso.selectCursos());
        listarTripulantes();
        listarInstructores();
        listarCursos();
    }

    @FXML
    private void updateListados() {
        listarTripulantes();
        listarInstructores();
        listarCursos();
    }

    private void listarTripulantes() {
        listadoTripulantes.setEditable(false);
        String elementos = Persona.listaPersonas(1);
        listadoTripulantes.setText(elementos);
    }

    private void listarInstructores() {
        listadoInstructores.setEditable(false);
        String elementos = Persona.listaPersonas(2);
        listadoInstructores.setText(elementos);
    }

    private void listarCursos() {
        listadoCursos.setEditable(false);
        String elementos = Curso.listaCursos();
        listadoCursos.setText(elementos);
    }

    @FXML
    void clearFormCurso(ActionEvent event) {
        nombreCurso.setText("");
        selectHorario.setValue("");
        selectInstructor.setValue("");
    }

    @FXML
    void clearFormInstructor(ActionEvent event) {
        idInstructor.setText("");
        nombreInstructor.setText("");
        apellidoInstructor.setText("");
        emailInstructor.setText("");
        result1.setText("");
    }

    @FXML
    void clearFormTripulante(ActionEvent event) {
        idTripulante.setText("");
        nombreTripulante.setText("");
        apellidoTripulante.setText("");
        edadTripulante.setText("");
        result2.setText("");
    }

    int obtenerLlaveSelect(String cadena) {
        String[] parts = cadena.split("-");
        String ultima = parts[parts.length - 2];
        return Integer.parseInt(ultima);
    }

    @FXML
    void createCurso(ActionEvent event) {
        String nombre = nombreCurso.getText();
        String instructor = selectInstructor.getValue();
        String horario = selectHorario.getValue();
        result3.setText(Curso.createCurso(nombre, obtenerLlaveSelect(instructor), obtenerLlaveSelect(horario)));
        updateListados();
    }

    @FXML
    void createInstructor(ActionEvent event) {
        int identificacion = Integer.parseInt(idInstructor.getText());
        String nombre = nombreInstructor.getText();
        String apellido = apellidoInstructor.getText();
        String email = emailInstructor.getText();
        String curso = selectCursoInstructor.getValue();
        result1.setText(Persona.createInstructor(identificacion, nombre, apellido, email, obtenerLlaveSelect(curso)));
        updateListados();
    }

    @FXML
    void createTripulante(ActionEvent event) {
        int identificacion = Integer.parseInt(idTripulante.getText());
        String nombre = nombreTripulante.getText();
        String apellido = apellidoTripulante.getText();
        int edad = Integer.parseInt(edadTripulante.getText());
        String curso = selectCursoTripulante.getValue();
        result2.setText(Persona.createTripulante(identificacion, nombre, apellido, edad, obtenerLlaveSelect(curso)));
        updateListados();
    }

    @FXML
    void updateInstructor(ActionEvent event) {
        int identificacion = Integer.parseInt(idInstructor.getText());
        String nombre = nombreInstructor.getText();
        String apellido = apellidoInstructor.getText();
        String email = emailInstructor.getText();
        String curso = selectCursoInstructor.getValue();
        result1.setText(Persona.updateInstructor(identificacion, nombre, apellido, email, obtenerLlaveSelect(curso)));
        updateListados();
    }

    @FXML
    void updateTripulante(ActionEvent event) {
        int identificacion = Integer.parseInt(idTripulante.getText());
        String nombre = nombreTripulante.getText();
        String apellido = apellidoTripulante.getText();
        int edad = Integer.parseInt(edadTripulante.getText());
        result2.setText(Persona.updateTripulante(identificacion, nombre, apellido, edad));
        updateListados();
    }

    @FXML
    void deleteInstructor(ActionEvent event) {
        int identificacion = Integer.parseInt(idInstructor.getText());
        result1.setText(Persona.deleteInstructor(identificacion));
        updateListados();
    }

    @FXML
    void deleteTripulante(ActionEvent event) {
        int identificacion = Integer.parseInt(idTripulante.getText());
        result2.setText(Persona.deleteTripulante(identificacion));
        updateListados();
    }

}
