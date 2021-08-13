import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController  {

    private int total = 0;
    private String operador = null;
    private int operando = 0;

    @FXML
    private Button button7;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button button4;

    @FXML
    private Button button5;

    @FXML
    private Button button6;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button buttonDiv;

    @FXML
    private Button buttonMul;

    @FXML
    private Button buttonRest;

    @FXML
    private Button buttonEqu;

    @FXML
    private Button button0;

    @FXML
    private Button buttonAdd;

    @FXML
    private TextField resultText;

    public void clear() {
        resultText.setText("0");
        operador= null;
        operando=0;
        total=0;
    }

    public void addNumber(ActionEvent event) {
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();

        if (resultText.getText().equals("0")) {
            resultText.setText(data);
        } else {
            resultText.setText(resultText.getText() + data);
        }
    }

    public void addOperator(ActionEvent event) {
        Node node = (Node) event.getSource();
        String data = (String) node.getUserData();
        operador=data;
        operando= Integer.parseInt(resultText.getText());
        resultText.setText("");
    }

    public void getTotal() {
        int numero = Integer.parseInt(resultText.getText());
        switch (operador) {
            case "+":
                total = operando + numero;
                break;
            case "-":
                total = operando - numero;
                break;
            case "x":
                total = operando * numero;
                break;
            case "/":
                total = operando / numero;
                break;
            default:
                total = numero;
                break;
        }
        resultText.setText(Integer.toString(total));
    }
    

}
