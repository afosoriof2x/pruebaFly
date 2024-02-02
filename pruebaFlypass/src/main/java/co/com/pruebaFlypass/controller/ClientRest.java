package co.com.pruebaFlypass.controller;

import co.com.pruebaFlypass.dto.ClientDTO;
import co.com.pruebaFlypass.Response;
import co.com.pruebaFlypass.general.exception.AppException;
import co.com.pruebaFlypass.service.ClientService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/client")
public class ClientRest {

    private static final Logger logger = LogManager.getLogger(ClientRest.class);

    private final ClientService clientService;

    public ClientRest(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping(value = "/{id}")
    public Response<Object> get(@PathVariable String id){
        logger.info("ID:, {}",id);
        ClientDTO clientDTO = new ClientDTO();
        clientDTO.setName("Prueba Response");
        return new Response<>(HttpServletResponse.SC_OK, "", clientDTO);
    }

    @PostMapping()
    public Response<Object> post(@RequestBody ClientDTO clientDTO) throws AppException {

        clientService.save(clientDTO);
        logger.info("Name:, {}", clientDTO.getName());
        return new Response<>(HttpServletResponse.SC_OK, "", 2);
    }

}
