package queuesystem.service;

import org.springframework.stereotype.Service;

import queuesystem.repository.ClientRepository;
import queuesystem.entity.Client;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Pattern;




@Service
public class ClientService {

    private final PriorityQueue<Client> clientQueue = new PriorityQueue<>();

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

    private final ClientRepository clientRepository;
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }


    public Client addClient(Client client ) {
        validateClient(client);
        Client savedClient = clientRepository.save(client);
        clientQueue.add(client);
        return clientRepository.save(client);
    }
    public Client getNextClient() {
        if (clientQueue.isEmpty()) {
            throw new IllegalStateException("Brak klientów w kolejce");
        }
        return clientQueue.poll();
    }

    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new IllegalArgumentException("Nie można usunąć klienta, którego nie ma w bazie danych");
        }
        clientRepository.deleteById(id);

    }

    public Client updateClient(Long id, Client updateClient){

        validateClient(updateClient);
        Client client = clientRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Client not found"));
        client.setName(updateClient.getName());
        client.setEmail(updateClient.getEmail());
        client.setStatus(updateClient.getStatus());
        client.setPriorityLevel(updateClient.getPriorityLevel());
        return clientRepository.save(client);
    }




    private void validateClient(Client client) {
        if (client == null) {
            throw new IllegalArgumentException("Nie można dodać pustego klienta");
        }
        if (client.getName() == null || client.getName().trim().isEmpty()) {
            throw new IllegalArgumentException("Nazwa klienta nie może być pusta");
        }
        String email = client.getEmail();
        if (email == null || email.trim().isEmpty()) {
            throw new IllegalArgumentException("Email klienta nie może być pusty");
        }
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Nieprawidłowy format emaila");
        }
        if (client.getStatus() == null || client.getStatus().trim().isEmpty()) {
            throw new IllegalArgumentException("Status klienta nie może być pusty");
        }
    }
    private boolean isValidEmail(String email) {
        return EMAIL_PATTERN.matcher(email.trim()).matches();
    }

}
