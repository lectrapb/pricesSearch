package com.app.src.shared.domain;

public enum ConstanSystemException {

    REQUIRE_ARGUMENT("Faltan Parametros Obligatorios", SystemCode.ER401),
    BAD_FORMAT_DATE("La fecha no sigue el formato yyyy-MM-dd HH.mm.ss ", SystemCode.ER402),
    BAD_FORMAT_ID("Identificador nulo o fuera de rango ", SystemCode.ER403);

    private String message;
    private String code;

    ConstanSystemException(String message, String code) {
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

        public static final String ER401 = "ER401";
        public static final String ER402 = "ER402";
        public static final String ER403 = "ER403";
    }


}
