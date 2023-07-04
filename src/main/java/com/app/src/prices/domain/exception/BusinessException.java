package com.app.src.prices.domain.exception;

public class BusinessException extends RuntimeException {

    public BusinessException(ConstanSystemException message) {

        super(message.getCode());
    }

    public BusinessException(ConstantBusinessException message) {
        super(message.getCode());
    }
}
