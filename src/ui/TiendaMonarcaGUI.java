package ui;

import java.awt.TextField;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import model.TiendaMonarca;
import threads.Clock;
import threads.Loading;
import threads.Percentage;

public class TiendaMonarcaGUI {
	@FXML
	private Label clockLabel;

	@FXML
	private BorderPane pane;
	@FXML
	private Text labelUser;
	@FXML
	private MenuItem labelLoginOrLogOut;
	@FXML
	private ProgressBar jProgressbar1;

	@FXML
	private ProgressIndicator prgres1;
	private TiendaMonarca tiendaMonarca;

	public TiendaMonarcaGUI(TiendaMonarca tiendaMonarca2) {
		tiendaMonarca = tiendaMonarca2;
	}

	// ________________________________________________________

	@FXML
	public void InitProgram(ActionEvent event) throws IOException, InterruptedException {
		Loading ld = new Loading(this, jProgressbar1);
		Percentage pc = new Percentage(prgres1);
		ld.start();
		pc.start();
		// ld.join();
	

	}
	@FXML
	private BorderPane white;
	@FXML
	private TextField txtUser;
	 @FXML
	    private Label date;
	public void loadMenu() throws IOException {
		
		 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
	        fxmlLoader.setController(this);
	        Parent login = fxmlLoader.load();
	        // pane.getChildren().clear();
	        Clock clock = new Clock(clockLabel);
			clock.start();
			Calendar fecha = new GregorianCalendar();
			String anio = fecha.get(Calendar.YEAR)+"";
	        int mes = fecha.get(Calendar.MONTH)+1;
	        String dia = fecha.get(Calendar.DAY_OF_MONTH)+"";
	        String f = dia+"/"+mes+"/"+anio;
			date.setText(f);
	        pane.setCenter(login);
	}
	

}
