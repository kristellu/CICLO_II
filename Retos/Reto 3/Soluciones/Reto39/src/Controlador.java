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

    @FXML
    private TextField muestra4;

    int n;
        Paciente[] datos = new Paciente[100];
        int puntaje[] = new int[100];

    @FXML
    void clicIngresar(ActionEvent event) {
        String s = String.join("-", nombre.getText(),
        cedula.getText(),
        genero.getText(),
        muestra1.getText(),
        muestra2.getText(),
        muestra3.getText(),
        muestra4.getText());
        entrada.setText(entrada.getText() + s + "\n");

    }

    @FXML
    void clicProcesar(ActionEvent event) {

        String[] dE = entrada.getText().split("\n");
        n = dE.length;

        for (int i = 0; i < n; i++) {
            String[] linea = dE[i].split("-");
            datos[i] = new Paciente(linea[0], linea[1], linea[2], 
            Double.parseDouble(linea[3]), Double.parseDouble(linea[4]), 
            Double.parseDouble(linea[5]), Double.parseDouble(linea[6]));
        }
        
        double mM1=1000000;
        String pacM1 = "";
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1));
            int ptpp = datos[i].getPuntaje();
            puntaje[i] = ptpp;

            switch (ptpp) {
                case 0:
                    System.out.println("Sin Riesgo");
                    break;
                case 10:
                    System.out.println("Bajo");
                    break;
                case 20:
                    System.out.println("Medio");
                    break;
                case 30:
                    System.out.println("Medio");
                    break;
                case 40:
                    System.out.println("Alto");
                    break;
            }

            puntaje[i] = ptpp;
            
            System.out.println((datos[i].getMuestra1()+datos[i].getMuestra2())/2);
            System.out.println((datos[i].getMuestra3()+datos[i].getMuestra4())/2); 
            
            if (datos[i].getMuestra1() < mM1) {
                mM1 = datos[i].getMuestra1();
                pacM1 = datos[i].getCedula();
            }
        }
        
        System.out.println(pacM1); 

    }

}
