package specifications;

import domain.Order;
import org.springframework.data.jpa.domain.Specification;

public class OrderSpecification {
    public static Specification<Order> isClosedOrOpen(String status) {
        return (root, query, cb) -> cb.equal(root.get("status"), status);
    }
}