package seconds.tester;



import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface userrepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
}


