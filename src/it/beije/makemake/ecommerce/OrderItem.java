package it.beije.makemake.ecommerce;
import java.math.BigDecimal;

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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name= "id_order")
	private Integer orderId;
	
	@Column(name= "id_product")
	private Integer productId;
	
	@Column
	private BigDecimal price;
	
	@Column
	private Integer quantity;
	
	//Id________________________________________________________
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	//Id_order________________________________________________________
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer id_order) {
		this.orderId = id_order;
	}
	//Id_product________________________________________________________
	public Integer getProductId() {
		return productId;
	}
	
	public void setProductId(Integer id_product) {
		this.productId = id_product;
	}
	//Price________________________________________________________
	public BigDecimal getPrice() {
		return price;
	}
	
	public void setPrice(BigDecimal bigDecimal) {
		this.price = bigDecimal;
	}
	//Quantity________________________________________________________
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	//________________________________________________________

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", orderId=" + orderId + ", productId=" + productId + ", price=" + price
				+ ", quantity=" + quantity + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	

	
	
}
