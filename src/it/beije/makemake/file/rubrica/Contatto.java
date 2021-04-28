package it.beije.makemake.file.rubrica;

public class Contatto {

	private int id;
	private String nome;
	private String cognome;
	private String telefono;
	private String email;
	
	

	public Contatto(int id, String nome, String cognome, String telefono, String email) {
		this.id =id;
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
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(id).append(", ")
				.append("nome : ").append(nome).append(", ")
				.append("cognome : ").append(cognome).append(", ")
				.append("telefono : ").append(telefono).append(", ")
				.append("email : ").append(email).append(" }");
		
		return builder.toString();
	}
	
	public boolean equals(Contatto con) {
		
		return getNome().equals(con.getNome()) &&
				getCognome().equals(con.getCognome()) &&
				getTelefono().equals(con.getTelefono()) &&
				getEmail().equals(getEmail());
	}
}