package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;


@Entity
@Inheritance(strategy=InheritanceType.JOINED)
//@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
//@DiscriminatorColumn(name="product_type",discriminatorType=DiscriminatorType.STRING)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long productNumber;
	private String name;
	private String description;
	private double price;

	public Product() {
	}

	public Product(String name, String description, double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Long getProductNumber() {
		return productNumber;
	}

//	public void setProductNumber(Long productNumber) {
//		this.productNumber = productNumber;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
