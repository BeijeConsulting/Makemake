package it.beije.makemake.terzaSettimana.lunedi.rubrica;

public class Contatto {
	private String nome;
	private String cognome;
	private String telefono;

	public Contatto(String nome, String cognome, String tel) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = tel;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	@Override
	public String toString() {
		StringBuilder stb = new StringBuilder();
		stb.append("Nome : ").append(nome).append(", ")
			.append("cognome : ").append(cognome).append(", ")
			.append("telefono : ").append(telefono);
		return stb.toString();
	}
}
