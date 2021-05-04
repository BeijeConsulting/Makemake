package it.beije.makemake.ecommerce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"order_item\"")

public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "id_order")
	private Integer orderId;
	
	@Column(name = "id_product")
	private Integer ProductId;
	@Column
	private double price;
	@Column
	private Integer quantity;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_order() {
		return orderId;
	}

	public void setId_order(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getId_product() {
		return ProductId;
	}

	public void setId_product(Integer ProductId) {
		this.ProductId = ProductId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", id_order=" + orderId + ", id_product=" + ProductId + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}


}
/*
 * CREATE TABLE `makemake`.`order_item` ( `id` INT NOT NULL AUTO_INCREMENT,
 * `id_order` INT NOT NULL, `id_product` INT NOT NULL, `price` DECIMAL NOT NULL,
 * `quantity` INT NOT NULL, PRIMARY KEY (`id`));
 */