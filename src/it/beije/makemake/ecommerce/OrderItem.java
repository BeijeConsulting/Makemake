package it.beije.makemake.ecommerce;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "order_id")
	private int orderId;
	
	@Column(name = "product_id")
	private int productId;
	
	@Column
	private double price;
	
	@Column
	private int quantity;
	
	
	public int getId() {
		return id;
	}
	
	public int getOrderId() {
		return orderId;
	}
	
	
	public int getProductId() {
		return productId;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
