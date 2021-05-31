package ui;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
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
		
		if(createUserFN.getText().equals("")&&createUserId.getText().equals("")&&
				createUserLN.getText().equals("")&&createUserPA.getText().equals("")&&
				createUserUS.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
			
		}else {
			
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
    void addProveedores(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Type_Proovedores.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
    }

    @FXML
    void addSale(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Sale.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
    }

    @FXML
    void creatClient(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addCustumer.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		typeClient.getItems().addAll("Ti", "CC", "Pasaporte");
		typeClient.setValue("Ti");
		pane.setCenter(login1);
    }
    @FXML
    void addClient(ActionEvent event) throws IOException {
    	String nameC = nameClien.getText();
    	String idCl = idClient.getText();
    	String pho = phoneClient.getText();
    	String type = typeClient.getValue().toString();
    	if(nameC.equals("")||idCl.equals("")||pho.equals("")) {
    		JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
    		
    	}else {
    		JOptionPane.showMessageDialog(null, "Ha creado un cliente", "Felicitaciones",
					JOptionPane.WARNING_MESSAGE);
    		tiendaMonarca.creatClient(nameC,idCl,pho,type);
    		loadMenu();
    	}
    }

    @FXML
    void returnClient(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		fxmlLoader.setController(this);
		Parent login = fxmlLoader.load();
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
    void debtors(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Debtors.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
    }

    @FXML
    void viewStock(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stocktaking.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
    }
    @FXML
    void addProducts(ActionEvent event) {
    	//metodo para añadir productos
    }

    @FXML
    void returnProduct(ActionEvent event) throws IOException {
    	loadMenu();
    }
    @FXML
    void proovedConta(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addProovedores_contado.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
    }

    @FXML
    void prooverdCred(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addProovedores_credit.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
    }

    @FXML
    void returnPro(ActionEvent event) throws IOException {
    	loadMenu();
    }
    @FXML
    void addSaveProvConta(ActionEvent event) {

    }

    @FXML
    void returnConta(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Type_Proovedores.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
    }
    @FXML
    void addProveCredi(ActionEvent event) {

    }

    @FXML
    void returnCredit(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Type_Proovedores.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
    }
    @FXML
    private Label labelCustomer1;

    @FXML
    private Label labelCustomer11;
    @FXML
    private TextField nameClien;

    @FXML
    private TextField idClient;

    @FXML
    private TextField phoneClient;

    @FXML
    private ChoiceBox<String> typeClient;


    @FXML
    void binarySearchCustomer(ActionEvent event) {

    }

    @FXML
    void retunrPay(ActionEvent event) throws IOException {
    	FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		fxmlLoader.setController(this);
		Parent login = fxmlLoader.load();
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
    void savePay(ActionEvent event) {

    }
    @FXML
    void returnStock(ActionEvent event) throws IOException {
    	loadMenu();
    }

}
