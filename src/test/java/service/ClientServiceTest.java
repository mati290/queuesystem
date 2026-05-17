package service;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import queuesystem.entity.Client;
import queuesystem.repository.ClientRepository;
import queuesystem.service.ClientService;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ClientServiceTest {
    @Mock
    ClientRepository clientRepository;
    @InjectMocks
    ClientService clientService;
    @Test
    void shouldAddClient() {
        Client client = new Client();
        client.setName("John Doe");
        client.setEmail("john.doe@example.com");
        client.setStatus("Regular");
        client.setPriorityLevel(1);
        clientService.addClient(client);
        verify(clientRepository).save(client);
    }

}
