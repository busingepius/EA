package jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TaxListener {


	@JmsListener(destination = "taxQueue")
	public void taxmessage(String text) {
		System.out.println("Taxservice receives message: "+text);
	}
}
