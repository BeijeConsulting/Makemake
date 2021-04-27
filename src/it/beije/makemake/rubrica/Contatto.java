package it.beije.makemake.rubrica;

public class Contatto {
	
	private int id;
	private String nome;
	private String cognome;
	private String telefono;
	private String email;
	
	
	public Contatto(String nome, String cognome, String telefono, String email) {
		this.nome = nome;
		this.cognome = cognome;
		this.telefono = telefono;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("Id : ").append(id).append(", ")
				.append("Nome : ").append(nome).append(", ")
				.append("Cognome : ").append(cognome).append(", ")
				.append("Telefono : ").append(telefono).append(", ")
				.append("E-mail : ").append(email);
		
		return builder.toString();
	}
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Contatto) {
			Contatto c = (Contatto) obj;
			return nome.equals(c.nome) && cognome.equals(c.cognome) && telefono.equals(c.telefono) && email.equals(c.email);
		}
		return false;
		}
	
}
