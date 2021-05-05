package it.beije.makemake.ecommerce;

public class Product {
	private Integer id;
	private String name;
	private String brand;
	private String desc;
	private Double price;
	private String image;
	private Integer quantity;
	
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
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
}


/*
CREATE TABLE `makemake`.`product` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NULL,
  `brand` VARCHAR(45) NULL,
  `desc` VARCHAR(255) NULL,
  `price` DECIMAL NOT NULL DEFAULT 0,
  `image` VARCHAR(255) NULL,
  `quantity` INT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`));
 */