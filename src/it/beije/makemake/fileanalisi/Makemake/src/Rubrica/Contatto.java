package it.beije.makemake.fileanalisi.Makemake.src.Rubrica;


public class Contatto {
	
	//attributi
	private String nome;
	private String cognome;
	private String telefono;
	private String mail;
	
	//getter & setter
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	//metodi
	@Override
	public boolean equals(Object anObject) {
		boolean uguale = false;
		if( anObject instanceof Contatto) {
			Contatto c2 = (Contatto) anObject;
			if(
				(this.getNome().equalsIgnoreCase(c2.getNome())) &&
				(this.getCognome().equalsIgnoreCase(c2.getCognome()))&&
				(this.getTelefono().equalsIgnoreCase(c2.getTelefono()))&&
				(this.getMail().equalsIgnoreCase(c2.getMail()))
				 
				) {
				uguale = true;
			}
		}
		return uguale;
	}
	@Override
	public String toString() {
		return "Contatto [nome=" + nome + ", cognome=" + cognome + ", telefono=" + telefono + ", mail=" + mail + "]";
	}
	
	//costruttore
	public Contatto(String nome, String cognome, String telefono, String mail) {
		
		this.setNome(nome);
		this.setCognome(cognome);
		this.setTelefono(telefono);
		this.setMail(mail);
	}
	
	
}
