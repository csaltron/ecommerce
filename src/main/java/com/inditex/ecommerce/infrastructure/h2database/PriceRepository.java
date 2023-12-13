package com.inditex.ecommerce.infrastructure.h2database;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.util.List;


public interface PriceRepository extends JpaRepository<PriceEntity, Long> {

	@Query("SELECT T " +
			" FROM PriceEntity T " +
			"INNER JOIN BRANDS B ON T.BRAND_ID = B.BRAND_ID " +
			"INNER JOIN PRODUCTS P ON T.PRODUCT_ID = P.PRODUCT_ID " +
			"WHERE :applicationDate BETWEEN startDate AND endDate) " +
			"  AND productId = :productId AND brandId = :brandId")
	List<PriceEntity> find(Long brandId, Long productId, LocalDate applicationDate);

}
