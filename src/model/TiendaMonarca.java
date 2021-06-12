package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import exceptions.BuysProhibitExceptions;

public class TiendaMonarca {

	public static final String CUSTOMERS_FILE_NAME = "data/customers.txt";
	public static final String Debstor_FILE_NAME = "data/debstor.bbd";
	public static final String PRODUCTS_TEC_FILE_NAME = "data/productstec.bbd";
	public static final String PROVIDER_FILE_NAME = "data/orders.bbd";
	public static final String VENTS_CONTA = "data/vents.txt";
	// Listas enlazada = clients. product
	// Arbol binario = producto . ventas contado
	private EmployeUser first;
	private Clients firstC;
	private Product product;
	private Debtors debtors;
	private SalesConta salesConta;
	private ArrayList<Provider> providers;
	private ArrayList<Product> temporal;
	private ArrayList<Integer> temporalNum;

	public ArrayList<Product> getTemporal() {
		return temporal;
	}

	public void resetTemporal() {
		int cu = temporal.size();
		while (cu > 0) {
			if (temporal.get(0) != null) {
				temporal.remove(0);
				cu--;
			}
		}
	}

	public void resetTemporalNums() {
		int cu = temporalNum.size();
		while (cu > 0) {
			if (temporalNum.get(0) != null) {
				temporalNum.remove(0);
				cu--;
			}
		}
	}

	public void setTemporal(ArrayList<Product> temporal) {
		this.temporal = temporal;
	}

	/**
	 * @return providers
	 */
	public ArrayList<Provider> getProviders() {
		return providers;
	}

	/**
	 * @param providers
	 */
	public void setProviders(ArrayList<Provider> providers) {
		this.providers = providers;
	}

	private ArrayList<SalesCredit> salesCredit;

	public TiendaMonarca() throws ClassNotFoundException, IOException {
		
		temporalNum = new ArrayList<>();
		temporal = new ArrayList<>();
		providers = new ArrayList<>();
		setSalesCredit(new ArrayList<>());
		clients = new ArrayList<>();
		if (first == null) {
			first = new EmployeUser("admin", "admin", "admin", "admin", "123");
		}
		loadData();
		loadDataVents();
		
	}

	/**
	 * check if providers exist <br>
	 * 
	 * @param id
	 * @return
	 */
	public boolean existProvider(String id) {
		boolean out = false;
		for (int i = 0; i < providers.size(); i++) {
			if (providers.get(i).getId().equals(id)) {
				out = true;
			}
		}
		return out;
	}
	/**
	 * create technology product <br>
	 * 
	 * @param name
	 * @param valuepay
	 * @param valuesale
	 * @param cuantity
	 * @param pr
	 * @param ty
	 * @param br
	 * @param cap
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void creatProductTech(String name, int valuepay, int valuesale, int cuantity, String pr, String ty,
			String br, int cap) throws FileNotFoundException, IOException {
		int pos = 0;
		for (int i = 0; i < providers.size(); i++) {
			if (providers.get(i).getName().equals(pr)) {
				pos = i;
			}
		}
		Provider pro = providers.get(pos);

		Product p = new ProductTechnology(name, valuepay, valuesale, cuantity, pro, ty, br, cap);

		if (product == null) {
			product = p;

		} else {

			creatProductTech(product, p);
		}
		saveDataProduct();
	}

	/**
	 * create a technological product if it is not registered <br>
	 * 
	 * @param product2
	 * @param p
	 */
	private void creatProductTech(Product product2, Product p) {
		if (p.getsetvaluepay() >= product2.getsetvaluepay()) {
			if (product2.getLeft() == null) {

				product2.setLeft(p);
			} else {
				creatProductTech(product2.getLeft(), p);
			}

		} else {
			if (product2.getRight() == null) {

				product2.setRight(p);
			} else {
				creatProductTech(product2.getRight(), p);
			}
		}

	}

	/**
	 * add provider <br>
	 * 
	 * @param name
	 * @param phone
	 * @param address
	 * @param id
	 * @param numAcount
	 * @return
	 * @throws IOException 
	 */
	public boolean addProovider(String name, String phone, String address, String id, String numAcount) throws IOException {
		boolean out = false;
		Provider pro = new ProviderConta(name, phone, address, id, numAcount);
		if (providers.isEmpty()) {
			providers.add(pro);
		} else {
			int i = 0;
			while (i < providers.size() && providers.get(i).getName().compareToIgnoreCase(pro.getName()) < 0) {
				i++;
			}
			providers.add(i, pro);
		}
		saveDataProviders();
		return out;
	}

