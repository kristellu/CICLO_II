import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controlador {

    static double[][] gradingScale0 = {
	    {0,1},
	    {1,2.5},
	    {2.5,3,5},
	    {3.5,4.5},
	    {4.5,5}
	};
	static double[][] gradingScale1 = {
	    {0,3},
	    {3,6},
	    {6,8},
	    {8,9},
	    {9,10}
	};
	static double[][] gradingScale2 = {
	    {0,30},
	    {30,60},
	    {60,80},
	    {80,90},
	    {90,100}
	};
    static String[] subjects = {"historia", "literatura", "biologia"};
	static double[][] gradingScale = gradingScale2;
    static String[] students = { "armando", "nicolas", "daniel", "maria", "marcela", "alexandra"};
    static String[] genders = {"m", "f"};
    static private Estudiante[] data = new Estudiante[18];
    static int nEst = 0;

    @FXML
    private Button guardarBtn;

    @FXML
    private TextField nombre;

    @FXML
    private TextField genero;

    @FXML
    private TextField idNombre;

    @FXML
    private TextField idMateria;

    @FXML
    private TextField nota;

    @FXML
    private TextField materia;

    @FXML
    private TextArea entrada;

    @FXML
    private TextArea salida;

    @FXML
    private Button obtenerBtn;

    @FXML
    private Button procesar;

    @FXML
    private TextField nombre2;

    @FXML
    private TextField genero2;

    @FXML
    private TextField idNombre2;

    @FXML
    private TextField materia2;

    @FXML
    private TextField nota2;

    @FXML
    private Button consultar2;

    @FXML
    private Button eliminar;

    @FXML
    private Button editar;

    @FXML
    private TextField idMateria2;

    @FXML
    void clicConsultar2(ActionEvent event) {
        String idEstudiante = idNombre2.getText();
        String idMat = idMateria2.getText();

        Estudiante es = Estudiante.getEstudiante(idEstudiante, idMat);
        //Agregar datos a textfield de salida
        nombre2.setText(es.getNombre());
        genero2.setText(es.getGenero()+"");
        materia2.setText(es.getMateria());
        nota2.setText(es.getNota()+"");
    }

    @FXML
    void clicEditar(ActionEvent event) {

        String idEstudiante = idNombre2.getText();
        String idMat = idMateria2.getText();

        String nombre = nombre2.getText();
        String generoInt =genero2.getText();
        String materia = materia2.getText();
        String notaD = nota2.getText();        

        Estudiante.edditEstudiante(idEstudiante, idMat, generoInt, nombre, materia, notaD);

    }

    @FXML
    void clicEliminar(ActionEvent event) {

        String idEstudiante = idNombre2.getText();
        String idMat = idMateria2.getText();

        Estudiante.deleteEstudiante(idEstudiante, idMat);

        idNombre2.setText("");
        idMateria2.setText("");
        materia2.setText("");
        nombre2.setText("");
        nota2.setText("");
        genero2.setText("");

    }

    @FXML
    void clicGuardar(ActionEvent event) {

        int id = Integer.parseInt(idNombre.getText());
        int generoInt = Integer.parseInt(genero.getText());
        int idMat = Integer.parseInt(idMateria.getText());
        Double notaD = Double.parseDouble(nota.getText());        

        Estudiante.addEstudiante(id, nombre.getText(), generoInt, idMat, materia.getText(), notaD);
        
    }

    @FXML
    void clicObtener(ActionEvent event) {
        //Select * from
        
        entrada.setText(Estudiante.getEstudiantes());


    }

    @FXML
    void clicProcesar(ActionEvent event) {

        //public Estudiante(int id, String nombre, int genero, int idMateria, String materia, double nota){

        String[] datos = entrada.getText().split("\n");
        int x = 0;
        for (int i = 0; i < datos.length; i=i+1) {
            String[] line1 = datos[i].split(" ");
            int id = Integer.parseInt(line1[0]);
            String nombre = line1[1];
            int gen = Integer.parseInt(line1[2]);
            double nota = Double.parseDouble(line1[5]);
            String materia = line1[3];
            int idMat = Integer.parseInt(line1[4]);
            data[x] = new Estudiante(id, nombre, gen, idMat, materia, nota);
            x++;
        }

        nEst = x;

        String res = "";

        //Procesar de acuerdo a reto 3

        salida.setText(res);

    }

}
