package app;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import repositories.CustomerRepository;
import domain.Customer;
import domain.Book;
import repositories.BookRepository;

@SpringBootApplication
@EnableJpaRepositories("repositories")
@EntityScan("domain") 
public class CustomerApplication implements CommandLineRunner{
	
	@Autowired
	CustomerRepository customerrepository;

	@Autowired
	BookRepository bookrepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		customerrepository.save(new Customer("Jack", "Bauer", "jack@acme.com"));
		customerrepository.save(new Customer("Chloe", "O'Brian", "chloe@acme.com"));
		customerrepository.save(new Customer("Kim", "Bauer", "kim@acme.com"));
		customerrepository.save(new Customer("David", "Palmer", "dpalmer@gmail.com"));
		customerrepository.save(new Customer("Michelle", "Dessler", "mich@hotmail.com"));

		bookrepository.save(new Book("The Catcher in the Rye", "978-0-316-76948-0", "J.D. Salinger", 7.99));
		bookrepository.save(new Book("To Kill a Mockingbird", "978-0-06-112008-4", "Harper Lee", 6.99));
		bookrepository.save(new Book("1984", "978-0-452-28423-4", "George Orwell", 9.99));
		bookrepository.save(new Book("Pride and Prejudice", "978-0-486-41467-1", "Jane Austen", 5.99));
		bookrepository.save(new Book("The Great Gatsby", "978-0-7432-7356-5", "F. Scott Fitzgerald", 8.99));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : customerrepository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch all books
		System.out.println("Books found with findAll():");
		System.out.println("-------------------------------");
		for (Book book : bookrepository.findAll()) {
			System.out.println(book);
		}
		System.out.println();

		// fetch an individual customer by ID
		Optional<Customer> custOpt = customerrepository.findById(1L);
		Customer customer = custOpt.get();
		System.out.println("Customer found with findOne(1L):");
		System.out.println("--------------------------------");
		System.out.println(customer);
		System.out.println();

		// fetch an individual book by ID
		Optional<Book> bookOpt = bookrepository.findById(1);
		Book book = bookOpt.get();
		System.out.println("Book found with findOne(1):");
		System.out.println("--------------------------------");
		System.out.println(book);
		System.out.println();
	}
}
