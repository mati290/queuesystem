package queuesystem.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import queuesystem.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {


}

