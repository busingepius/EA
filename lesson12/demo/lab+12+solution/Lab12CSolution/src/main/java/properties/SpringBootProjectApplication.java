package properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class SpringBootProjectApplication implements CommandLineRunner {
	@Autowired
	private AppProperties appProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjectApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		appProperties.print();		
	}
}
