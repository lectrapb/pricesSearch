package com.app.src.prices.domain.exception;

public enum ConstantBusinessException {

    NOT_FOUND_DATA("No se encontro data asocida a las entradas ", SystemCode.ER_BS);

    private String message;
    private String code;

    ConstantBusinessException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    private static class SystemCode{


        public static final String ER_BS = "ERB404-01";
    }


}
