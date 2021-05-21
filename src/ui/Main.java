package ui;


import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.*; 



public class Main extends Application {
    
	private TiendaMonarca  TiendaMonarca;
	private TiendaMonarcaGUI TiendaMonarcaGUI;
    

    public Main() throws ClassNotFoundException, IOException {
            TiendaMonarca = new TiendaMonarca();
           TiendaMonarcaGUI = new TiendaMonarcaGUI(TiendaMonarca);
        
    }

    public static void main(String [] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Welcome.fxml"));

		fxmlLoader.setController(TiendaMonarcaGUI);
		Parent root = fxmlLoader.load();
        Image icon= new Image("/img/circle-cropped.png");
        primaryStage.getIcons().add(icon);
		Scene scene = new Scene(root);

        scene.getStylesheets().add("/styles/styles.css");

		primaryStage.setScene(scene);
		primaryStage.setTitle("Tienda Monarca");
		primaryStage.show();

    }

	



}
