package co.com.pruebaFlypass.service;

import co.com.pruebaFlypass.dto.ClientDTO;
import co.com.pruebaFlypass.factory.ClientFactory;
import co.com.pruebaFlypass.general.exception.AppException;
import co.com.pruebaFlypass.model.Client;
import co.com.pruebaFlypass.repository.ClientRepository;
import co.com.pruebaFlypass.general.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class ClientService {

    private final ClientRepository clientRepository;
    private final static Integer MAYORIA_EDAD = 18;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void save(ClientDTO clientDTO) throws AppException {

        clientValidate(clientDTO);
        clientRepository.save(ClientFactory.getClient(clientDTO));
    }

    private void clientValidate(ClientDTO clientDTO) throws AppException {

        if(Objects.isNull(clientDTO.getName())){
            throw new AppException("El nombre no puede ser nulo");
        }

        if(Objects.isNull(clientDTO.getEmail())){
            throw new AppException("El E-mail no puede ser nulo");
        }

        if(Objects.isNull(clientDTO.getSurname())){
            throw new AppException("El Apellido no puede ser nulo");
        }

        if(Objects.isNull(clientDTO.getDocumentNum())){
            throw new AppException("El Documento no puede ser nulo");
        }

        if(Objects.isNull(clientDTO.getDocumentType())){
            throw new AppException("El tipo de Documento no puede ser nulo");
        }

        if(Objects.isNull(clientDTO.getBirthDate())){
            throw new AppException("La fecha de nacimiento no puede ser nulo");
        }

        if(Utils.getClientAge(clientDTO.getBirthDate()) < MAYORIA_EDAD){
            throw new AppException("El Cliente NO puede ser menor de edad");
        }

        if(!Utils.isValidEmail(clientDTO.getEmail())){
            throw new AppException("El Email No es válido");
        }
        if(clientDTO.getName().length() <2 ){
            throw new AppException("El nombre NO puede ser menor a 2 caracteres.");
        }

        if(clientDTO.getSurname().length() < 2){
            throw new AppException("El apellido NO puede ser menor a 2 caracteres.");
        }
    }

    public List<ClientDTO> getClients() {

        Iterable<Client> list = clientRepository.findAll();
        List<ClientDTO> clientList = new ArrayList<>();

        list.forEach(client->{
            ClientDTO dto = client.getDto();
            clientList.add(dto);

        });
        return clientList;
    }
}
