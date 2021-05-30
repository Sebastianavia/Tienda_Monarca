package ui;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

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
	@FXML
	private PasswordField txtPassword;
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
	void buttonJoin(ActionEvent event) throws IOException {
		
		String name = txtUser.getText();
		String pasw = txtPassword.getText();
		if (txtUser.getText().equals("") && txtPassword.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
		} else {
			if(tiendaMonarca.found(name, pasw)) {
				loadMenu();
			}else {
				JOptionPane.showMessageDialog(null, "Clave o usuario incorrecta", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
			
		}
	}

	

	@FXML
	void addUser(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateUser.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}
	@FXML
	void addUsers(ActionEvent event) throws IOException {
		String name = createUserFN.getText();
		String lastName = createUserLN.getText();
		String id = createUserId.getText();
		String userName = createUserUS.getText();
		String pass = createUserPA.getText();
		System.out.println("entra111");
		if(createUserFN.getText().equals("")&&createUserId.getText().equals("")&&
				createUserLN.getText().equals("")&&createUserPA.getText().equals("")&&
				createUserUS.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
			
		}else {
			System.out.println("entra");
			if(tiendaMonarca.foundExistUser(userName)) {
				JOptionPane.showMessageDialog(null, "Nombre de usuario exite", "Error",
						JOptionPane.WARNING_MESSAGE);
			}else {
				tiendaMonarca.creatUser(name, lastName, id, userName, pass);
				JOptionPane.showMessageDialog(null, "Se creo el usuario", "Exitoso",
						JOptionPane.WARNING_MESSAGE);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
				fxmlLoader.setController(this);
				Parent login1 = fxmlLoader.load();
				pane.setCenter(login1);
			}
		}
	}
	@FXML
	void loadWelcome(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}
	@FXML
    void abonePay(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pay.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
    }

    @FXML
    void addProduct(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProducto.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
    }

    @FXML
    void addProveedores(ActionEvent event) {
    	
    }

    @FXML
    void addSale(ActionEvent event) {

    }

    @FXML
    void creatClient(ActionEvent event) {

    }

    @FXML
    void debtors(ActionEvent event) {

    }

    @FXML
    void viewStock(ActionEvent event) {

    }
}
