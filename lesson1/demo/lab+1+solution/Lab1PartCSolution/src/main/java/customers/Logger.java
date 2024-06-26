package customers;



import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class Logger implements ILogger{

	public void log(String logstring) {
		System.out.println("Logging "+new Date() +" "+logstring);
	}

}
