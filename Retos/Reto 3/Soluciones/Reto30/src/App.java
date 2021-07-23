import javafx.stage.Stage;             // |
import javafx.scene.Group;             // |\ Librerías necesarias
import javafx.scene.Parent;
import javafx.scene.Scene;             // |/ Para el ejemplo
import javafx.application.Application; // |
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;    // |

public class App extends Application {

	public static void main(String[] args) {
		//Esto se utiliza para ejecutar la aplicación 
		//es como el new Contructor();
		launch(args);
	}

	//Este metodo es obligatorio
	public void start(Stage primaryStage) throws Exception {
        //FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ruta absoluta del archivo fxml a mostrar")); 
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("layout.fxml")); 
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Reto Grupo 30");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}