
package co.com.pruebaFlypass.model;

import co.com.pruebaFlypass.dto.ClientDTO;
import co.com.pruebaFlypass.dto.ProductDTO;
import co.com.pruebaFlypass.general.enums.EnumDocumentType;
import co.com.pruebaFlypass.general.enums.EnumProductStatus;
import co.com.pruebaFlypass.general.enums.EnumProductType;
import co.com.pruebaFlypass.general.utils.BooleanToStringConverter;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "pr_productos")
public class Product extends Model<ProductDTO> {

	@Id
	@GeneratedValue
	@Column(name = "CDPRODUCTO")
	private long id;

	@Enumerated
	@Column(name = "CDTIPO_CUENTA")
	private EnumProductType productType;

	@Column(name = "DSNRO_CUENTA")
	private String productNum;

	@Enumerated
	@Column(name = "CDESTADO")
	private EnumProductStatus estatus;

	@Column(name = "DSSALDO")
	private String balance;

	@Column(name = "SNEXENTA_GMF")
	@Convert(converter = BooleanToStringConverter.class)
	private Boolean exempt;

	@Column(name = "FECREACION")
	private Date creationDate;

	@Column(name = "CDCLIENTE")
	private long client;


	public long getClient() {
		return client;
	}

	public void setClient(long client) {
		this.client = client;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EnumProductType getProductType() {
		return productType;
	}

	public void setProductType(EnumProductType productType) {
		this.productType = productType;
	}

	public String getProductNum() {
		return productNum;
	}

	public void setProductNum(String productNum) {
		this.productNum = productNum;
	}

	public EnumProductStatus getEstatus() {
		return estatus;
	}

	public void setEstatus(EnumProductStatus estatus) {
		this.estatus = estatus;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public Boolean getExempt() {
		return exempt;
	}

	public void setExempt(Boolean exempt) {
		this.exempt = exempt;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	@Override
	public Class<ProductDTO> getDtoClass() {
		return ProductDTO.class;
	}

	@Override
	public ProductDTO getDto(){
		ProductDTO dto = super.getDto();
		return dto;
	}
}
