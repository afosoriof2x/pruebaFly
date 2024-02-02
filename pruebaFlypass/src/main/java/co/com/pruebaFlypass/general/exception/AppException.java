package co.com.pruebaFlypass.general.exception;

import co.com.pruebaFlypass.general.ResponseCodes;
import co.com.pruebaFlypass.general.utils.ResponseObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppException extends Exception {
    private static final Logger logger = LogManager.getLogger(AppException.class);

    private String msg;

    @Autowired
    private MessageSource messageSource;

    public AppException(String message) {
        this.msg = message;
        logger.error(message);
    }

    public AppException() {
    }

    @ExceptionHandler(AppException.class)
    public ResponseEntity<Object> processValidationException(AppException e) {

        return buildResponseEntity(
                new ResponseObject<>(ResponseCodes.BAD_REQUEST,
                        e.getExceptionMessage()),
                HttpStatus.BAD_REQUEST); }


    private ResponseEntity<Object> buildResponseEntity(ResponseObject<Void> responseObject, HttpStatus status) {
        return new ResponseEntity<>(responseObject, status);
    }

    public String getExceptionMessage() {
        return this.msg != null ? this.msg : messageSource.getMessage("validationError", null, LocaleContextHolder.getLocale());
    }
}
