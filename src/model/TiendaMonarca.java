package model;

public class TiendaMonarca {
	private EmployeUser first;
	private Clients firstC;

	public TiendaMonarca() {
		if (first == null) {
			first = new EmployeUser("admin", "admin", "admin", "admin", "123");
		}
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
		if(firstC==null) {	
			firstC =  new Clients(nameC,idCl,pho,type);
		}else {
			boolean found = false;
			creatClient(firstC, nameC,idCl,pho,type,found);
		}
	}

	private void creatClient(Clients firstC2, String nameC, String idCl, String pho, String type,boolean found) {
		if (firstC2.getNext() != null) {
			creatClient(firstC2.getNext(),nameC,idCl,pho,type,found);
		} else {
			Clients ls = new Clients(nameC, type, idCl, pho);
			firstC2.setNext(ls);
		}
		
	}
}
