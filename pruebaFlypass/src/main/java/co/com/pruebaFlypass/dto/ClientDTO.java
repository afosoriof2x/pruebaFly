package co.com.pruebaFlypass.dto;

import lombok.*;

import java.util.Date;


@Setter
@Getter
public class ClientDTO extends DTO{

    private Integer documentType;

    private Integer documentNum;

    private String name;

    private String surname;

    private String email;

    private Date birthDate;

    private  Date creationDate;

}
