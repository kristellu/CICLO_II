import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.Stage;
import javafx.fxml.*;
public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception { 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layout.fxml")); 
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Calculadora Java");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}



