package com.app.application.backoffice_prices.rest.shared.aplication;

import com.app.application.backoffice_prices.rest.shared.domain.ErrorApp;
import com.app.src.shared.domain.ConstanBusinessException;
import com.app.src.shared.domain.ConstanSystemException;

import java.util.HashMap;
import java.util.Map;

public final class ExceptionService {

    private ExceptionService() {
    }

    private static Map<String, ErrorApp> errorMessages = new HashMap<>();

    static {
        errorMessages.put(ConstanBusinessException.NOT_FOUND_DATA.getCode(),
                new ErrorApp(ConstanBusinessException.NOT_FOUND_DATA.getCode(),
                        ConstanBusinessException.NOT_FOUND_DATA.getMessage()));

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
