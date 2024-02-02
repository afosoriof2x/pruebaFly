package co.com.pruebaFlypass.service;

import co.com.pruebaFlypass.dto.ClientDTO;
import co.com.pruebaFlypass.dto.ProductDTO;
import co.com.pruebaFlypass.factory.ProductFactory;
import co.com.pruebaFlypass.general.enums.EnumProductType;
import co.com.pruebaFlypass.general.exception.AppException;
import co.com.pruebaFlypass.model.Client;
import co.com.pruebaFlypass.model.Product;
import co.com.pruebaFlypass.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(ProductDTO productDTO) throws AppException {
        productValidation(productDTO);
        productRepository.save(ProductFactory.getProduct(productDTO));
    }

    public List<ProductDTO> getProductsById(Long clientId) {

        Iterable<Product> list = productRepository.findByClient(clientId);
        List<ProductDTO> clientList = new ArrayList<>();

        list.forEach(product->{
            ProductDTO dto = product.getDto();
            clientList.add(dto);
        });

        return clientList;
    }

    private void productValidation(ProductDTO productDTO) throws AppException {

        if(Objects.isNull(productDTO.getClient())){
            throw new AppException("Cliente no puede ser nulo.");
        }
        if(Objects.isNull(productDTO.getProductType())){
            throw new AppException("Tipo de cuenta no puede ser nulo.");
        }
        if(Objects.isNull(productDTO.getBalance())){
            throw new AppException("El saldo no puede ser nulo.");
        }
        if(Objects.isNull(productDTO.getStatus())){
            throw new AppException("El estado no puede ser nulo.");
        }
        if(Objects.isNull(productDTO.getExempt())){
            throw new AppException("El campo exento GMF no puede ser nulo.");
        }
        if(!isValidProductType(productDTO.getProductType())){
            throw new AppException("El tipo de cuenta no es válido.");
        }
    }

    private static Boolean isValidProductType(Integer productType) {
        return Objects.isNull(EnumProductType.findById(productType)) ? Boolean.FALSE : Boolean.TRUE;
    }
}
