package co.com.pruebaFlypass.model;


import co.com.pruebaFlypass.dto.DTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

public abstract class Model<T extends DTO> {

	private static final Logger logger = LoggerFactory.getLogger(Model.class);

	public T getDto() {
		try {
			T dto = this.getDtoClass().newInstance();
			BeanUtils.copyProperties(this, dto);
			return dto;
		} catch (InstantiationException | IllegalAccessException | NullPointerException e) {
			logger.info(e.getMessage());
		}
		return null;
	}

	public abstract Class<T> getDtoClass();

}
