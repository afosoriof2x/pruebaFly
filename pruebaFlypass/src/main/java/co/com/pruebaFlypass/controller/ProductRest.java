package co.com.pruebaFlypass.controller;

import co.com.pruebaFlypass.general.Response;
import co.com.pruebaFlypass.dto.ProductDTO;
import co.com.pruebaFlypass.general.exception.AppException;
import co.com.pruebaFlypass.service.ProductService;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/product")
public class ProductRest {

    private static final Logger logger = LogManager.getLogger(ProductRest.class);

    private final ProductService productService;

    public ProductRest(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/{id}")
    public Response<Object> get(@PathVariable Long id){

        List<ProductDTO> productList = productService.getProductsById(id);
        return new Response<>(HttpServletResponse.SC_OK, "", productList);
    }

    @PostMapping()
    public Response<Object> post(@RequestBody ProductDTO productDTO) throws AppException {

        productService.save(productDTO);
        logger.info("Name:, {}", productDTO.getProductType());
        return new Response<>(HttpServletResponse.SC_OK, "", 2);
    }

}
