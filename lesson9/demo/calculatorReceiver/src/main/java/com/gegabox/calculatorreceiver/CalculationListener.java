package com.gegabox.calculatorreceiver;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CalculationListener {
    static int initial = 1;

    @JmsListener(destination = "calculator")
    public void receiveMessage( String calculatorAsString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try{
            Calculator calculator = objectMapper.readValue(calculatorAsString,Calculator.class);
            System.out.println("JMS receiver received message:" + calculator.getOperator()+" "+calculator.getDigit());
            if(calculator.getOperator().equals("add")){
                initial=initial+calculator.getDigit();
                System.out.println("Result: "+(initial+calculator.getDigit()));
            }
            else if(calculator.getOperator().equals("subtract")){
                initial=initial-calculator.getDigit();
                System.out.println("Result: "+(initial-calculator.getDigit()));
            }
            else if(calculator.getOperator().equals("multiply")){
                initial=initial*calculator.getDigit();
                System.out.println("Result: "+(initial*calculator.getDigit()));
            }
        }
        catch (Exception e) {
            System.out.println("JMS receiver: Cannot convert : " + calculatorAsString+" to a Calculator object");
        }
    }
}
