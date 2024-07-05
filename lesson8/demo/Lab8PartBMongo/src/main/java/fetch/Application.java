package fetch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	OwnerRepository ownerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// start the stopwatch
		StopWatch stopwatch = new StopWatch();
		stopwatch.start();

		//fill database
		for (int x = 0; x < 10000; x++) {
			Owner owner = new Owner("Frank" + x);
			List<Pet> petlist = new ArrayList<Pet>();
			for (int y = 0; y < 10; y++) {
				Pet pet = new Pet("Garfield" + x + "-" + y);
				petlist.add(pet);
			}
			owner.setPets(petlist);
			ownerRepository.save(owner);
		}

		// stop the stopwatch
		stopwatch.stop();
		System.out.println("Mongo: To save this data in the database took "
				+ stopwatch.getTotalTimeMillis() + " milliseconds.");

        // start the stopwatch
		stopwatch = new StopWatch();
		stopwatch.start();

		// fetch owners
		List<Owner> ownerlist = ownerRepository.findAll();
//		for (Owner owner : ownerlist) {
//			for (Pet pet : owner.getPets()) {
//				System.out.println("Owner name= " + owner.getName()
//						+ "pet name= " + pet.getName());
//			}
//		}
		System.out.println("We fetched "+ownerlist.size()+" records");
		// stop the stopwatch
		stopwatch.stop();
		System.out.println("Mongo: To fetch this data from the database took "
				+ stopwatch.getTotalTimeMillis() + " milliseconds.");
	}
}
