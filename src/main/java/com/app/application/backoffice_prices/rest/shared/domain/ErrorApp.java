package com.app.application.backoffice_prices.rest.shared.domain;

import com.app.src.prices_search.shared.domain.BusinessConstant;
import lombok.Data;

import java.util.UUID;

@Data
public class ErrorApp {

    private final String id;
    private final String code;
    private final String title;
    private final String detail;

    public ErrorApp(String code, String detail) {
        this.id = UUID.randomUUID().toString();
        this.code = code;
        this.title = BusinessConstant.FAILED_TRANSACTION_TITLE;
        this.detail = detail;
    }
}
