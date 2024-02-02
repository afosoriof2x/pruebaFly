package co.com.pruebaFlypass.general.utils;

import co.com.pruebaFlypass.general.exception.AppException;
import org.apache.commons.validator.routines.EmailValidator;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Utils {

    public static  Boolean isValidEmail(String email) throws AppException {
        EmailValidator validator = EmailValidator.getInstance();
        return validator.isValid(email);
    }

    public static long getClientAge(Date birthDate){
        LocalDate today = LocalDate.now();
        LocalDate birth = birthDate.toInstant().
                atZone(ZoneId.systemDefault()).toLocalDate();

        return ChronoUnit.YEARS.between(birth, today);
    }


}
