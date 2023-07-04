package com.app.src.prices.infra.database.serach.infra;


import com.app.src.prices.infra.database.serach.domain.PriceProductData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PriceRepositoryJpa extends JpaRepository<PriceProductData, Long> {


    @Query(value="SELECT  e "+
                    " FROM PriceProductData e WHERE e.productId = :productId AND "+
                    " e.brand.brandId = :brandId AND "+
                    " e.startDate <= :dateTest AND e.endDate >= :dateTest ORDER BY e.priority DESC")
    List<PriceProductData> searchPrice(@Param("dateTest") Date dateToTest,
                                       @Param("productId") Long productId,
                                       @Param("brandId") Long brandId);
}
