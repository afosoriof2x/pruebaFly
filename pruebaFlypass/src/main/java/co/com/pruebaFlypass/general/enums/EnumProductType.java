
package co.com.pruebaFlypass.general.enums;

import co.com.pruebaFlypass.dto.ProductTypeDTO;

import java.util.ArrayList;
import java.util.List;


public enum EnumProductType {
	AHORROS(1, "Ahorros"),
	CORRIENTE(2, "Corriente");

	private int id;
	private String descripcion;

	private EnumProductType(int id,   String descripcion) {
		this.id = id;
		this.descripcion = descripcion;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public static EnumProductType findById(Integer idTipoDoc) {
		EnumProductType target = null;
		for (EnumProductType source : EnumProductType.values()) {
			if (source.getId() == idTipoDoc) {
				target = source;
				break;
			}
		}
		return target;
	}

	public static List<EnumProductType> findAll() {
		List<EnumProductType> returnList = new ArrayList<>();
		for (EnumProductType documentType : EnumProductType.values()) {
				returnList.add(documentType);
		}
		return returnList;
	}

	public static List<ProductTypeDTO> getListDTO(){

		List<EnumProductType> list = findAll();
		List<ProductTypeDTO> returnList = new ArrayList<>();

		for (EnumProductType enumProductType : EnumProductType.values()) {
			ProductTypeDTO productTypeDTO = new ProductTypeDTO();
			productTypeDTO.setId(enumProductType.getId());
			productTypeDTO.setDescription(enumProductType.getDescripcion());

			returnList.add(productTypeDTO);
		}
		return returnList;
	}
}
