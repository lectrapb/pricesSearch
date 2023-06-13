package com.app.src.shared.domain;

public class BusinessException extends RuntimeException {

    public BusinessException(ConstanSystemException message) {

        super(message.getCode());
    }

    public BusinessException(ConstanBusinessException message) {
        super(message.getCode());
    }
}
