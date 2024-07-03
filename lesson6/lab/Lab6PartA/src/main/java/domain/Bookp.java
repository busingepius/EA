package domain;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("bookp")
public class Bookp extends Product{
    private String isbn;

    public Bookp(){}

    public Bookp(String name, String description, double price, String isbn){
        super(name, description, price);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

}