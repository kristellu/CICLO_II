import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controlador {

    @FXML
    private Button ingresar;

    @FXML
    private TextField nombre;

    @FXML
    private TextField cedula;

    @FXML
    private TextField genero;

    @FXML
    private TextField muestra2;

    @FXML
    private TextArea entrada;

    @FXML
    private Button procesar;

    @FXML
    private TextArea salida;

    @FXML
    private TextField muestra1;

    @FXML
    private TextField muestra3;

    int n;
    Paciente datos[] = new Paciente[100];
    int puntaje[] = new int[100];

    @FXML
    void clicIngresar(ActionEvent event) {
        String s = String.join("-", nombre.getText(),
        cedula.getText(),
        genero.getText(),
        muestra1.getText(),
        muestra2.getText(),
        muestra3.getText());
        entrada.setText(entrada.getText() + s + "\n");

    }

    @FXML
    void clicProcesar(ActionEvent event) {
        principal();
    }

    void principal(){
        // TODO code application logic here
        int n;
        Paciente datos[] = new Paciente[100];
        int puntaje[] = new int[100];
        
        String[] data = entrada.getText().split("\n");
        for (int i = 0; i < data.length; i++) {
            String[] linea = data[i].split("-");
            datos[i] = new Paciente(linea[0], linea[1], linea[2], 
            Double.parseDouble(linea[3]), Double.parseDouble(linea[4]), Double.parseDouble(linea[5]));
        }

        n = datos.length;
        String nomM="";
        double creM=-1000;

        for (int i = 0; i < n; i++) {
            System.out.println((i+1));
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
            System.out.println(ptpp);
            puntaje[i] = ptpp;
            
            switch (ptpp) {
                case 0:
                    System.out.println("Sin Riesgo");
                    break;
                case 5:
                    System.out.println("Bajo");
                    break;
                case 10:
                    System.out.println("Medio");
                    break;
                case 15:
                    System.out.println("Alto");
                    break;
            }
            
            puntaje[i] = ptpp;
            System.out.println(numMPD);
            System.out.println(numM);
            
        }
        System.out.println(nomM);
    }

}
