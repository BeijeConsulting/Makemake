package it.beije.makemake.ecommerce;

import java.time.LocalDateTime;

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
private LocalDateTime date;

@Column(name = "user_id")
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

public void setUserId(Integer user_id) {
	this.userId = user_id;
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


}
