package it.beije.makemake.esercizi.ecommerce;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "\"order\"")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer id_user;
	
	@Column
	private String status;
	
	@Column
	private Double total;
	
	@Column
	private String date;
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_User() {
		return id_user;
	}

	public void setId_User(Integer id_user) {
		this. id_user =  id_user;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this. status =  status;
	}
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this. total =  total;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this. date =  date;
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(id).append(", ")
				.append("date : ").append(date).append(", ")
				.append("id_user : ").append(id_user).append(", ")
				.append("status : ").append(status).append(", ")
				.append("total : ").append(total).append(" }");
		
		return builder.toString();
	}
	
}