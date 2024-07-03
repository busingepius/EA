package bank.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import bank.domain.Customer;

import jakarta.transaction.Transactional;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    @Transactional
    default void saveCustomer(Customer customer) {
//        throw new RuntimeException("could not save customer");
        save(customer);
    }
}

//// original code
//public interface CustomerRepository extends JpaRepository<Customer, Long> {
//    default void saveCustomer(Customer customer) {
////        throw new RuntimeException("could not save customer");
//        save(customer);
//    }
//}




