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
            Double.parseDouble(linea[3]), Double.parseDouble(linea[4]), Double.parseDouble(linea[5]);
        }

        String pacM1 = "", pacM2 = "", pacM3 = "";
        double mM1 = 0, mM2 = 0, mM3 = 0;
        for (int i = 0; i < n; i++) {
            System.out.println((i + 1));
            int ptpp = 0;

            Paciente actual = datos[i];

            ptpp += actual.getPuntajeParcial(1);
            ptpp += actual.getPuntajeParcial(2);
            ptpp += actual.getPuntajeParcial(3);

            

            System.out.println(ptpp);
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
                    System.out.println("Alto");
                    break;
            }

            puntaje[i] = ptpp;
            double m1 = actual.getMuestra1();
            double m2 = actual.getMuestra2();
            double m3 = actual.getMuestra3();
            

            if (m1 >= m2 && m1 >= m3) {
                System.out.println("1");
            }

            if (m2 >= m1 && m2 >= m3) {
                System.out.println("2");
            }

            if (m3 >= m1 && m3 >= m2) {
                System.out.println("3");
            }

            if (m1 > mM1) {
                mM1 = m1;
                pacM1 = actual.getNombre();
            }

            if (m2 > mM2) {
                mM2 = m2;
                pacM2 = actual.getNombre();
            }

            if (m3 > mM3) {
                mM3 = m3;
                pacM3 = actual.getNombre();
            }

        }

        System.out.println(pacM1);
        System.out.println(pacM2);
        System.out.println(pacM3);
    }

}
