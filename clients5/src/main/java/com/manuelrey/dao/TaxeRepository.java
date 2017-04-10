package com.manuelrey.dao;

import com.manuelrey.entities.Company;
import com.manuelrey.entities.Taxe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface TaxeRepository extends JpaRepository<Taxe, Long> {

    public List<Taxe> findByCompany(Company c);
}