	/**
	 * add provider <br>
	 * 
	 * @param name
	 * @param phone
	 * @param address
	 * @param id
	 * @param term
	 * @return
	 * @throws IOException 
	 */
	public boolean addProovider(String name, String phone, String address, String id, int term) throws IOException {
		boolean out = false;
		Provider pro = new ProviderCredit(name, phone, address, id, term);
		if (providers.isEmpty()) {
			providers.add(pro);
		} else {
			int i = 0;
			while (i < providers.size() && providers.get(i).getName().compareToIgnoreCase(pro.getName()) < 0) {
				i++;
			}
			providers.add(i, pro);
		}
		saveDataProviders();
		return out;
	}

	/**
	 * returns the existing product <br>
	 * 
	 * @param name
	 * @return
	 */
	public boolean existProduct(String name) {
		boolean out = false;
		out = existProduct(product, out, name);
		return out;
	}

	/**
	 * check if the product exists or not <br>
	 * 
	 * @param current
	 * @param out
	 * @param name
	 * @return
	 */
	private boolean existProduct(Product current, boolean out, String name) {

		if (current != null) {
			if (out != true) {

				out = existProduct(current.getLeft(), out, name);
				if (current.getName().equals(name)) {
					out = true;
				} else {
					out = existProduct(current.getRight(), out, name);
				}
			}
		}
		return out;
	}

	public boolean addProviers() {
		boolean out = false;
		return out;
	}

	public boolean addProduct(String name, int valuepay, int valuesale, int cuantity, String p) {
		boolean out = false;
		return out;
	}

	/**
	 * found <br>
	 * 
	 * @param name
	 * @param pass
	 * @return out
	 */
	public boolean found(String name, String pass) {
		boolean out = false;
		out = foundU(first, name, pass, out);
		return out;
	}

	/**
	 * search for the user and check if it exists <br>
	 * 
	 * @param em
	 * @param name
	 * @param pass
	 * @param out
	 * @return out
	 */
	private boolean foundU(EmployeUser em, String name, String pass, boolean out) {
		if (em.getNameUser().equals(name) && em.getPassword().equals(pass)) {

			out = true;
		} else {
			if (em.getNext() != null) {
				out = foundU(em.getNext(), name, pass, out);
			}
		}
		return out;
	}

	/**
	 * check if the user is created <br>
	 * 
	 * @param userN
	 * @return out
	 */
	public boolean foundExistUser(String userN) {
		boolean out = false;
		out = foundExistUser(first, userN, out);
		return out;
	}

	/**
	 * search the user <br>
	 * 
	 * @param em
	 * @param userN
	 * @param out
	 * @return out
	 */
	private boolean foundExistUser(EmployeUser em, String userN, boolean out) {
		if (out != true) {
			if (em != null) {
				if (em.getNameUser().equals(userN)) {
					out = true;
				} else {
					out = foundExistUser(em.getNext(), userN, out);

				}
			}
		}
		return out;
	}

	private ArrayList<Clients> clients;

	/**
	 * verify user <br>
	 * 
	 * @param name
	 * @param lastN
	 * @param id
	 * @param nameU
	 * @param pass
	 */
	public void creatUser(String name, String lastN, String id, String nameU, String pass) {
		boolean found = false;
		creatUser(first, name, lastN, id, nameU, pass, found);
	}

	/**
	 * create user <br>
	 * 
	 * @param user1
	 * @param name
	 * @param lastN
	 * @param id
	 * @param nameU
	 * @param pass
	 * @param found
	 */
	private void creatUser(EmployeUser user1, String name, String lastN, String id, String nameU, String pass,
			boolean found) {

		if (user1.getNext() != null) {
			creatUser(user1.getNext(), name, lastN, id, nameU, pass, found);
		} else {
			EmployeUser ls = new EmployeUser(name, lastN, id, nameU, pass);

			user1.setNext(ls);
		}

	}

	/**
	 * verify that it is not created and to create it <br>
	 * 
	 * @param nameC
	 * @param idCl
	 * @param pho
	 * @param type
	 * @throws IOException 
	 */
	public void creatClient(String nameC, String lst, String idCl, String pho, String type) throws IOException {
		if (firstC == null) {

			firstC = new Clients(nameC, lst, idCl, pho, type);

		} else {
			boolean found = false;
			creatClient(firstC, nameC, lst, idCl, pho, type, found);
		}
		saveDataClients();
	}

