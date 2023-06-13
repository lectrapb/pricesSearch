package com.app.src.prices_search.shared.infra;

import com.app.src.prices_search.application.SearchPriceUseCase;
import com.app.src.prices_search.domain.search.gateway.SearchPrice;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasePriceConfig {

    @Bean
    public SearchPriceUseCase searchPriceUseCase(SearchPrice searchPrice){

        return new SearchPriceUseCase(searchPrice);
    }
}
