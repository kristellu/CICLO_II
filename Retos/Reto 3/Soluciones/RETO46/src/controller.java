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
    private Button addDataButton;

    @FXML
    private TextField nameTextField;

    @FXML
    private Label idLabel;

    @FXML
    private TextField idTextField;

    @FXML
    private Label genreLabel;

    @FXML
    private TextField genreTextField;

    @FXML
    private Label nauseaLabel;

    @FXML
    private TextField nauseasTextField;

    @FXML
    private Label vomitLabel;

    @FXML
    private TextField vomitTextField;

    @FXML
    private Label abPainLabel;

    @FXML
    private TextField abPainTextField;

    @FXML
    private Label diarrheaLabel;

    @FXML
    private TextField diarrheaTextField;

    @FXML
    private Label feverLabel;

    @FXML
    private TextField feverTextField;

    @FXML
    private Button processButton;

    @FXML
    private TextArea richTextField1;

    @FXML
    private TextArea richTextField2;

    @FXML
    void clickDataButton(ActionEvent event) {
        String s = String.join("-", nameTextField.getText(),
                                    idTextField.getText(),
                                    genreTextField.getText(),
                                    nauseasTextField.getText(),
                                    vomitTextField.getText(),
                                    abPainTextField.getText(),
                                    diarrheaTextField.getText(),
                                    feverTextField.getText());
        //System.out.println(s);
        richTextField1.setText(richTextField1.getText() + s + "\n");
        nameTextField.setText("");
        idTextField.setText("");
        genreTextField.setText("");
        nauseasTextField.setText("");
        vomitTextField.setText("");
        abPainTextField.setText("");
        diarrheaTextField.setText("");
        feverTextField.setText("");
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
    void contarCiudades(Paciente[] pxs) {
        String[] visitadas = new String[pxs.length];
        int pos = 0;
        for (int i = 0; i < pxs.length; i++) visitadas[i] = "";
        for (Paciente px : pxs) {
            if(buscarElem(visitadas, px.getCiudad()) == false) {
                visitadas[pos] = px.getCiudad();
                pos += 1;
            }
        }

        int[] cont = new int[pos];
        for (int i = 0; i < pos; i++) {
            for (Paciente px : pxs) {
                if (visitadas[i].equals(px.getCiudad())) {
                    cont[i] += 1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < cont.length; i++) {
            if (cont[i] < min) min = cont[i];
            System.out.println(visitadas[i] + " " + cont[i]);
            richTextField2.setText(richTextField2.getText() + visitadas[i] + " " + cont[i] + "\n");
        }
        for (int i = 0; i < cont.length; i++) {
            if (cont[i] == min) {
                System.out.println(visitadas[i]);
                richTextField2.setText(richTextField2.getText() + visitadas[i] + "\n");
                break;
            }
        }
    }

    @FXML
    void clickProcessButton(ActionEvent event) {
        String datitos = richTextField1.getText().strip();
        String[] pacientes = datitos.split("\n");
        Paciente datos[] = new Paciente[pacientes.length];

        for (int i = 0; i < pacientes.length; i++) {
            String[] temp = pacientes[i].split("-");
            Paciente px = new Paciente(temp[0], temp[1], Integer.parseInt(temp[2]), temp[3], temp[4], temp[5]);
            datos[i] = px;
        }

        contarCiudades(datos);

        for (Paciente px : datos) {
            if(px.clasificarEdad().equalsIgnoreCase("tercera edad")) {
                richTextField2.setText(richTextField2.getText() + px.getNombre() + " " + px.getCedula() + "\n");
            }
        }

    }

}