	/**
	 * create client <br>
	 * 
	 * @param firstC2
	 * @param nameC
	 * @param idCl
	 * @param pho
	 * @param type
	 * @param found
	 */
	private void creatClient(Clients firstC2, String nameC, String sld, String idCl, String pho, String type,
			boolean found) {
		if (firstC2.getNext() != null) {
			creatClient(firstC2.getNext(), nameC, sld, idCl, pho, type, found);
		} else {
			Clients ls = new Clients(nameC, sld, type, idCl, pho);
			firstC2.setNext(ls);
		}

	}

	/**
	 * look up the customer's name <br>
	 * 
	 * @return p
	 */
	public ArrayList<Clients> getClients() {
		ArrayList<Clients> p = new ArrayList<Clients>();
		p = getClients(firstC, p);
		System.out.println(p.size());
		setClients(p);
		clients =p;
		
		
		return p;
	}

	public void setClients(ArrayList<Clients> clients) {
		this.clients = clients;
	}

	/**
	 * a client returns <br>
	 * 
	 * @param firstC2
	 * @param p
	 * @return p
	 */
	private ArrayList<Clients> getClients(Clients firstC2, ArrayList<Clients> p) {
		boolean run = true;
		while (run) {
			if (firstC2 != null) {
				p.add(firstC2);
				firstC2 = firstC2.getNext();
			} else {
				run = false;
			}
		}
		return p;
	}

	/**
	 * validate clients <br>
	 * 
	 * @return out
	 */
	public boolean validClient() {
		boolean out = false;
		if (firstC != null) {

			out = true;
		}
		return out;
	}

	/**
	 * find clients <br>
	 * 
	 * @param id
	 * @return out
	 */
	public boolean foundClient(String id) {
		boolean out = false;
		out = foundClient(firstC, id, out);
		return out;
	}

	/**
	 * validate if it found the customer <br>
	 * <b> pre: a costumer already created </b>
	 * 
	 * @param em
	 * @param id
	 * @param out
	 * @return out
	 */
	private boolean foundClient(Clients em, String id, boolean out) {
		if (out != true) {
			if (em != null) {
				if (em.getId().equals(id)) {
					out = true;
				} else {
					out = foundClient(em.getNext(), id, out);

				}
			}
		}
		return out;
	}

	/*
	 * public Customer binarySearchCustomer(String firstName, String lastName) {
	 * 
	 * Comparator<Customer> lastNameAndFirstName = new Comparator<Customer>() {
	 * 
	 * @Override public int compare(Customer obj1, Customer obj2) { String f1 =
	 * obj1.getFirstName().toLowerCase(); String l1 =
	 * obj1.getLastName().toLowerCase(); String f2 =
	 * obj2.getFirstName().toLowerCase(); String l2 =
	 * obj2.getLastName().toLowerCase();
	 * 
	 * if (l1.compareTo(l2) == 0) { return f2.compareTo(f1); } else { return
	 * l2.compareTo(l1); } } };
	 * 
	 * Customer key=new Customer(firstName,lastName, "", "", "", "", null); int
	 * index=Collections.binarySearch(customers, key,lastNameAndFirstName); if
	 * (index <0){ key=null; }else{ key=customers.get(index); } return key; }
	 */

	/*
	 * //SelectionSort Comparator<Customer> lastNameAndFirstName = new
	 * Comparator<Customer>() {
	 * 
	 * @Override public int compare(Customer obj1, Customer obj2) { String f1 =
	 * obj1.getFirstName().toLowerCase(); String l1 =
	 * obj1.getLastName().toLowerCase(); String f2 =
	 * obj2.getFirstName().toLowerCase(); String l2 =
	 * obj2.getLastName().toLowerCase();
	 * 
	 * if (l1.compareTo(l2) == 0) {
	 * 
	 * return f1.compareTo(f2); } else { return l1.compareTo(l2); } } };
	 * 
	 * for (int j = 0; j < customers.size() - 1; j++) { Customer min =
	 * customers.get(j); for (int i = j + 1; i < customers.size(); i++) { if
	 * (lastNameAndFirstName.compare(min, customers.get(i)) < 0) { Customer temp =
	 * customers.get(i); customers.set(i, min); min = temp; }
	 * 
	 * } customers.set(j,min);
	 * 
	 * }
	 * 
	 */

