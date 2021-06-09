package model;

import java.util.ArrayList;

public class TiendaMonarca {
	private EmployeUser first;
	private Clients firstC;
	private Product product;
	private Debtors debtors;
	private SalesConta salesConta;
	private ArrayList<Provider> providers;

	public ArrayList<Provider> getProviders() {
		return providers;
	}

	public void setProviders(ArrayList<Provider> providers) {
		this.providers = providers;
	}

	private ArrayList<SalesCredit> salesCredit;

	// Listas enlazada = clients. product
	// Arbol binrio = producto . ventas contado
	public TiendaMonarca() {
		providers = new ArrayList<>();
		salesCredit = new ArrayList<>();
		if (first == null) {
			first = new EmployeUser("admin", "admin", "admin", "admin", "123");
		}
	}

	public boolean existProvider(String id) {
		boolean out = false;
		for (int i = 0; i < providers.size(); i++) {
			if (providers.get(i).getId().equals(id)) {
				out = true;
			}
		}
		return out;
	}

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

	public boolean addProovider(String name, String phone, String address, String id, String numAcount) {
		boolean out = false;
		Provider pro = new ProviderConta(name, phone, address, id, numAcount);
		providers.add(pro);
		return out;
	}

	public boolean addProovider(String name, String phone, String address, String id, int term) {
		boolean out = false;
		Provider pro = new ProviderCredit(name, phone, address, id, term);
		providers.add(pro);
		return out;
	}

	public boolean existProduct(String name) {
		boolean out = false;
		out = existProduct(product, out, name);
		return out;
	}

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

	public boolean found(String name, String pass) {
		boolean out = false;
		out = foundU(first, name, pass, out);
		return out;
	}

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

	public boolean foundExistUser(String userN) {
		boolean out = false;
		out = foundExistUser(first, userN, out);
		return out;
	}

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

	public void creatUser(String name, String lastN, String id, String nameU, String pass) {
		boolean found = false;
		creatUser(first, name, lastN, id, nameU, pass, found);
	}

	private void creatUser(EmployeUser user1, String name, String lastN, String id, String nameU, String pass,
			boolean found) {

		if (user1.getNext() != null) {
			creatUser(user1.getNext(), name, lastN, id, nameU, pass, found);
		} else {
			EmployeUser ls = new EmployeUser(name, lastN, id, nameU, pass);

			user1.setNext(ls);
		}

	}

	public void creatClient(String nameC, String idCl, String pho, String type) {
		if (firstC == null) {

			firstC = new Clients(nameC, idCl, pho, type);

		} else {
			boolean found = false;
			creatClient(firstC, nameC, idCl, pho, type, found);
		}
	}

	private void creatClient(Clients firstC2, String nameC, String idCl, String pho, String type, boolean found) {
		if (firstC2.getNext() != null) {
			creatClient(firstC2.getNext(), nameC, idCl, pho, type, found);
		} else {
			Clients ls = new Clients(nameC, type, idCl, pho);
			firstC2.setNext(ls);
		}

	}

	public ArrayList<Clients> getClients() {
		ArrayList<Clients> p = new ArrayList<Clients>();
		p = getClients(firstC, p);
		return p;
	}

	private ArrayList<Clients> getClients(Clients firstC2, ArrayList<Clients> p) {
		boolean run = true;
		while (run) {
			if (firstC2 != null) {
				p.add(firstC2);
				System.out.println(p.get(0).getName() + "  asada");
				firstC2 = firstC2.getNext();
			} else {
				run = false;
			}
		}
		return p;
	}

	public boolean validClient() {
		boolean out = false;
		if (firstC != null) {
			System.out.println(firstC.getName());
			out = true;
		}
		return out;
	}
}
