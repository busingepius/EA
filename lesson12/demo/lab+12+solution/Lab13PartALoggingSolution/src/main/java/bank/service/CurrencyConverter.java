package bank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CurrencyConverter implements ICurrencyConverter{
    private  Logger logger = LoggerFactory.getLogger(CurrencyConverter.class);

    public double euroToDollars (double amount){
        logger.trace("convert "+amount+" euros to dollars");
		System.out.println("CurrencyConverter: converting "+amount+" dollars to euros");
        return 1.57 * amount;
    }
    
    public double dollarsToEuros (double amount){
        logger.trace("convert "+amount+" dollars to euros");
        return 0.637 * amount;
    }
}
