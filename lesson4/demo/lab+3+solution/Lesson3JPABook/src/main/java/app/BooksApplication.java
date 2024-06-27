package app;

import domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import repositories.BookRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class BooksApplication implements CommandLineRunner{
	
	@Autowired
	BookRepository bookrepository;

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("book1", "1234", "author1", 12.35);
		Book book2 = new Book("book2", "1345", "author2", 14.35);
		Book book3 = new Book("thebook3", "1543", "author3", 16.35);
		Book book4 = new Book("book21", "1324", "author2", 15.75);

		bookrepository.save(book1);
		bookrepository.save(book2);
		bookrepository.save(book3);
		bookrepository.save(book4);


		System.out.println("Books found with findAll():");
		System.out.println("-------------------------------");
		for (Book book : bookrepository.findAll()) {
			System.out.println(book);
		}
		System.out.println();

		book2.setTitle("Harry Potter");
		bookrepository.save(book2);

		bookrepository.delete(book3);

		System.out.println("Books found with findAll():");
		System.out.println("-------------------------------");
		for (Book book : bookrepository.findAll()) {
			System.out.println(book);
		}
		
	}

}
