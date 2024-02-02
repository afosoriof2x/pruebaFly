
package co.com.pruebaFlypass.model;

import co.com.pruebaFlypass.dto.ClientDTO;
import co.com.pruebaFlypass.general.enums.EnumDocumentType;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "pr_clientes")
public class Client extends Model<ClientDTO> {

	@Id
	@GeneratedValue
	@Column(name = "CDCLIENTE")
	private long id;

	@Enumerated
	@Column(name = "CDTIPO_DOC")
	private EnumDocumentType documentType;

	@Column(name = "DSNRO_DOC")
	private Integer documentNum;

	@Column(name = "DSNOMBRE")
	private String name;

	@Column(name = "DSAPELLIDO")
	private String surname;

	@Column(name = "DSCORREO")
	private String email;

	@Column(name = "FENACIMIENTO")
	private Date birthDate;

	@Column(name = "FECREACION")
	private  Date creationDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public EnumDocumentType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(EnumDocumentType documentType) {
		this.documentType = documentType;
	}

	public Integer getDocumentNum() {
		return documentNum;
	}

	public void setDocumentNum(Integer documentNum) {
		this.documentNum = documentNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public Class<ClientDTO> getDtoClass() {
		return null;
	}
}
