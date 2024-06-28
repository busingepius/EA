package partb;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import partb.domain.Book;
import partb.domain.Publisher;
import partb.repositories.BookRepository;

@SpringBootApplication
public class BookApplication implements CommandLineRunner {
		@Autowired
		BookRepository bookRepository;

		public static void main(String[] args) {
			SpringApplication.run(BookApplication.class, args);
		}

		@Override
		public void run(String... args) throws Exception {
			Book book = new Book("123432123", "Java Patterns", "Sam Cooke");
			Publisher publisher = new Publisher("Quick books");
			//book.setPublisher(publisher);

			bookRepository.save(book);


			Optional<Book> bookOpt = bookRepository.findById(1L);
			Book book2 = bookOpt.get();
			System.out.println(book2);

		}

	}