	/**
	 * create edible products <br>
	 * 
	 * @param name
	 * @param valuepay
	 * @param valuesale
	 * @param cuantity
	 * @param pr
	 * @param ty
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public void creatProductComes(String name, int valuepay, int valuesale, int cuantity, String pr, String ty) throws FileNotFoundException, IOException {
		int pos = 0;

		for (int i = 0; i < providers.size(); i++) {

			if (providers.get(i).getId().equals(pr)) {
				pos = i;
			}
		}

		Provider pro = providers.get(pos);

		Product p = new ProductEdible(name, valuepay, valuesale, cuantity, pro, ty);

		if (product == null) {
			product = p;

		} else {

			creatProductComes(product, p);
		}
		saveDataProduct();
	}

	/**
	 * create edible products <br>
	 * 
	 * @param product2
	 * @param p
	 */
	private void creatProductComes(Product product2, Product p) {
		if (p.getsetvaluepay() >= product2.getsetvaluepay()) {
			if (product2.getLeft() == null) {

				product2.setLeft(p);
			} else {
				creatProductComes(product2.getLeft(), p);
			}

		} else {
			if (product2.getRight() == null) {

				product2.setRight(p);
			} else {
				creatProductComes(product2.getRight(), p);
			}
		}

	}

	/**
	 * return the edible products <br>
	 * 
	 * @return p
	 */
	public ArrayList<Product> getProductCom() {
		ArrayList<Product> p = new ArrayList<>();
		getProductCom(product, p);
		return p;
	}

	/**
	 * get the product in an array <br>
	 * 
	 * @param current
	 * @param p
	 */
	private void getProductCom(Product current, ArrayList<Product> p) {

		if (current != null) {
			getProductCom(current.getLeft(), p);
			p.add(current);
			getProductCom(current.getRight(), p);
		}
	}

	private Clients clientPro;

	/**
	 * search for customers using binary search <br>
	 * 
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	public Clients binarySearchCustomer(String firstName, String lastName) {
		getClients();
		Comparator<Clients> lastNameAndFirstName = new Comparator<Clients>() {
			@Override
			public int compare(Clients obj1, Clients obj2) {
				String f1 = obj1.getName().toLowerCase();
				String l1 = obj1.getLastName().toLowerCase();
				String f2 = obj2.getName().toLowerCase();
				String l2 = obj2.getLastName().toLowerCase();

				if (l1.compareTo(l2) == 0) {
					return f2.compareTo(f1);
				} else {
					return l2.compareTo(l1);
				}
			}
		};

		Clients key = new Clients(firstName, lastName, "", "", "");
		int index = Collections.binarySearch(clients, key, lastNameAndFirstName);
		if (index < 0) {
			key = null;
		} else {
			key = clients.get(index);
			getClients();
		}
		setClientPro(key);
		return key;
	}

	/**
	 * add costumer <br>
	 * 
	 * @param firstName
	 * @param lastName
	 * @param idCl
	 * @param pho
	 * @param type
	 * @throws IOException
	 */
	public void addClients(String firstName, String lastName, String idCl, String pho, String type) throws IOException {

		// Comparador por apellido y nombre

		Comparator<Clients> lastNameAndFirstName = new Comparator<Clients>() {
			@Override
			public int compare(Clients obj1, Clients obj2) {
				String f1 = obj1.getName().toLowerCase();
				String l1 = obj1.getLastName().toLowerCase();
				String f2 = obj2.getName().toLowerCase();
				String l2 = obj2.getLastName().toLowerCase();

				if (l1.compareTo(l2) == 0) {

					return f1.compareTo(f2);
				} else {
					return l1.compareTo(l2);
				}
			}
		};

		// Agregar de forma ordenada
		Clients customer = new Clients(firstName, lastName, idCl, pho, type);

		if (clients.isEmpty()) {
			clients.add(customer);
		} else {
			int i = 0;
			while (i < clients.size() && lastNameAndFirstName.compare(customer, clients.get(i)) < 0) {
				i++;
			}
			clients.add(i, customer);
		}

		
	}

	/**
	 * save date about costumer <br>
	 * 
	 * @throws IOException
	 */

