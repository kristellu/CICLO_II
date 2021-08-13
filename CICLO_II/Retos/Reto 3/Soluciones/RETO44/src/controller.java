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

    @FXML
    void enfermedadMasFrecuente(String[] enf, int[] cont) {
        int max = -1;
        for (int i = 0; i < 6; i++) {
            if (cont[i] > max) max = cont[i];
        }
        for (int i = 0; i < 6; i++) {
            if (cont[i] == max) {
                System.out.println(enf[i]);
                richTextField2.setText(richTextField2.getText() + enf[i] + "\n");
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
                richTextField2.setText(richTextField2.getText() + enf[i] + "\n");
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
                richTextField2.setText(richTextField2.getText() + visitadas[i] + "\n");
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
    void clickProcessButton(ActionEvent event) {
        String datitos = richTextField1.getText().strip();
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
                richTextField2.setText(richTextField2.getText() + px.getNombre() + " " + px.getCedula() + "\n");
            }
        }

    }

}
