package jms;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CalcListener {
	Calculator calculator = new Calculator();

	@JmsListener(destination = "testQueue")
	public synchronized void calc(String instructionAsString) {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			CalcInstruction inst = objectMapper.readValue(instructionAsString, CalcInstruction.class);
			System.out.println("JMS receiver received message:" + instructionAsString);
			switch (inst.getOperator()) {
				case '+':
					calculator.add(inst.getNumber());
					System.out.println("received: "+inst);
					System.out.println(calculator);
					break;
				case '-':
					calculator.subtract(inst.getNumber());
					System.out.println("received: "+inst);
					System.out.println(calculator);
			}
		} catch (IOException e) {
			System.out.println("JMS receiver: Cannot convert : " + instructionAsString+" to a CalcInstruction object");
		}
	}
}
