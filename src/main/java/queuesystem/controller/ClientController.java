package queuesystem.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import queuesystem.dto.ClientDTO;
import queuesystem.entity.Client;
import queuesystem.service.ClientService;


import java.util.List;

@RestController
@RequestMapping({"/clients"})

public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }


    @GetMapping
    public List<Client> getAllClients(){
        return clientService.getAllClients();
    }

    @PostMapping
    public Client addClient(@Valid @RequestBody ClientDTO clientDTO){
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setStatus(clientDTO.getStatus());
        client.setPriorityLevel(clientDTO.getPriorityLevel());
        return clientService.addClient(client);
    }

    @DeleteMapping ("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/{id}")

    public Client updateClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO){
        Client client = new Client();
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setStatus(clientDTO.getStatus());
        client.setPriorityLevel(clientDTO.getPriorityLevel());
        return clientService.updateClient(id, client);

    }
    @GetMapping("/next")
    public Client getNextClient() {
        return clientService.getNextClient();
    }
}

