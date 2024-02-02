package co.com.pruebaFlypass.general.utils;


import co.com.pruebaFlypass.general.ResponseCodes;

public class ResponseObject<T> {

    private String code;
    private String message;
    private T body;
    public ResponseObject(T body) {
        this.body = body;
        this.code = ResponseCodes.REQUEST_SUCCESS_CODE;
        this.message = ResponseCodes.REQUEST_SUCCESS_MESSAGE;
    }

    public ResponseObject(String code, String message) {
        this.code = code;
        this.message = message;
    }
    public ResponseObject(T body, String code, String message) {
        this.body = body;
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
