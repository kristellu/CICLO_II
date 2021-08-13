import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controlador {

    
    @FXML
    private TextField nombre;

    @FXML
    private TextField cedula;

    @FXML
    private TextField genero;

    @FXML
    private TextField muestra2;

    @FXML
    private TextField muestra1;

    @FXML
    private TextField muestra3;

    @FXML
    private Button ingresar;

    @FXML
    private TextArea entrada;

    @FXML
    private Button procesar;

    @FXML
    private TextArea salida;

    @FXML
    private Button obtener;

    @FXML
    private TextField nombre1;

    @FXML
    private TextField cedula1;

    @FXML
    private TextField genero1;

    @FXML
    private TextField muestra21;

    @FXML
    private TextField muestra11;

    @FXML
    private TextField muestra31;

    @FXML
    private Button consultar;

    @FXML
    private Button editar;

    @FXML
    private Button eliminar;

    
    @FXML
    void clicEditar(ActionEvent event) {
        //(String cedula, String nombre, String genero, String m1, String m2, String m3 ){
        Paciente.edditPaciente(cedula1.getText(), 
        nombre1.getText(), genero1.getText(), muestra11.getText(), 
        muestra21.getText(), muestra31.getText());
    }

    @FXML
    void clicConsultar(ActionEvent event) {
        //(String cedula, String nombre, String genero, String m1, String m2, String m3 ){
        Paciente p = Paciente.getPaciente(cedula1.getText());

        nombre1.setText(p.getNombre());
        genero1.setText(p.getGenero());
        muestra11.setText(p.getMuestra1()+"");
        muestra21.setText(p.getMuestra2()+"");
        muestra31.setText(p.getMuestra3()+"");
    }

    @FXML
    void clicEliminar(ActionEvent event) {
        //(String cedula, String nombre, String genero, String m1, String m2, String m3 ){
        Paciente.deleteEstudiante(cedula1.getText());
        nombre1.setText("");
        genero1.setText("");
        muestra11.setText("");
        muestra21.setText("");
        muestra31.setText("");
    }

    @FXML
    void clicIngresar(ActionEvent event) {
        Paciente.addPaciente(nombre.getText(), cedula.getText(), 
        genero.getText(), muestra1.getText(), muestra2.getText(), 
        muestra2.getText());
    }

    @FXML
    void clicObtener(ActionEvent event) {

        String pac = Paciente.getPacientes();

        entrada.setText(pac);

    }

    @FXML
    void clicProcesar(ActionEvent event) {

        // TODO code application logic here

        String res = "";
       
        Paciente datos[] = new Paciente[100];
        int puntaje[] = new int[100];

        
        //System.out.println("Digite el número de pacientes: ");
        String pacAll = entrada.getText();
        String[] lineas = pacAll.split("\n");
        int n = lineas.length;

        for (int i = 0; i < n; i++) {
            String[] linea = lineas[i].split("-");
            datos[i] = new Paciente(linea[0], linea[1], linea[2], 
            Double.parseDouble(linea[3]), Double.parseDouble(linea[4]), Double.parseDouble(linea[5]));
        }
        
        String nomM="";
        double creM=-1000;

        for (int i = 0; i < n; i++) {
            res+=(i+1)+"\n";
            int ptpp = 0, numMPD=0; 
            String numM="";

            Paciente pacActual = datos[i];
            
            if (pacActual.getGenero().equals("M")) {
                //Masculino
                if(pacActual.getMuestra1() < 0.74){
                    numMPD++;
                    numM+="1";
                }
            } else {
                //Femenino
                if(pacActual.getMuestra1() < 0.59){
                    numMPD++;
                    numM+="1";
                }
            }

            double m2 = pacActual.getMuestra2();
            if (pacActual.getGenero().equals("M")) {
                //Masculino
                if(m2 < 0.74){
                    numMPD++;
                    numM+=" 2";
                }
            } else {
                //Femenino
                if(m2 < 0.59){
                    numMPD++;
                    numM+=" 2";
                }
            }

            double m3 = pacActual.getMuestra3();
            if (pacActual.getGenero().equals("M")) {
                //Masculino
                if(m3 < 14){
                    numMPD++;
                    numM+=" 3";
                }
            } else {
                //Femenino
                if(m3 < 11){
                    numMPD++;
                    numM+=" 3";
                }
            }
            
            if(m3 > creM){
                creM = m3;
                nomM = pacActual.getNombre();
            }
            
            ptpp = pacActual.getPuntaje();
            res+=ptpp+"\n";
            puntaje[i] = ptpp;
            
            switch (ptpp) {
                case 0:
                res+="Sin Riesgo\n";
                    break;
                case 5:
                res+="Bajo\n";
                    break;
                case 10:
                res+="Medio\n";
                    break;
                case 15:
                res+="Alto\n";
                    break;
            }
            
            puntaje[i] = ptpp;
            res+=numMPD+"\n";
            res+=numM+"\n";
            
        }
        res+=nomM+"\n";

        salida.setText(res);

    }

}
