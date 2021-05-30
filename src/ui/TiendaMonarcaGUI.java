package ui;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import model.Customer;
import model.EmployeUser;
import model.TiendaMonarca;
import threads.Clock;
import threads.Loading;
import threads.Percentage;
// CLIENTES ----- DEUDORES-->   - CLIENTES---->
//-------------------------------------------------

//EMPLEADOS----  
//PROVEEDORES -----
//PRODUCTOS----
public class TiendaMonarcaGUI {
	private EmployeUser first;
	private Customer firstC;
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
	@FXML
	private TextField createUserFN;

	@FXML
	private TextField createUserLN;

	@FXML
	private TextField createUserId;

	@FXML
	private TextField createUserUS;

	@FXML
	private PasswordField createUserPA;

	public TiendaMonarcaGUI() {
		tiendaMonarca = new TiendaMonarca();
		if(first==null) {
			first = new  EmployeUser("admin", "admin", "admin", "admin", "123");
		}
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

	@FXML
	void buttonRegister(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateUser.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	@FXML
	void addUser(ActionEvent event) {

	}

	@FXML
	void loadWelcome(ActionEvent event) {

	}
}
