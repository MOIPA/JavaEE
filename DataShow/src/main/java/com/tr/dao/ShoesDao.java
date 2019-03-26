package com.tr.dao;

import com.tr.domain.Shoe;
import com.tr.vo.SoldPercentageVO;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShoesDao extends JpaRepository<Shoe, Integer> {

    @Query(value = "select * from DataSet where sid=10",nativeQuery = true)
    Shoe findAllByQueryFunc();


//    @Query(value = "FROM Shoe " +
//            "       WHERE pricesAmountMax>=1000 " +
//            "       GROUP BY expensiveBrand " +
//            "       ORDER BY pricesAmountMax DESC ")
//    List<Shoe> getExpensiveBrandPrice(PageRequest of);

    @Query(value ="SELECT * " +
            "   FROM DataSet" +
            "   WHERE prices_amount_max>=700" +
            "   GROUP BY brand" +
            "   ORDER BY prices_amount_max DESC",nativeQuery = true)
    List<Shoe> getExpensiveBrandPrice(Pageable pageable);

    @Query(value = "SELECT prices_is_sale,CONCAT(ROUND(COUNT(prices_is_sale)/(SELECT COUNT(prices_is_sale) FROM DataSet)*100,2),'%')" +
            "   FROM DataSet" +
            "   GROUP BY prices_is_sale",nativeQuery = true)
    List<Object[]> getSoldPercentage();

    @Query(value = "SELECT brand,COUNT(brand) AS 'number'" +
            "   FROM DataSet" +
            "   WHERE prices_is_sale='TRUE'" +
            "   GROUP BY brand" +
            "   ORDER BY COUNT(brand) DESC",nativeQuery = true)
    List<Object[]> getSoldBrandNumber(Pageable pageable);

    @Query(value = "SELECT brand,ROUND(COUNT(*) * (prices_amount_max+prices_amount_min) / COUNT(*)*2,2) AS avgprise" +
            "   FROM DataSet" +
            "   GROUP BY brand" +
            "   ORDER BY avgprise DESC"
            ,nativeQuery = true)
    List<Object[]> getBrandAvgPrice(PageRequest of);

    @Query(value = "SELECT prices_merchant,COUNT(prices_merchant) AS 'number'" +
            "   FROM DataSet" +
            "   GROUP BY prices_merchant" +
            "   ORDER BY COUNT(prices_merchant)DESC",nativeQuery = true)
    List<Object[]> getMerchantNumber(Pageable pageable);

    @Query(value = "SELECT (CASE\n" +
            "          WHEN prices_amount_max >0 AND prices_amount_max<= 50 THEN '0~50'" +
            "          WHEN prices_amount_max >50 AND prices_amount_max<= 100 THEN '50~100'" +
            "          WHEN prices_amount_max >100 AND prices_amount_max<= 150 THEN '100~150'" +
            "          WHEN prices_amount_max >150 AND prices_amount_max<= 200 THEN '150~200'" +
            "          WHEN prices_amount_max >200 AND prices_amount_max<= 250 THEN '200~250'" +
            "          ELSE '250以上' END) AS 'priceInterval',\n" +
            "       COUNT(*) AS 'number' FROM DataSet\n" +
            "       GROUP BY (CASE\n" +
            "            WHEN prices_amount_max >0 AND prices_amount_max<= 50 THEN '0~50'" +
            "            WHEN prices_amount_max >50 AND prices_amount_max<= 100 THEN '50~100'" +
            "            WHEN prices_amount_max >100 AND prices_amount_max<= 150 THEN '100~150'" +
            "            WHEN prices_amount_max >150 AND prices_amount_max<= 200 THEN '150~200'" +
            "            WHEN prices_amount_max >200 AND prices_amount_max<= 250 THEN '200~250'" +
            "            ELSE '250以上'  END)",nativeQuery = true)
    List<Object[]> getDiffPriceInterverNumber(PageRequest of);
}