	public void saveDataClients() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CUSTOMERS_FILE_NAME));
		oos.writeObject(firstC);
		oos.close();
	}

	public void selectProduct(String name, int cuanty) {
		ArrayList<Product> m = getProductCom();
		for (int i = 0; i < m.size(); i++) {
			if (m.get(i).getName().equals(name)) {
				temporal.add(m.get(i));
				temporalNum.add(cuanty);
			}
		}

	}

	/**
	 * calculate the price of a certain number of products <br>
	 * 
	 * @return out
	 */
	public int calculePrice() {
		int out = 0;
		for (int i = 0; i < temporal.size(); i++) {
			out += temporal.get(i).getvaluesale() * temporalNum.get(i);
		}
		return out;
	}

	public Clients getClientPro() {
		return clientPro;
	}

	public void setClientPro(Clients clientPro) {
		this.clientPro = clientPro;
	}
	
	
	public void loadDataVents() throws FileNotFoundException, IOException, ClassNotFoundException {
		File f = new File(VENTS_CONTA);
		if (f.exists()) {
			ObjectInputStream ob = new ObjectInputStream(new FileInputStream(f));
			
			salesConta = (SalesConta) ob.readObject();
			
			ob.close();
		}
	}
	
	
	/**
	 * record sales <br>
	 * 
	 * @param type
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws BuysProhibitExceptions 
	 */
	public void registerSaleContac(String type) throws FileNotFoundException, IOException, BuysProhibitExceptions {
		boolean productAlcoholic = false;
		String out = "";
		for(int i =0;i<temporal.size();i++) {
			out += temporal.get(i).getName()+"\n";
			if(temporal.get(i) instanceof ProductEdible) {
				if(temporal.get(i).returnType().equals("ALCOHOLIC_DRINKS")) {
					
					productAlcoholic = true;
				}
			}
		}
		if(productAlcoholic==true) {
			if(clientPro.getDocumentType().equals("TI")) {
				throw new BuysProhibitExceptions();
			}
		}else {
		SalesConta sl = new SalesConta(clientPro,out, temporal, temporalNum, type);
		if (salesConta == null) {

			salesConta = sl;
			

		} else {
			registerSaleContac(salesConta, sl);
		}
		saveDataVentsCont();
		}
		}

	public void setClientp() {
		clientPro = null;
	}

	/**
	 * record sales <br>
	 * 
	 * @param player1
	 * @param newPlayer
	 */
	private void registerSaleContac(SalesConta player1, SalesConta newPlayer) {

		if (newPlayer.getPrice() >= player1.getPrice()) {
			if (player1.getLeft() == null) {

				player1.setLeft(newPlayer);
			} else {
				registerSaleContac(player1.getLeft(), newPlayer);
			}

		} else {
			if (player1.getRight() == null) {

				player1.setRight(newPlayer);
			} else {
				registerSaleContac(player1.getRight(), newPlayer);
			}
		}
	}

	public ArrayList<SalesConta> getVents() {
		ArrayList<SalesConta> p = new ArrayList<>();
		getVents(salesConta, p);
		return p;
	}
	
	public void saveDataProduct() throws FileNotFoundException, IOException {
		ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(PRODUCTS_TEC_FILE_NAME));
		ob.writeObject(product);
		ob.close();
	}
	public boolean usedSalesC() {
		boolean out = false;
		if (salesConta != null) {
			out = true;
		}
		return out;
	}

	public SalesConta getSalesConta() {
		return salesConta;
	}

	public void setSalesConta(SalesConta salesConta) {
		this.salesConta = salesConta;
	}

	/**
	 * returns sales <br>
	 * 
	 * @param current
	 * @param p
	 */
	private void getVents(SalesConta current, ArrayList<SalesConta> p) {

		if (current != null) {
			getVents(current.getLeft(), p);
			p.add(current);
			getVents(current.getRight(), p);
		}
	}
	public void saveDataProviders() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PROVIDER_FILE_NAME));
		oos.writeObject(providers);
		oos.close();
	}
	public void saveDataVentsCont() throws IOException {
		ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(VENTS_CONTA));
		ob.writeObject(salesConta);
		ob.close();
	}

	public ArrayList<SalesCredit> getSalesCredit() {
		return salesCredit;
	}

	public void setSalesCredit(ArrayList<SalesCredit> salesCredit) {
		this.salesCredit = salesCredit;
	}

	public Debtors getDebtors() {
		return debtors;
	}

	public void setDebtors(Debtors debtors) {
		this.debtors = debtors;
	}

	
	@SuppressWarnings("unchecked")
	public void loadData() throws IOException, ClassNotFoundException {

		File f = new File(CUSTOMERS_FILE_NAME);

		if (f.exists()) {
			ObjectInputStream ob = new ObjectInputStream(new FileInputStream(f));
			firstC = (Clients) ob.readObject();
			ob.close();
			getClients();
		}

		f = new File(PRODUCTS_TEC_FILE_NAME);

		if (f.exists()) {
			ObjectInputStream ob = new ObjectInputStream(new FileInputStream(f));
			product = (Product) ob.readObject();
			ob.close();

		}

		f = new File(PROVIDER_FILE_NAME);

		if (f.exists()) {
			ObjectInputStream prov = new ObjectInputStream(new FileInputStream(f));
			providers = (ArrayList<Provider>) prov.readObject();
			prov.close();
		}/*
		f = new File(VENTS_CONTA);

		if (f.exists()) {
			ObjectInputStream vents = new ObjectInputStream(new FileInputStream(f));
			salesConta = (SalesConta) vents.readObject();
			vents.close();

		}
*/
	}
}
