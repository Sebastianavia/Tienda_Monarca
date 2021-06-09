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
	@FXML
	void addProductTecList(ActionEvent event) {
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
				int cuantity = Integer.parseInt(cuantityProdutTec.getText());
				int priceCom = Integer.parseInt(pricesProducTec.getText());
				int priceVent = Integer.parseInt(preciProdutTec.getText());
				int capacity = Integer.parseInt(capacityTec.getText());
				tiendaMonarca.creatProductTech(name, priceCom, priceVent, cuantity, id, type, brand, capacity);
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
	@FXML
	void returnProductTec(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	// PARA PASAR A LA CREACION DE PRODUCTO TECNOLOGIA
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

	public void printProvedProductTech() {
		ObservableList<Provider> observableList;
		observableList = FXCollections.observableArrayList(tiendaMonarca.getProviders());

		tableProductTec.setItems(observableList);
		idProductTec.setCellValueFactory(new PropertyValueFactory<Provider, String>("id"));
		proveedorProductTec.setCellValueFactory(new PropertyValueFactory<Provider, String>("name"));
	}

	// RETORNAR DE LA LISTA DE TECNOLOGIA
	@FXML
	void returnListTec(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

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
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Type_Product.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);

	}

	// metodo para ver lista de productos comestibles
	@FXML
	void addProductComes(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Products.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);

	}

	@FXML
	void addProductTec(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Products _tec.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);

	}

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

	@FXML
	void returnListComest(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);

	}

	@FXML
	void returnProType(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Menu.fxml"));
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
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Custumer.fxml"));

		fxmlLoader.setController(this);

		Parent login1 = fxmlLoader.load();

		pane.setCenter(login1);
		PrintClient();
	}

	@FXML
	void addClient(ActionEvent event) throws IOException {
		String nameC = nameClien.getText();
		String idCl = idClient.getText();
		String pho = phoneClient.getText();
		String type = typeClient.getValue().toString();
		if (nameC.equals("") || idCl.equals("") || pho.equals("")) {
			JOptionPane.showMessageDialog(null, "Debe llenar los datos solicitados", "Error",
					JOptionPane.WARNING_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(null, "Ha creado un cliente", "Felicitaciones", JOptionPane.WARNING_MESSAGE);
			tiendaMonarca.creatClient(nameC, idCl, pho, type);
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

	// metodo para añadir productos
	@FXML
	void addProducts(ActionEvent event) {
		String name = nameProd.getText();
		String price = preciProdut.getText();
		String id = idProovedor.getText();
		int cuant = Integer.parseInt(cuantityProdut.getText());

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

	// LISTA PROVEDORES PRODUCTO
	public void printProvedProduct() {
		ObservableList<Provider> observableList;
		observableList = FXCollections.observableArrayList(tiendaMonarca.getProviders());

		tableProduct.setItems(observableList);
		idProduct.setCellValueFactory(new PropertyValueFactory<Provider, String>("id"));
		proveedorProduct.setCellValueFactory(new PropertyValueFactory<Provider, String>("name"));
	}

	// GUARDA PROVEDOR CONTADO
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

	@FXML
	void addVent(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Type_sale.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	@FXML
	void returnVen(ActionEvent event) throws IOException {
		loadMenu();
	}

	@FXML
	void buttonVenFia(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddVenta-credit.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	@FXML
	void buttonVentCont(ActionEvent event) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddVenta-conta.fxml"));
		fxmlLoader.setController(this);
		Parent login1 = fxmlLoader.load();
		pane.setCenter(login1);
	}

	@FXML
	void buttonventCancel(ActionEvent event) throws IOException {
		loadMenu();
	}

	@FXML
	private Label labelCustomer112;

	@FXML
	void returnventCred(ActionEvent event) throws IOException {
		loadMenu();
	}

	@FXML
	void retunrVentCon(ActionEvent event) throws IOException {
		loadMenu();
	}

	public Product getProduct() {
		return product;
	}

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

}
