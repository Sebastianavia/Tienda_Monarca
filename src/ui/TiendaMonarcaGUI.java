package ui;

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
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import model.TiendaMonarca;
import threads.Clock;
import threads.Loading;
import threads.Percentage;

public class TiendaMonarcaGUI {

	@FXML
	private Label date;
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
	@FXML
	private PasswordField txtPasw;

	@FXML
	private TextField txtUser;

	public TiendaMonarcaGUI(TiendaMonarca tiendaMonarca2) {
		tiendaMonarca = tiendaMonarca2;
	}

	// ________________________________________________________

	@FXML
	private TextField userTxt;

	@FXML
	public void InitProgram(ActionEvent event) throws IOException, InterruptedException {
		Loading ld = new Loading(this, jProgressbar1);
		Percentage pc = new Percentage(prgres1);
		ld.start();
		pc.start();

	}

	public void loadLogin() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		// pane.getChildren().clear();
		pane.setCenter(login1);
	}

	public void loadMenu() throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		fxmlLoader.setController(this);
		Parent login = fxmlLoader.load();
		// pane.getChildren().clear();
		Clock clock = new Clock(clockLabel);
		clock.start();
		Calendar fecha = new GregorianCalendar();
		String anio = fecha.get(Calendar.YEAR) + "";
		int mes = fecha.get(Calendar.MONTH) + 1;
		String dia = fecha.get(Calendar.DAY_OF_MONTH) + "";
		String f = dia + "/" + mes + "/" + anio;
		date.setText(f);
		pane.setCenter(login);
	}
	  @FXML
	    private PasswordField txtPassword;


	@FXML
	void buttonJoin(ActionEvent event) {
		String name = txtUser.getText();
		String pasw = txtPasw.getText();
		if (name != "" && pasw != "") {
			System.out.println(name + pasw);
		} else {
			System.out.println("digite todo");
		}
	}

}
