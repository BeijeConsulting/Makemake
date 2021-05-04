package it.beije.makemake.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String name;
	
	@Column
	private String surname;

	//Id________________________________________________________
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	//Username________________________________________________________
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	//Password________________________________________________________
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//Name________________________________________________________
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	//Surname________________________________________________________
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	//________________________________________________________

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", name=" + name + ", surname="
				+ surname + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
	
}


