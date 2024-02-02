package co.com.pruebaFlypass.factory;

import co.com.pruebaFlypass.dto.ClientDTO;
import co.com.pruebaFlypass.dto.ProductDTO;
import co.com.pruebaFlypass.general.enums.EnumDocumentType;
import co.com.pruebaFlypass.general.enums.EnumProductType;
import co.com.pruebaFlypass.model.Client;
import co.com.pruebaFlypass.model.Product;

import java.util.Date;

public class ProductFactory {

    public static Product getProduct(ProductDTO source){

        Product product = new Product();
        product.setBalance(source.getBalance());
        product.setClient(source.getClient());
        product.setProductType(EnumProductType.findById(source.getProductType()));
        product.setProductNum(source.getProductNum());
        product.setEstatus(source.getEstatus());
        product.setCreationDate(new Date());
        return product;
    }

    public static Client getProduct(){
        return new Client();
    }
}
