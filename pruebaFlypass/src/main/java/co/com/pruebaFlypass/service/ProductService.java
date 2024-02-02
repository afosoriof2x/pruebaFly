package co.com.pruebaFlypass.service;

import co.com.pruebaFlypass.dto.ClientDTO;
import co.com.pruebaFlypass.dto.ProductDTO;
import co.com.pruebaFlypass.factory.ClientFactory;
import co.com.pruebaFlypass.factory.ProductFactory;
import co.com.pruebaFlypass.repository.ClientRepository;
import co.com.pruebaFlypass.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(ProductDTO productDTO){
        productRepository.save(ProductFactory.getProduct(productDTO));
    }
}
