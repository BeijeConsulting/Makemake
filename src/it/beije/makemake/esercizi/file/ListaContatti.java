package it.beije.makemake.esercizi.file;
import java.util.ArrayList;


public class ListaContatti {
	
	//Attributi
	private ArrayList<Contatto> lista = new ArrayList<Contatto>();
	
	//metodi
	public ArrayList<Contatto> getLista() {
		return lista;
	}
	public void caricaLista(Contatto obj) {
		if(!contattoEsistente(obj)) {
			lista.add(obj);
		}
	}
	public void caricaLista(String nome, String cognome, String telefono, String mail) {
		
		Contatto obj = new Contatto(nome, cognome, telefono, mail);
		if(!contattoEsistente(obj)) {
			lista.add(obj);
		}
	}
	
	public boolean contattoEsistente(Contatto c) {
		boolean esiste = false;
		for (int i = 0; i < this.lista.size(); i++) {
			if(this.lista.get(i).equals(c) ) {
				esiste = true;
			}
		}
		
		return esiste;
	}
	@Override
	public String toString() {
		String s = "ListaContatti [" +"\n";
		for (int i = 0; i < lista.size(); i++) {
		 s+= "\t\t "+lista.get(i).toString()+"\n";
		}
		s+="\t\t]";
		return s ;
	}
	
}
