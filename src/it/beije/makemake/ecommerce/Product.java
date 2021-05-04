	package it.beije.makemake.ecommerce;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	
	
@Entity
public class Product {
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			private Integer id;
			
			@Column
			private String name;
			
			@Column
			private String brand;
			
			@Column
			private String descr;
			
			@Column
			private double price;
			
			@Column
			private String image;
			
			@Column
			private int quantity;

			
			public Integer getId() {
				return id;
			}
			public void setId(Integer id) {
				this.id = id;
			}

			
			public String getName() {
				return name;
			}		
			public void setName(String name) {
				this.name = name;
			}
			
			
			public String getBrand() {
				return brand;
			}		
			public void setBrand(String brand) {
				this.brand = brand;
			}
			
			
			public String getDesc() {
				return descr;
			}		
			public void setDesc(String desc) {
				this.descr = descr;
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
			
			
			public String getImage() {
				return image;
			}
			public void setImage() {
				this.image = image;
			}

}
