package com.app.src.prices.infra.controller.shared.aplication;

import com.app.src.prices.infra.controller.shared.domain.ErrorApp;
import com.app.src.prices.domain.exception.ConstantBusinessException;
import com.app.src.prices.domain.exception.ConstanSystemException;

import java.util.HashMap;
import java.util.Map;

public final class ExceptionService {

    private ExceptionService() {
    }

    private static Map<String, ErrorApp> errorMessages = new HashMap<>();

    static {
        errorMessages.put(ConstantBusinessException.NOT_FOUND_DATA.getCode(),
                new ErrorApp(ConstantBusinessException.NOT_FOUND_DATA.getCode(),
                        ConstantBusinessException.NOT_FOUND_DATA.getMessage()));

        errorMessages.put(ConstanSystemException.REQUIRE_ARGUMENT.getCode(),
                new ErrorApp(ConstanSystemException.REQUIRE_ARGUMENT.getCode(),
                        ConstanSystemException.REQUIRE_ARGUMENT.getMessage()));

        errorMessages.put(ConstanSystemException.BAD_FORMAT_DATE.getCode(),
                new ErrorApp(ConstanSystemException.BAD_FORMAT_DATE.getCode(),
                        ConstanSystemException.BAD_FORMAT_DATE.getMessage()));

        errorMessages.put(ConstanSystemException.BAD_FORMAT_ID.getCode(),
                new ErrorApp(ConstanSystemException.BAD_FORMAT_ID.getCode(),
                        ConstanSystemException.BAD_FORMAT_ID.getMessage()));
    }
    public static ErrorApp getErrorMessage(String key){
        return errorMessages.get(key);
    }
}
