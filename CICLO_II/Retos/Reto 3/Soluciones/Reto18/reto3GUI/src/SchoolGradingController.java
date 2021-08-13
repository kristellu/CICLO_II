import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SchoolGradingController {

    SchoolGradingSystem sgs = new SchoolGradingSystem();

    @FXML
    private TextField inputNumber;

    @FXML
    private TextArea inputText;

    @FXML
    private TextArea outputText;

    @FXML
    private Button clcButton;

    @FXML
    void clcButtonAction(ActionEvent event) {
        sgs.loadDataGUI(inputText.getText(), Integer.parseInt(inputNumber.getText()));
        outputText.setText(sgs.getAnswers());
    }
}
