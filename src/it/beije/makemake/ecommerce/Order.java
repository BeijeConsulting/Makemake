package it.beije.makemake.ecommerce;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "`order`")
public class Order {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private Integer id;
	
	@Column
	private LocalDateTime date;
	
	@Column(name = "id_user")
	private Integer userId;
	
	@Column
	private String status;
	
	@Column
	private Double total;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(id).append(", ")
				.append("userId : ").append(userId).append(", ")
				.append("total : ").append(total).append(", ")
				.append("date : ").append(date).append(", ")
				.append("status : ").append(status).append(" }");
		
		return builder.toString();
	}

}
