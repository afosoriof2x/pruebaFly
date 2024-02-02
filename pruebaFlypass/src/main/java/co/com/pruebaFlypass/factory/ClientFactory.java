package co.com.pruebaFlypass.factory;

import co.com.pruebaFlypass.dto.ClientDTO;
import co.com.pruebaFlypass.general.enums.EnumDocumentType;
import co.com.pruebaFlypass.model.Client;

import java.util.Date;

public class ClientFactory {

    public static Client getClient(ClientDTO source){

        Client client = new Client();
        client.setDocumentType(EnumDocumentType.findById(source.getDocumentType()));
        client.setDocumentNum(source.getDocumentNum());
        client.setName(source.getName());
        client.setSurname(source.getSurname());
        client.setBirthDate(source.getBirthDate());
        client.setCreationDate(new Date());
        client.setEmail(source.getEmail());
        return client;
    }

    public static Client getClient(){
        return new Client();
    }
}
