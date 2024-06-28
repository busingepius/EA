package domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private long id;
	private String title;
	private String isbn;
	private String author;
	private double price;

	public Book() {
	}

	public Book(String title, String isbn, String author, double price) {
		this.title = title;
		this.isbn = isbn;
		this.author = author;
		this.price = price;
	}
	@Override
	public String toString() {
		return String.format("Book[id=%d, title='%s', isbn='%s', author='%s', price=%f]", id, title, isbn, author, price);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
