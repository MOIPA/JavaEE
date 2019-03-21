package com.tr.dao;

import com.tr.domain.Shoe;
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
            "   WHERE prices_amount_max>=1000" +
            "   GROUP BY brand" +
            "   ORDER BY prices_amount_max DESC",nativeQuery = true)
    List<Shoe> getExpensiveBrandPrice(Pageable pageable);
}
