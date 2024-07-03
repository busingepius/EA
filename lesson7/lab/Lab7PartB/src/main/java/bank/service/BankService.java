package bank.service;

import bank.integration.EmailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bank.domain.Account;
import bank.domain.Customer;
import bank.domain.TraceRecord;
import bank.repositories.AccountRepository;
import bank.repositories.CustomerRepository;
import bank.repositories.TraceRecordRepository;

import jakarta.transaction.Transactional;

@Service
public class BankService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EmailSender emailSender;
    @Autowired
    private TraceRecordRepository traceRecordRepository;


    @Transactional(propagation = Propagation.SUPPORTS)
    public void createCustomerAndAccount(int customerId, String customerName, String emailAddress, String AccountNumber) {
        try {
//            Account account = new Account(AccountNumber);
//            accountRepository.save(account);
//            Customer customer = new Customer(customerId, customerName);
//            customer.setAccount(account);
            TraceRecord traceRecord = new TraceRecord(13"Customer ");
            traceRecordRepository.saveTraceRecord(traceRecord);
//		throw new RuntimeException("could not save customer");
//            customerRepository.saveCustomer(customer);
//            emailSender.sendEmail(emailAddress, "Welcome " + customerName);
        } catch (Exception e) {
            TraceRecord traceRecord = new TraceRecord(14,"Could not create customer " + customerName + " with account " + AccountNumber);
            traceRecordRepository.saveTraceRecord(traceRecord);
//            emailSender.sendEmail(emailAddress, "We could not create your account " + AccountNumber);
        }
    }

}
