package co.com.pruebaFlypass.dto;

import co.com.pruebaFlypass.general.enums.EnumProductType;
import co.com.pruebaFlypass.general.utils.BooleanToStringConverter;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
public class ProductDTO extends DTO{

    private Integer productType;

    private Integer productNum;

    private String estatus;

    private String balance;

    private Boolean exempt;

    private Date creationDate;

    private long client;

}
