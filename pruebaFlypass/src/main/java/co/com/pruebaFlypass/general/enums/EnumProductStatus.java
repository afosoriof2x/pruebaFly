
package co.com.pruebaFlypass.general.enums;

import co.com.pruebaFlypass.dto.ProductTypeDTO;

import java.util.ArrayList;
import java.util.List;


public enum EnumProductStatus {

	INACTIVE(0, "Inactiva"),
	ACTIV(1, "Activa");


	private int id;
	private String descripcion;

	private EnumProductStatus(int id, String descripcion) {
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

	public static EnumProductStatus findById(Integer idTipoDoc) {
		EnumProductStatus target = null;
		for (EnumProductStatus source : EnumProductStatus.values()) {
			if (source.getId() == idTipoDoc) {
				target = source;
				break;
			}
		}
		return target;
	}

	public static List<EnumProductStatus> findAll() {
		List<EnumProductStatus> returnList = new ArrayList<>();
		for (EnumProductStatus documentType : EnumProductStatus.values()) {
				returnList.add(documentType);
		}
		return returnList;
	}

}
