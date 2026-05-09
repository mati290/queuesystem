package queuesystem.controller;

import org.springframework.web.bind.annotation.*;
import queuesystem.entity.Client;
import queuesystem.service.ClientService;


import java.util.List;

@RestController
@RequestMapping("/clients")

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
    public Client addClient(@RequestBody Client client){
        return clientService.addClient(client);
    }

    @DeleteMapping ("/{id}")
    public void deleteClient(@PathVariable Long id){
        clientService.deleteClient(id);
    }

    @PutMapping("/{id}")

    public Client updateClient(@PathVariable Long id, @RequestBody Client client){
        return clientService.updateClient(id, client);
    }
}

