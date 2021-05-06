package it.beije.makemake.ecommerce;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String name;

	@Column
	private String brand;

	@Column
	private String description;

	@Column
	private BigDecimal price;
	
	@Column
	private String image;
	
	@Column
	private Integer quantity;
	
	
	//Id________________________________________________________
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	//Name________________________________________________________
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	//Brand________________________________________________________
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	//Desc________________________________________________________
	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		this.description = desc;
	}
	//Price________________________________________________________
	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	//Image________________________________________________________
	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	//Qunatity________________________________________________________
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer qunatity) {
		this.quantity = qunatity;
	}
	//________________________________________________________

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", brand=" + brand + ", desc=" + description + ", image=" + image + ", qunatity=" + quantity + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (brand == null) {
			if (other.brand != null)
				return false;
		} else if (!brand.equals(other.brand))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (image == null) {
			if (other.image != null)
				return false;
		} else if (!image.equals(other.image))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		return true;
	}
	

}
