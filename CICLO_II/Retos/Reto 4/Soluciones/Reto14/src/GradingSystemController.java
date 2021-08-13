import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class GradingSystemController {

    SchoolGradingSystem sgs = new  SchoolGradingSystem();

    @FXML
    private TextField nameInput;

    @FXML
    private TextField subjectInput;

    @FXML
    private TextField gradeInput;

    @FXML
    private TextField genderInput;

    @FXML
    private Button saveButton;

    @FXML
    private Button loadButton;

    @FXML
    private TextArea loadTextArea;

    @FXML
    private TextArea displayTextArea;

    @FXML
    private Button processButton;

    @FXML
    private TextField nameInputSearch;

    @FXML
    private Button searchButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextArea displayRecordsTextArea;

    @FXML
    private TextField subjectInputSearch;

    @FXML
    void deleteRecords(ActionEvent event) {
        displayRecordsTextArea.setText("");
        Connect objConexion = new Connect();
        if(nameInputSearch.getText().isEmpty() && subjectInputSearch.getText().isEmpty()){
            displayRecordsTextArea.setText("you should insert atleast one field, name or subject");
            return;
        }
        String column = "SUBJECT";
        String value = subjectInputSearch.getText();
        if(!nameInputSearch.getText().isEmpty()){
            column = "NAME";
            value = nameInputSearch.getText();
        }
        String query = "DELETE from GRADES WHERE " + column  + " = '" + value + "';";
        try (Connection conn = objConexion.connect(); PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.execute();
            displayRecordsTextArea.setText("values successfully deleted");
        } catch (SQLException e) { 
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void loadRecords(ActionEvent event) {
        loadTextArea.setText("");
        Connect objConexion = new Connect();
        
        String query = "SELECT * from GRADES;";
        try (Connection conn = objConexion.connect(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            String records = "";
            int index = 0;
            while (resultSet.next()) {
                double[] line = new double[4];
                for (int i = 1; i <= columnsNumber; i++) {
                    switch (rsmd.getColumnName(i)) {
                        case "GENDER":
                            line[1] = sgs.getIndexOf(sgs.genders, resultSet.getString(i));
                            break;
                        case "NAME":
                            line[0] = sgs.getIndexOf(sgs.students, resultSet.getString(i)) + 1.0;
                            break;
                        case "SUBJECT":
                            line[2] = sgs.getIndexOf(sgs.subjects, resultSet.getString(i)) + 1.0;
                            break;
                        case "GRADE":
                            line[3] = resultSet.getDouble(i);
                            break;
                    }
                }
                records += line[0] + " " + line[1] + " " + line[2] + " " + line[3]+ "\n";
                index++;
            }
            if(index == 0)
                loadTextArea.setText("records not found...");
            loadTextArea.setText(index  + "\n" + records);
        } catch (SQLException e) { 
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void processRecords(ActionEvent event) {
        displayTextArea.setText("");
        try{
            int n = Integer.parseInt(loadTextArea.getText().split("\n")[0]);

            sgs.loadDataGUI(loadTextArea.getText().replace( n+"\n", ""), n);
    
            displayTextArea.setText(sgs.getAnswers());
        }catch(Exception err){
            displayTextArea.setText("error while processing the information");
        }

    }

    @FXML
    void saveRecord(ActionEvent event) {

        Connect objConexion = new Connect();
        String name = nameInput.getText();
        String subject = subjectInput.getText();
        String gender = genderInput.getText();
        boolean flag = true;
        double grade = 0.0;
        try{
            grade = Double.parseDouble(gradeInput.getText());
        }catch(NumberFormatException ex) {
            flag = false;
        }
            
        if (name.isEmpty() | subject.isEmpty() | gender.isEmpty() | flag) {
            try (Connection conn = objConexion.connect(); 
            Statement stmt = conn.createStatement()) {
                stmt.executeUpdate(
                        "INSERT INTO GRADES (NAME, SUBJECT, GENDER, GRADE) VALUES ("
                                + "'" + name + "'" + "," + "'" + subject + "'" + "," + "'" + gender + "'" + 
                                "," + grade + ");");
                System.out.println("record inserted in db");
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            nameInput.setText("");
            subjectInput.setText("");
            genderInput.setText("");
            gradeInput.setText("");

        } else {
            System.out.println("error on input data couldn't write to db");
        }
    }

    @FXML
    void searchRecords(ActionEvent event) {

        displayRecordsTextArea.setText("");
        Connect objConexion = new Connect();
        if(nameInputSearch.getText().isEmpty() && subjectInputSearch.getText().isEmpty()){
            displayRecordsTextArea.setText("you should insert atleast one field, name or subject");
            return;
        }
        String column = "SUBJECT";
        String value = subjectInputSearch.getText();
        if(!nameInputSearch.getText().isEmpty()){
            column = "NAME";
            value = nameInputSearch.getText();
        }
        String query = "SELECT * from GRADES WHERE " + column  + " = '" + value + "';";
        try (Connection conn = objConexion.connect(); Statement stmt = conn.createStatement()) {
            ResultSet resultSet = stmt.executeQuery(query);
            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            String records = "";
            while (resultSet.next()) {
                for (int i = 1; i <= columnsNumber; i++) {
                    if (i > 1)
                        System.out.print(", ");
                    String columnValue = resultSet.getString(i);
                    records = records + rsmd.getColumnName(i) + ":" + " " + columnValue + "\n";
                }
                records += "-----------------------\n";
                displayRecordsTextArea.setText(records);
            }
            if(records.isEmpty())
                displayRecordsTextArea.setText("records not found...");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

}
