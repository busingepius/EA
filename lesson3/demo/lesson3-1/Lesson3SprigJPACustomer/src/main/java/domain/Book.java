package domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
public class Book {
    @Id
    @GeneratedValue
    private int id;

    private String title;
    private String ISBN;
    private String author;
    private double price;

    protected Book() {
    }

public Book(String title, String ISBN, String author, double price) {
        super();
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Book[id=%d, title='%s', ISBN='%s', author='%s', price='%f']", id, title, ISBN, author, price);
    }
}

//create Book  table