package com.app.src.prices.shared.infra;

import com.app.src.prices.application.SearchPrice;
import com.app.src.prices.domain.search.SearchPriceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCasePriceConfig {

    @Bean
    public SearchPrice searchPriceUseCase(SearchPriceRepository searchPrice){

        return new SearchPrice(searchPrice);
    }
}
