package cl.ucm.serviceproduct.repository;

import cl.ucm.serviceproduct.entities.LogItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogRepository extends MongoRepository<LogItem, String> {
}
