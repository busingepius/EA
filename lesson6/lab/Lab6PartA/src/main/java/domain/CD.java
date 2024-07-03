package domain;

import javax.persistence.Entity;
import javax.persistence.DiscriminatorValue;

@Entity
@DiscriminatorValue("cd")
public class CD extends Product{
    private String artist;

    public CD(){}

    public CD(String name, String description, double price, String artist){
        super(name, description, price);
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String toString(){
        return super.toString() + ", Artist: " + artist+"]";
    }
}