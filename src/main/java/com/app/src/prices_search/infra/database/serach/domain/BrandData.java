package com.app.src.prices_search.infra.database.serach.domain;


import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "BRANDS")
public class BrandData {

    @Id
    @Column(name = "BRAND_ID")
    private Long brandId;

    @Column(name="BRAND_NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "brand", cascade = CascadeType.ALL)
    private List<PriceProductData> prices;



}
