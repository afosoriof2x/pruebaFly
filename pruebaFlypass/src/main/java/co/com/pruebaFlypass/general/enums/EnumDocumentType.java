
package co.com.pruebaFlypass.general.enums;

import co.com.pruebaFlypass.dto.DocumentTypeDTO;

import java.util.ArrayList;
import java.util.List;


public enum EnumDocumentType {
	CC(0,  "Cédula de ciudadanía"),
	CE(1, "Cédula de extranjería"),
	NIT(2,   "Nit");

	private int id;
	private String description;

	private EnumDocumentType(int id,String description) {
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static EnumDocumentType findById(Integer idDocumentType) {
		EnumDocumentType target = null;

		for (EnumDocumentType source : EnumDocumentType.values()) {
			if (source.getId() == idDocumentType) {
				target = source;
				break;
			}
		}
		return target;
	}

	public static List<EnumDocumentType> findAll() {
		List<EnumDocumentType> returnList = new ArrayList<>();
		for (EnumDocumentType documentType : EnumDocumentType.values()) {
				returnList.add(documentType);
		}
		return returnList;
	}

	public static List<DocumentTypeDTO> getListDTO(){

		List<EnumDocumentType> list = findAll();
		List<DocumentTypeDTO> returnList = new ArrayList<>();
		for (EnumDocumentType documentType : EnumDocumentType.values()) {

			DocumentTypeDTO documentTypeDTO = new DocumentTypeDTO();
			documentTypeDTO.setId(documentType.getId());
			documentTypeDTO.setDescription(documentType.getDescription());
			returnList.add(documentTypeDTO);
		}
		return returnList;

	}
}
