package co.com.pruebaFlypass.factory;

import co.com.pruebaFlypass.dto.ProductDTO;
import co.com.pruebaFlypass.general.enums.EnumProductStatus;
import co.com.pruebaFlypass.general.enums.EnumProductType;
import co.com.pruebaFlypass.model.Client;
import co.com.pruebaFlypass.model.Product;

import java.util.Date;
import java.util.UUID;

public class ProductFactory {
    private final static String SUFIX_AHORROS  = "46";
    private final  static String SUFIX_CORRIENTE  = "23";

    public static Product getProduct(ProductDTO source){

        Product product = new Product();
        product.setBalance(source.getBalance());
        product.setClient(source.getClient());
        product.setProductType(EnumProductType.findById(source.getProductType()));
        product.setEstatus(EnumProductStatus.findById(source.getStatus()));
        product.setCreationDate(new Date());
        product.setProductNum(getCodeByProductType(product.getProductType()));

        return product;
    }

    private static String getCodeByProductType(EnumProductType enumProductType){
        String sufix = EnumProductType.AHORROS.equals(enumProductType) ? SUFIX_AHORROS : SUFIX_CORRIENTE;
        String code = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 8);
        return sufix.concat(code);

    }
    public static Client getProduct(){
        return new Client();
    }
}
