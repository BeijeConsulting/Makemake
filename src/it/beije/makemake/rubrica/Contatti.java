package it.beije.makemake.rubrica;

import java.util.ArrayList;

public class Contatti {

	private ArrayList<Contatto> listaContatti = new ArrayList<Contatto>();
	
	public ArrayList<Contatto> getLista(){
		return listaContatti;
	}
	
	public void inserisciContatto(String nome, String cognome, String telefono, String email) {
		Contatto contatto = new Contatto(nome, cognome, telefono, email);
		listaContatti.add(contatto);
	}
}
