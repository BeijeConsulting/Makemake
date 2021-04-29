package HDBEx;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "animali")
public class Animal {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name = "name")
	private String name;

	@Column(name = "age")
	private String age;

	@Column(name = "diet")
	private String diet;

	@Column(name = "habitat")
	private String habitat;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getNome() {
		return name;
	}
	public void setNome(String nome) {
		this.name = nome;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String età) {
		this.age = età;
	}
	
	public String getDiet() {
		return diet;
	}
	public void setDiet(String dieta) {
		this.diet = dieta;
	}
	
	public String getHabitat() {
		return habitat;
	}
	public void setHabitat(String habit) {
		this.habitat = habit;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(id).append(", ")
				.append("nome : ").append(name).append(", ")
				.append("età : ").append(age).append(", ")
				.append("dieta : ").append(diet).append(", ")
				.append("habitat : ").append(habitat).append(" }");
		
		return builder.toString();
	}
}

