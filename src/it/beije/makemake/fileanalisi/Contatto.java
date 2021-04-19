package it.beije.makemake.fileanalisi;

public class Contatto {

	private String nome;
	private String cognome;
	private String telefono;
	private String mail;
	
	//____________________________________________________________________________________
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	//____________________________________________________________________________________
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	//____________________________________________________________________________________
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	//____________________________________________________________________________________
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}

	//____________________________________________________________________________________
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("{nome:").append(nome).append(";")
		.append("cognome:").append(cognome).append(";")
		.append("telefono:").append(telefono).append(";")
		.append("email:").append(mail).append("}");
		
		return  builder.toString();
	}
	//____________________________________________________________________________________
	
	public static void main(String[] args) {
		

	}

}
