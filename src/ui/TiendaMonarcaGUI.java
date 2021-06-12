package ui;


import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import model.Clients;
import model.Debtors;
import model.Product;
import model.Provider;
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
	// -------------------------------
	// PRODUCTO TECNOLOGIA
	@FXML
	private TextField nameProdTec;

	@FXML
	private TextField preciProdutTec;

	@FXML
	private TextField cuantityProdutTec;

	@FXML
	private TableView<Provider> tableProductTec;

	@FXML
	private TableColumn<Provider, String> idProductTec;

	@FXML
	private TableColumn<Provider, String> proveedorProductTec;

	@FXML
	private TextField idProovedortec;

	@FXML
	private TextField pricesProducTec;

	@FXML
	private ComboBox<String> choiseProduTec;

	@FXML
	private TextField brandTec;

	@FXML
	private TextField capacityTec;

	// -------------------------------
	// PROVEDOR CONTADO
	@FXML
	private TextField nameProvConta;

	@FXML
	private TextField telProveConta;

	@FXML
	private TextField adressProveConta;

	@FXML
	private TextField numProveConta;
	@FXML
	private TextField idProveConta;

	// ------------------------------
	// PROVEEDOR CREDITO
	@FXML
	private TextField nameProvedCredit;

	@FXML
	private TextField telProvedCredi;

	@FXML
	private TextField addresProvedCredi;

	@FXML
	private TextField numWeekCredit;

	// -----------------------------
	// PRODUCT
	@FXML
	private TextField nameProd;

	@FXML
	private TextField preciProdut;

	@FXML
	private TextField cuantityProdut;

	@FXML
	private TableView<Provider> tableProduct;

	@FXML
	private TableColumn<Provider, String> idProduct;

	@FXML
	private TableColumn<Provider, String> proveedorProduct;
	@FXML
	private ComboBox<String> choiseProducCos;
	@FXML
	private TextField idProovedor;
	// -----------------------------
	@FXML
	private PasswordField txtPassword;
	@FXML
	private Label date;
	@FXML
	private Label clockLabel;
	private Provider pr;
	private Product product;
	private Debtors debtor;

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
	
	

	// CREA UN PRODUCTO PRODUCTO DE TIPO TECNOLOGIA
	
	/**
	 *  create a list product <br>
	 * <b> pre: the products  </b>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addProductTecList(ActionEvent event) throws IOException {
		String brand = brandTec.getText();
		
		String type = choiseProduTec.getValue().toString();
		
		String id =idProovedortec.getText();
		String name =nameProdTec.getText();
		
		
		if (brandTec.getText().equals("") || capacityTec.getText().equals("")
				|| cuantityProdutTec.getText().equals("") || idProovedortec.getText().equals("")
				|| nameProdTec.getText().equals("")|| preciProdutTec.getText().equals("")
				|| pricesProducTec.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);

		} else {
			if(tiendaMonarca.existProvider(id)) {
				if(tiendaMonarca.existProduct(name)== false) {
				if(type.equals("COMPUTADOR")) {
					type = "COMPUTER";
				}else {
					type = "CELL";
				}
				int cuantity=0;
				int priceCom=0;
				int priceVent=0;
				int capacity=0;
				int i = 0;
				try{
					cuantity = Integer.parseInt(cuantityProdutTec.getText());
					 priceCom = Integer.parseInt(pricesProducTec.getText());
					 priceVent = Integer.parseInt(preciProdutTec.getText());
					capacity = Integer.parseInt(capacityTec.getText());
		    	}catch(NumberFormatException ex){
		    		i=1;
		        	System.out.println("Las cantidades deben ser números");
		    	}
				
				if(i==0) {
					tiendaMonarca.creatProductTech(name, priceCom, priceVent, cuantity, id, type, brand, capacity);	
					JOptionPane.showMessageDialog(null, "El producto fue creado", "Felicitaciones",
							JOptionPane.WARNING_MESSAGE);
					loadMenu();
				}
				
				}else{JOptionPane.showMessageDialog(null, "El producto existe", "Error",
						JOptionPane.WARNING_MESSAGE);
				}
				}else {
				JOptionPane.showMessageDialog(null, "El proveedor no existe", "Error",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	// RETORNAR DESDE LA PANTALLA DE CREAR PRODUCTO TECH
	/**
	 * return product <br>
	 * <b> pre: the products allowed created </b>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnProductTec(ActionEvent event) throws IOException {
	loadMenu();
	}

	// PARA PASAR A LA CREACION DE PRODUCTO TECNOLOGIA
	/**
	 * To go to the creation of product tecnology <br>
	 * <b> pre: a new tecnology product </b>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void loadCreatProdTec(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProducto_tech.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		choiseProduTec.getItems().addAll("COMPUTADOR", "CELULAR");
		choiseProduTec.setValue("COMPUTADOR");
		pane.setCenter(login1);
		printProvedProductTech();
	}
	
	/**
	 * print in the screen the technology product provider <br>
	 * <b> pre: a  tecnology product provider </b>
	 */
	public void printProvedProductTech() {
		ObservableList<Provider> observableList;
		observableList = FXCollections.observableArrayList(tiendaMonarca.getProviders());

		tableProductTec.setItems(observableList);
		idProductTec.setCellValueFactory(new PropertyValueFactory<Provider, String>("id"));
		proveedorProductTec.setCellValueFactory(new PropertyValueFactory<Provider, String>("name"));
	}

	// RETORNAR DE LA LISTA DE TECNOLOGIA
	/**
	 * return to the tecnological list  <br>
	 * <b> pre: a  tecnology product provider </b>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnListTec(ActionEvent event) throws IOException {
		loadMenu();
	}
	
	
	/**
	 * is the start button, it begins to load the threads  <br>
	 * @param event
	 * @throws IOException
	 * @throws InterruptedException
	 */
	@FXML
	public void InitProgram(ActionEvent event) throws IOException, InterruptedException {
		Loading ld = new Loading(this, jProgressbar1);
		Percentage pc = new Percentage(prgres1);
		ld.start();
		pc.start();

	}
	/**
	 * open the login window  <br>
	 * @throws IOException
	 */
	public void loadLogin() throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}
	
	
	/**
	 * open the menu window <br>
	 * @throws IOException
	 */
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

	
	/**
	 * if the username and password are correct the program opens menu <br>
	 * <b> pre: check if password and user are the same </b>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void buttonJoin(ActionEvent event) throws IOException {

		String name = txtUser.getText();
		String pasw = txtPassword.getText();
		if (txtUser.getText().equals("") || txtPassword.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
		} else {
			if (tiendaMonarca.found(name, pasw)) {
				loadMenu();
			} else {
				JOptionPane.showMessageDialog(null, "Clave o usuario incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
			}

		}
	}
	
	
	/**
	 * opens the window to add users <br>
	 * <b> pre: not have a user account </b>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addUser(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CreateUser.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}
	
	
	/**
	 * create the users and save them <br>
	 * <b> pre: not have a user account </b>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addUsers(ActionEvent event) throws IOException {
		String name = createUserFN.getText();
		String lastName = createUserLN.getText();
		String id = createUserId.getText();
		String userName = createUserUS.getText();
		String pass = createUserPA.getText();

		if (createUserFN.getText().equals("") || createUserId.getText().equals("") || createUserLN.getText().equals("")
				|| createUserPA.getText().equals("") || createUserUS.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);

		} else {

			if (tiendaMonarca.foundExistUser(userName)) {
				JOptionPane.showMessageDialog(null, "Nombre de usuario exite", "Error", JOptionPane.WARNING_MESSAGE);
			} else {
				tiendaMonarca.creatUser(name, lastName, id, userName, pass);
				JOptionPane.showMessageDialog(null, "Se creo el usuario", "Exitoso", JOptionPane.WARNING_MESSAGE);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
				fxmlLoader.setController(this);
				Parent login1 = fxmlLoader.load();
				pane.setCenter(login1);
			}
		}
	}

	
	/**
	 * open the login window  <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void loadWelcome(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Login.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}
	
	
	/**
	 * open the pay window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void abonePay(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("pay.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}
	
	
	/**
	 * open the Type_Product window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addProduct(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Type_Product.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);

	}

	// metodo para ver lista de productos comestibles
	/**
	 * see list of grocery products <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addProductComes(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Products.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
		printProductComes();

	}
	
	
	/**
	 * open technology product Window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addProductTec(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Products _tec.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
		printProductTech();

	}
	
	
	/**
	 * open edible products Window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addListComesti(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddProducto.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		choiseProducCos.getItems().addAll("BEBIDAS ALCOHOLICAS", "DULCES", "GASEOSAS", "PRODUCTOS PARA EL HOGAR");
		choiseProducCos.setValue("DULCES");
		pane.setCenter(login1);
		printProvedProduct();

	}
	
	
	/**
	 * open the menu window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnListComest(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);

	}

	
	/**
	 * open the menu window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnProType(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);

	}

	
	/**
	 * open the Type_Proovedores window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addProveedores(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Type_Proovedores.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	
	/**
	 * open the Sale window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addSale(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Sale.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	
	/**
	 * open the Custumer window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void creatClient(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Custumer.fxml"));

		fxmlLoader.setController(this);

		Parent login1 = fxmlLoader.load();

		pane.setCenter(login1);
		PrintClient();
	}
	
	
	
	/**
	 * to create a new customer <br>
	 * <b> pre: that all processes and fields are filled correctly </b>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addClient(ActionEvent event) throws IOException {
		String nameC = nameClien.getText();
		String idCl = idClient.getText();
		String pho = phoneClient.getText();
		String type = typeClient.getValue().toString();
		String lastName = lastNamecli.getText();
		if (nameC.equals("") || idCl.equals("") || pho.equals("")||lastName.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);

		} else {
			if(tiendaMonarca.foundClient(idCl)==false) {
			JOptionPane.showMessageDialog(null, "Ha creado un cliente", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
			tiendaMonarca.creatClient(nameC,lastName, idCl, pho, type);
			tiendaMonarca.addClients(nameC,lastName, idCl, pho, type);
			loadMenu();
			}else {
				JOptionPane.showMessageDialog(null, "Ya hay un cliente con ese id", "Error", JOptionPane.WARNING_MESSAGE);
				idClient.setText("");
			}
		}
	}
    @FXML
    private TextField lastNamecli;
	
	
	/**
	 * open the menu window <br>
	 * @param event
	 * @throws IOException
	 */
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

	
	
	/**
	 * open the Debtors window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void debtors(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Debtors.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	
	/**
	 * open the stocktaking window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void viewStock(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("stocktaking.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
		printInvent();
	}

	
	
	/**
	 * open the menu window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnProduct(ActionEvent event) throws IOException {
		loadMenu();
	}

	
	
	/**
	 * open the addProovedores_contado window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void proovedConta(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addProovedores_contado.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	
	/**
	 * open the addProovedores_credit window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void prooverdCred(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addProovedores_credit.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	
	
	/**
	 * open the menu window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnPro(ActionEvent event) throws IOException {
		loadMenu();
	}

	// LISTA PROVEDORES PRODUCTO
	
	/**
	 *  provider product list<br>
	 */
	public void printProvedProduct() {
		ObservableList<Provider> observableList;
		observableList = FXCollections.observableArrayList(tiendaMonarca.getProviders());

		tableProduct.setItems(observableList);
		idProduct.setCellValueFactory(new PropertyValueFactory<Provider, String>("id"));
		proveedorProduct.setCellValueFactory(new PropertyValueFactory<Provider, String>("name"));
	}

	// GUARDA PROVEDOR CONTADO
	
	/**
	 * save  provider count <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addSaveProvConta(ActionEvent event) throws IOException {
		String name = nameProvConta.getText();
		String tel = telProveConta.getText();
		String adress = adressProveConta.getText();
		String num = numProveConta.getText();
		String id = idProveConta.getText();
		if (nameProvConta.getText().equals("") || telProveConta.getText().equals("")
				|| adressProveConta.getText().equals("") || numProveConta.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);

		} else {
			if (tiendaMonarca.existProvider(id)) {

				JOptionPane.showMessageDialog(null, "Ya hay un proovedor con esos datos", "Error",
						JOptionPane.WARNING_MESSAGE);
			} else {
				tiendaMonarca.addProovider(name, tel, adress, id, num);
				JOptionPane.showMessageDialog(null, "Ha creado un proovedor", "Felicitaciones",
						JOptionPane.WARNING_MESSAGE);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Type_Proovedores.fxml"));
				fxmlLoader.setController(this);
				Parent login1 = fxmlLoader.load();
				pane.setCenter(login1);
			}
		}
	}
	
	
	
	
	/**
	 * open Type_Proovedores windows <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnConta(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Type_Proovedores.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	@FXML
	private TextField idProvedCredi;

	// METODO PARA AGREGAR PROVEDOR A CREDITO
	
	/**
	 * Add suppliers on credit <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addProveCredi(ActionEvent event) throws IOException {
		String name = nameProvedCredit.getText();
		String tel = telProvedCredi.getText();
		String addres = addresProvedCredi.getText();
		String id = idProvedCredi.getText();
		if (nameProvedCredit.getText().equals("") || telProvedCredi.getText().equals("")
				|| addresProvedCredi.getText().equals("") || numWeekCredit.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);

		} else {
			if (tiendaMonarca.existProvider(id)) {

				JOptionPane.showMessageDialog(null, "Ya hay un proovedor con esos datos", "Error",
						JOptionPane.WARNING_MESSAGE);
			} else {
				int num = Integer.parseInt(numWeekCredit.getText());
				tiendaMonarca.addProovider(name, tel, addres, id, num);
				JOptionPane.showMessageDialog(null, "Ha creado un proovedor", "Felicitaciones",
						JOptionPane.WARNING_MESSAGE);
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Type_Proovedores.fxml"));
				fxmlLoader.setController(this);
				Parent login1 = fxmlLoader.load();
				pane.setCenter(login1);
			}
		}
	}

	
	/**
	 * open Type_Proovedores window <br> 
	 */
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

	
	/**
	 * open menu window <br> 
	 * @param event
	 * @throws IOException
	 */
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
	
	/**
	 * open menu window <br> 
	 * @param event
	 * @throws IOException
	 */
	void returnStock(ActionEvent event) throws IOException {
		loadMenu();
	}
	
	

	/**
	 * open Type_sale window <br> 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addVent(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Type_sale.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}
	
	/**
	 * open menu window <br> 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnVen(ActionEvent event) throws IOException {
		loadMenu();
	}

	
	/**
	 * open AddVenta_credit Window <br> 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void buttonVenFia(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddVenta-credit.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	
	/**
	 * open AddVenta_conta Window <br> 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void buttonVentCont(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddVenta-conta.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	/**
	 * open menu window <br> 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void buttonventCancel(ActionEvent event) throws IOException {
		loadMenu();
	}

	@FXML
	private Label labelCustomer112;

	
	/**
	 * open menu window <br> 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void returnventCred(ActionEvent event) throws IOException {
		loadMenu();
	}

	
	/**
	 * open menu window <br> 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void retunrVentCon(ActionEvent event) throws IOException {
		loadMenu();
	}

	
	/**
	 * @return product
	 */
	public Product getProduct() {
		return product;
	}

	
	/**
	 * @param product
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	public Provider getPr() {
		return pr;
	}

	public void setPr(Provider pr) {
		this.pr = pr;
	}

	public Debtors getDebtor() {
		return debtor;
	}

	public void setDebtor(Debtors debtor) {
		this.debtor = debtor;
	}

	@FXML
	private TableView<Clients> tableClient;

	@FXML
	private TableColumn<Clients, String> nameClientTab;

	@FXML
	private TableColumn<Clients, String> idClientTab;

	@FXML
	private TableColumn<Clients, String> addresClietTab;

	@FXML
	private TableColumn<Clients, String> phoneClientTab;
	
	
	
	
	/**
	 * Print customer list <br> 
	 */
	public void PrintClient() {
		if (tiendaMonarca.validClient() == true) {
			ObservableList<Clients> observableList;
			observableList = FXCollections.observableArrayList(tiendaMonarca.getClients());

			tableClient.setItems(observableList);
			nameClientTab.setCellValueFactory(new PropertyValueFactory<Clients, String>("name"));
			idClientTab.setCellValueFactory(new PropertyValueFactory<Clients, String>("id"));
			// addresClietTab.setCellValueFactory(new PropertyValueFactory<Clients,
			// String>("nameProduct"));
			// phoneClientTab.setCellValueFactory(new PropertyValueFactory<Clients,
			// String>("nameProduct"));
		}
	}

	
	/**
	 * open addCustumer window <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void nextClient(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("addCustumer.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		typeClient.getItems().addAll("Ti", "CC", "Pasaporte");
		typeClient.setValue("Ti");
		pane.setCenter(login1);
	}

	@FXML
	void returnClientList(ActionEvent event) throws IOException {
		loadMenu();
	}

	@FXML
	void cancelDebstor(ActionEvent event) throws IOException {
		loadMenu();
	}
	
	//BinarySearch Customer

   /* @FXML
    public void binarySearchCustomer(ActionEvent event) throws InterruptedException {

        long init = System.currentTimeMillis();
         
        Thread.sleep(2000);
         
        String [] name=nameCustomer.getText().split(" ");
        orderCustomer=laCasaDorada.binarySearchCustomer(name[0], name[1]);
        long end = System.currentTimeMillis();
         
        double tiempo = (double) (end - init);

        labelTimeBSCustomer.setText(tiempo +" Milisegundos");

        if (orderCustomer!=null){
            labelCustomer.setText(orderCustomer.toString());
        }

    }*/
	
	/*// Customer finder

    @FXML
    public void loadCustomerFinder(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CustomerFinder.fxml"));
        fxmlLoader.setController(this);
        Parent form = fxmlLoader.load();
        // pane.getChildren().clear();
        pane.setCenter(form);
        initializeTableViewCustomers();

        ObservableList<Customer> observableList;
        observableList = FXCollections.observableArrayList(laCasaDorada.getCustomers())
                .filtered(customer -> customer.isAvailability() == true);

        // Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Customer> filteredData = new FilteredList<>(observableList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (customer.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (customer.getLastName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (customer.getId().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(customer.getPhone()).indexOf(lowerCaseFilter) != -1)
                    return true;
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Customer> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableCustomers.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableCustomers.setItems(sortedData);

    }*/
	@FXML
	private TextField priceComp;

	// metodo para añadir productos
	
	/**
	 * add products <br>
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void addProducts(ActionEvent event) throws IOException {
		String name = nameProd.getText();
	
		String id = idProovedor.getText();
		if (nameProd.getText().equals("") || preciProdut.getText().equals("") || idProovedor.getText().equals("")
				|| cuantityProdut.getText().equals("") || priceComp.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);
		} else {
			int cuant = 0;
			int priceCom = 0;
			int i = 0;
			int	 price = 0;
			try {
				cuant = Integer.parseInt(cuantityProdut.getText());
				priceCom = Integer.parseInt(priceComp.getText());
				price = Integer.parseInt( preciProdut.getText());
			} catch (NumberFormatException ex) {
				i = 1;
				System.out.println("Las cantidades deben ser números");
			}
			if (i == 0) {
				if (tiendaMonarca.existProvider(id)) {
					String chos = choiseProducCos.getValue().toString();
					if(tiendaMonarca.existProduct(name)) {
						JOptionPane.showMessageDialog(null, "El producto existe", "Error", JOptionPane.WARNING_MESSAGE);
					}else {
						if(chos=="BEBIDAS ALCOHOLICAS") {
							chos ="ALCOHOLIC_DRINKS";
						}
						if(chos == "DULCES" ) {
							chos = "CANDYS";
						}if(chos == "GASEOSAS") {
							chos = "SODAS";
						}if(chos == "PRODUCTOS PARA EL HOGAR") {
							chos = "PRODUCTS_HOUSE";
						}
						tiendaMonarca.creatProductComes(name, priceCom, price, cuant, id, chos);
						JOptionPane.showMessageDialog(null, "El producto fue creado", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
						loadMenu();
					}
				} else {
					JOptionPane.showMessageDialog(null, "El proveedor no existe", "Error", JOptionPane.WARNING_MESSAGE);
				}
			} else {
				JOptionPane.showMessageDialog(null, "Cambie los valores", "Error", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
	 @FXML
	    private TableView<Product> tableProductComest;

	    @FXML
	    private TableColumn<Product, String> naemProductComes;

	    @FXML
	    private TableColumn<Product, String> priceProductComes;

	    @FXML
	    private TableColumn<Product, String> cuantityProdComes;

	    @FXML
	    private TableColumn<Product, String> proviserProductComes;
	    
	    
	    /**
	     * Print edible  products list <br>
	     */
	    public void printProductComes() {
			ObservableList<Product> observableList;
			observableList = FXCollections.observableArrayList(tiendaMonarca.getProductCom());

			tableProductComest.setItems(observableList);
			naemProductComes.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
			priceProductComes.setCellValueFactory(new PropertyValueFactory<Product, String>("valuesale"));
			cuantityProdComes.setCellValueFactory(new PropertyValueFactory<Product, String>("cuantity"));
			proviserProductComes.setCellValueFactory(new PropertyValueFactory<Product, String>("cuantity"));
		}
	    @FXML
	    private TableView<Product> tableProdTech;

	    @FXML
	    private TableColumn<Product, String> tableProductTech;

	    @FXML
	    private TableColumn<Product, String> tableTechprice;

	    @FXML
	    private TableColumn<Product, String> cuantityTech;

	    @FXML
	    private TableColumn<Product, String> proveTech;
	    
	    
	    /**
	     * Print tecnology products list <br>
	     */
	    public void printProductTech() {
			ObservableList<Product> observableList;
			observableList = FXCollections.observableArrayList(tiendaMonarca.getProductCom());

			tableProdTech.setItems(observableList);
			tableProductTech.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
			tableTechprice.setCellValueFactory(new PropertyValueFactory<Product, String>("valuesale"));
			cuantityTech.setCellValueFactory(new PropertyValueFactory<Product, String>("cuantity"));
			proveTech.setCellValueFactory(new PropertyValueFactory<Product, String>("cuantity"));
		}

	    @FXML
	    private TableView<Product> inventTable;

	    @FXML
	    private TableColumn<Product, String> nameProdInvet;

	    @FXML
	    private TableColumn<Product, String> payCompInve;

	    @FXML
	    private TableColumn<Product, String> paySaleInv;

	    @FXML
	    private TableColumn<Product, String>cuantityProductInvent;
	    
	    /**
	     * Print stocktaking list <br>
	     */
	    public void printInvent() {
			ObservableList<Product> observableList;
			observableList = FXCollections.observableArrayList(tiendaMonarca.getProductCom());

			inventTable.setItems(observableList);
			nameProdInvet.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
			payCompInve.setCellValueFactory(new PropertyValueFactory<Product, String>("valuesale"));
			paySaleInv.setCellValueFactory(new PropertyValueFactory<Product, String>("valuesale"));
			cuantityProductInvent.setCellValueFactory(new PropertyValueFactory<Product, String>("cuantity"));
		}
	    @FXML
	    void ImportData(ActionEvent event) {

	    }
}
