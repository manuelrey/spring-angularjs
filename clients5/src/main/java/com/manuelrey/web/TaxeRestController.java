package com.manuelrey.web;

import com.manuelrey.dao.CompanyRepository;
import com.manuelrey.entities.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TaxeRestController {
    @Autowired
    private CompanyRepository companyRepository;
    @RequestMapping(value="/companyList")
    public Page<Company> list(
            @RequestParam(name="keyWord", defaultValue = "")String keyWord,
            @RequestParam(name="page", defaultValue = "0")int page,
            @RequestParam(name="size", defaultValue = "5")int size){
        return companyRepository.search("%"+keyWord+"%", new PageRequest(page, size));
    }
}
