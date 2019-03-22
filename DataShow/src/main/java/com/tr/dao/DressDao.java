package com.tr.dao;

import com.tr.domain.Dress;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface DressDao extends JpaRepository<Dress, String> {

    @Query(value = "select * from PythonRepo where attitudes=(select max(attitudes) from PythonRepo)",nativeQuery = true)
    Dress getMostLikedDress(PageRequest of);
}
