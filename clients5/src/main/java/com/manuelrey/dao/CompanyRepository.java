package com.manuelrey.dao;


import com.manuelrey.entities.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("select c from Company c where c.name like :x ")
    public Page<Company> search(@Param("x")String c, Pageable pageable);
}
