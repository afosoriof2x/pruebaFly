package co.com.pruebaFlypass.controller;

import co.com.pruebaFlypass.dto.ClientDTO;
import co.com.pruebaFlypass.general.Response;
import co.com.pruebaFlypass.general.exception.AppException;
import co.com.pruebaFlypass.service.ClientService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/client")
public class ClientRest {

    private static final Logger logger = LogManager.getLogger(ClientRest.class);
    private final ClientService clientService;

    public ClientRest(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Response<Object> get(){
        List<ClientDTO> listClients = clientService.getClients();
        return new Response<>(HttpServletResponse.SC_OK, "Clientes", listClients);
    }

    @PostMapping()
    public Response<Object> post(@RequestBody ClientDTO clientDTO) throws AppException {

        clientService.save(clientDTO);
        return new Response<>(HttpServletResponse.SC_OK);
    }

}
