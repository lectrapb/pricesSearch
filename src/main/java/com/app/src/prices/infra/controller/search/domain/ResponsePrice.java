package com.app.src.prices.infra.controller.search.domain;

import com.app.src.prices.infra.controller.search.domain.ResponsePriceData;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponsePrice {

     private ResponsePriceData data;
}
