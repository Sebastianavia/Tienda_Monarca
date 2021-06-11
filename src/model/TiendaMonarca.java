package model;

import java.util.ArrayList;

public class TiendaMonarca {
	
	public static final String CUSTOMERS_FILE_NAME = "src/data/customers.bbd";
	public static final String Debstor_FILE_NAME = "src/data/debstor.bbd";
    public static final String PRODUCTS_TEC_FILE_NAME = "src/data/productstec.bbd";
    public static final String PRODUCTS_HOG_FILE_NAME = "src/data/productshog.bbd";
    public static final String PROVIDER_FILE_NAME = "src/data/orders.bbd";
	private EmployeUser first;
	private Clients firstC;
	private Product product;
	private Debtors debtors;
	private SalesConta salesConta;
	private ArrayList<Provider> providers;
	
	

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

	// Listas enlazada = clients. product
	// Arbol binario = producto . ventas contado
	public TiendaMonarca() {
		providers = new ArrayList<>();
		salesCredit = new ArrayList<>();
		if (first == null) {
			first = new EmployeUser("admin", "admin", "admin", "admin", "123");
		}
	}

	
	/**
	 * check if providers exist <br>
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
	 * @param name
	 * @param valuepay
	 * @param valuesale
	 * @param cuantity
	 * @param pr
	 * @param ty
	 * @param br
	 * @param cap
	 */
	public void creatProductTech(String name, int valuepay, int valuesale, int cuantity, String pr, String ty,
			String br, int cap) {
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
	}

	
	/**
	 * create a technological product if it is not registered <br>
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
	 * @param name
	 * @param phone
	 * @param address
	 * @param id
	 * @param numAcount
	 * @return
	 */
	public boolean addProovider(String name, String phone, String address, String id, String numAcount) {
		boolean out = false;
		Provider pro = new ProviderConta(name, phone, address, id, numAcount);
		providers.add(pro);
		return out;
	}

	
	/**
	 * add provider <br>
	 * @param name
	 * @param phone
	 * @param address
	 * @param id
	 * @param term
	 * @return
	 */
	public boolean addProovider(String name, String phone, String address, String id, int term) {
		boolean out = false;
		Provider pro = new ProviderCredit(name, phone, address, id, term);
		providers.add(pro);
		return out;
	}

	/**
	 * returns the existing product <br>
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

	
	/**
	 * verify user <br>
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
	 * @param nameC
	 * @param idCl
	 * @param pho
	 * @param type
	 */
	public void creatClient(String nameC, String idCl, String pho, String type) {
		if (firstC == null) {

			firstC = new Clients(nameC, idCl, pho, type);

		} else {
			boolean found = false;
			creatClient(firstC, nameC, idCl, pho, type, found);
		}
	}

	
	/**
	 * create client <br>
	 * @param firstC2
	 * @param nameC
	 * @param idCl
	 * @param pho
	 * @param type
	 * @param found
	 */
	private void creatClient(Clients firstC2, String nameC, String idCl, String pho, String type, boolean found) {
		if (firstC2.getNext() != null) {
			creatClient(firstC2.getNext(), nameC, idCl, pho, type, found);
		} else {
			Clients ls = new Clients(nameC, type, idCl, pho);
			firstC2.setNext(ls);
		}

	}

	
	/**
	 * look up the customer's name <br>
	 * @return p
	 */
	public ArrayList<Clients> getClients() {
		ArrayList<Clients> p = new ArrayList<Clients>();
		p = getClients(firstC, p);
		return p;
	}

	
	/**
	 * a client returns <br>
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
	
	/*public Customer binarySearchCustomer(String firstName, String lastName) {

        Comparator<Customer> lastNameAndFirstName = new Comparator<Customer>() {
            @Override
            public int compare(Customer obj1, Customer obj2) {
                String f1 = obj1.getFirstName().toLowerCase();
                String l1 = obj1.getLastName().toLowerCase();
                String f2 = obj2.getFirstName().toLowerCase();
                String l2 = obj2.getLastName().toLowerCase();

                if (l1.compareTo(l2) == 0) {
                    return f2.compareTo(f1);
                } else {
                    return l2.compareTo(l1);
                }
            }
        };

        Customer key=new Customer(firstName,lastName, "", "", "", "", null);
        int index=Collections.binarySearch(customers, key,lastNameAndFirstName);
        if (index <0){
            key=null;
        }else{
            key=customers.get(index);
        }
        return key;
    }
	 */
	
	
	/*
	 //SelectionSort
        Comparator<Customer> lastNameAndFirstName = new Comparator<Customer>() {
            @Override
            public int compare(Customer obj1, Customer obj2) {
                String f1 = obj1.getFirstName().toLowerCase();
                String l1 = obj1.getLastName().toLowerCase();
                String f2 = obj2.getFirstName().toLowerCase();
                String l2 = obj2.getLastName().toLowerCase();

                if (l1.compareTo(l2) == 0) {

                    return f1.compareTo(f2);
                } else {
                    return l1.compareTo(l2);
                }
            }
        };

        for (int j = 0; j < customers.size() - 1; j++) {
            Customer min = customers.get(j);
            for (int i = j + 1; i < customers.size(); i++) {
                if (lastNameAndFirstName.compare(min, customers.get(i)) < 0) {  
                    Customer temp = customers.get(i);
                    customers.set(i, min);
                    min = temp;
                }

            }
            customers.set(j,min);

        }

	 */
}
