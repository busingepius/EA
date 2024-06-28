package partb.domain;

import jakarta.persistence.*;

@Entity
public class Book {
	@Id
	@GeneratedValue
	private long id;
	private String isbn;
	private String title;
	private String author;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinTable(name = "Book_Publisher")
	Publisher publisher;

	public Book() {
		super();
	}

	public Book(String isbn, String title, String author) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	public long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book{" +
				"id=" + id +
				", isbn='" + isbn + '\'' +
				", title='" + title + '\'' +
				", author='" + author + '\'' +
				", publisher=" + publisher +
				'}';
	}
}
