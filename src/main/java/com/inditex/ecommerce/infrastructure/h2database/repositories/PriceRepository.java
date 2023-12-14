package com.inditex.ecommerce.infrastructure.h2database.repositories;


import com.inditex.ecommerce.infrastructure.h2database.entities.PriceEntity;
import com.inditex.ecommerce.infrastructure.h2database.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


public interface PriceRepository extends JpaRepository<PriceEntity, ProductEntity> {

//	@Query("SELECT T " +
//			" FROM PriceEntity T " +
//			"INNER JOIN BRANDS B ON T.BRAND_ID = B.BRAND_ID " +
//			"INNER JOIN PRODUCTS P ON T.PRODUCT_ID = P.PRODUCT_ID " +
//			"WHERE :applicationDate BETWEEN START_DATE AND END_DATE " +
//			"  AND productId = :productId AND brandId = :brandId")

		@Query( value="SELECT t.PRICE_ID, t.BRAND_ID , START_DATE, END_DATE, PRICE_LIST, t.PRODUCT_ID, PRIORITY, PRICE, CURR " +
			" FROM PRICES t " +
			"INNER JOIN BRANDS b ON t.BRAND_ID = b.BRAND_ID " +
			"INNER JOIN PRODUCTS p ON t.PRODUCT_ID = p.PRODUCT_ID " +
			"WHERE :applicationDate BETWEEN START_DATE AND END_DATE " +
			"  AND t.PRODUCT_ID = :productId AND b.BRAND_ID = :brandId", nativeQuery = true)
	List<PriceEntity> find(Integer brandId, Integer productId, LocalDateTime applicationDate);

}
