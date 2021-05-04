package rubrica;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import it.beije.makemake.database.HDBSingleton;

public class DBManager {
	private static Session session;
	private static HDBSingleton singleton;
	private static ListaContatti listaContatti;

	public static void main(String[] args) {
		singleton = HDBSingleton.getHDBSingleton();

		ListaContatti lista = new ListaContatti();
		lista = dbToListaContatti();
		listaContattiToDb(lista);
		System.out.println(lista.toString());
	}

	public static ListaContatti dbToListaContatti() {
		listaContatti = new ListaContatti();
		session = singleton.getSession();
		Criteria criteria = session.createCriteria(Contatto.class);
		List<Contatto> contatti = criteria.list();
		System.out.println(contatti);
		for (Contatto c : contatti) {
			System.out.println(c);
			if (c.getMail() == null) {
				listaContatti.caricaLista(c.getId(), c.getCognome(), c.getNome(), c.getTelefono(), null);
			} else {
				listaContatti.caricaLista(c.getId(), c.getCognome(), c.getNome(), c.getTelefono(), c.getMail());
			}

		}
		session.close();
		return listaContatti;

	}

	public static void listaContattiToDb(ListaContatti list) {
		listaContatti = list;
		session = singleton.getSession();
		for (Contatto c : list.getLista()) {
			Transaction transaction = session.beginTransaction();
			session.save(c);
			transaction.commit();
		}
		session.close();
	}

}
