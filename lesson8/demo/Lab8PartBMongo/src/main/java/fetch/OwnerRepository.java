package fetch;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface OwnerRepository extends MongoRepository<Owner, Integer> {

}
