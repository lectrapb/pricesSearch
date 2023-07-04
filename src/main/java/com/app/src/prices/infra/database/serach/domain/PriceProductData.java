package com.app.src.prices.infra.database.serach.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "prices")
public class PriceProductData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private BrandData brand;
    @Column(name = "START_DATE")
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;
    @Column(name = "PRICE_LIST")
    private Long priceList;
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "PRIORITY")
    private Long priority;
    @Column(name ="PRICE")
    private Double price;
    @Column(name = "CURR")
    private String currency;
}
