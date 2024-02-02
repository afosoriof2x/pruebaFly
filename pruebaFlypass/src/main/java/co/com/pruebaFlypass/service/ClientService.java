package co.com.pruebaFlypass.service;

import co.com.pruebaFlypass.dto.ClientDTO;
import co.com.pruebaFlypass.factory.ClientFactory;
import co.com.pruebaFlypass.repository.ClientRepository;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void save(ClientDTO clientDTO){
        clientRepository.save(ClientFactory.getClient(clientDTO));
    }
}
