package kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

import java.time.LocalDate;

@SpringBootApplication
@EnableKafka
public class SenderApplication implements CommandLineRunner {
    @Autowired
    Sender sender;

    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // create an account
        AccountInstruction createAccount = new AccountInstruction(33L, "createAccount","Mary Smith");
        //convert instruction to JSON string
        ObjectMapper objectMapper = new ObjectMapper();
        String createAccountAsString = objectMapper.writeValueAsString(createAccount);

        System.out.println("Sending a Kafka message:" + createAccountAsString);
        sender.send("accountTopic",createAccountAsString);

        //deposit
        AccountInstruction deposit = new AccountInstruction(33L, "deposit",30000.0);
        //convert instruction to JSON string
        String depositAsString = objectMapper.writeValueAsString(deposit);

        System.out.println("Sending a Kafka message:" + depositAsString);
        sender.send("accountTopic",depositAsString);
        //withdraw
        AccountInstruction withdraw = new AccountInstruction(33L, "withdraw",200.0);
        //convert instruction to JSON string
        String withdrawAsString = objectMapper.writeValueAsString(withdraw);

        System.out.println("Sending a Kafka message:" + withdrawAsString);
        sender.send("accountTopic",withdrawAsString);

    }
}
