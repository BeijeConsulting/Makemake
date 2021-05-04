package it.beije.makemake.esercizi.ecommerce;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class Order_Item {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private Integer id_order;
	
	@Column
	private Integer id_product;
	
	@Column
	private Double price;
	
	@Column
	private Integer quantity;
	

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_Order() {
		return id_order;
	}

	public void setId_Order(Integer id_order) {
		this. id_order =  id_order;
	}
	
	public Integer getId_Product() {
		return id_product;
	}

	public void setId_Product(Integer id_product) {
		this. id_product =  id_product;
	}
	
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this. price =  price;
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this. quantity =  quantity;
	}
	
	
	public String toString() {
		StringBuilder builder = new StringBuilder()
				.append("{ id : ").append(id).append(", ")
				.append("id_order : ").append(id_order).append(", ")
				.append("id_product : ").append(id_product).append(", ")
				.append("price : ").append(price).append(", ")
				.append("quantity : ").append(quantity).append(" }");
		
		return builder.toString();
	}
	
}