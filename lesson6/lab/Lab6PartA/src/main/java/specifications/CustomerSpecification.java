package specifications;

import domain.Customer;
import org.springframework.data.jpa.domain.Specification;

public class CustomerSpecification {
    public static Specification<Customer> fromCity(String city) {
        return (root, query, cb) -> {
            return cb.equal(root.get("address").get("city"), city);
        };
    }
}