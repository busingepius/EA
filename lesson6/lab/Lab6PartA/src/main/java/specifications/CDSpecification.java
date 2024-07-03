package specifications;

import domain.CD;
import org.springframework.data.jpa.domain.Specification;

public class CDSpecification {
    public static Specification<CD> isPriceGreaterThan(double price) {
        return (root, query, cb) -> {
            return cb.greaterThan(root.get("price"), price);
        };
    }
}