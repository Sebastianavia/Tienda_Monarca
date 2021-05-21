package ui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import model.TiendaMonarca;

public class TiendaMonarcaGUI {
	
	@FXML
    private BorderPane pane;
	@FXML
	private Text labelUser;
	@FXML
    private MenuItem labelLoginOrLogOut;
	
	//---------------------------------------
	
	

	 private TiendaMonarca TiendaMonarca;

	    public TiendaMonarcaGUI(TiendaMonarca controller) {
	        TiendaMonarca = controller;
	    }
	    
	    @FXML
	    public void InitProgram(ActionEvent event) throws IOException {
	        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
	        fxmlLoader.setController(this);
	        Parent login = fxmlLoader.load();
	        pane.getChildren().clear();
	        pane.setCenter(login);

	        labelUser.setText("Usuario");
	        labelLoginOrLogOut.setText("Login");

	    }
	    
	    


}
