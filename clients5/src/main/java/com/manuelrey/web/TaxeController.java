package com.manuelrey.web;

import com.manuelrey.dao.CompanyRepository;
import com.manuelrey.dao.TaxeRepository;
import com.manuelrey.entities.Company;
import com.manuelrey.entities.Taxe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TaxeController {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private TaxeRepository taxeRepository;

    @RequestMapping(value = "/companies", method = RequestMethod.GET)
    public String index(Model model,
                        @RequestParam(name="keyWord", defaultValue = "")String keyWord,
                        @RequestParam(name="page", defaultValue = "0")int p,
                        @RequestParam(name="size", defaultValue = "5")int s){
        Page<Company> pageCompanies=companyRepository.search("%"+keyWord+"%",new PageRequest(p,s));
        model.addAttribute("companiesList", pageCompanies.getContent());
        int[] pages = new int[pageCompanies.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("currentPage", p);
        model.addAttribute("keyWord", keyWord);
        return "companies";
    }

    @RequestMapping(value="/addCompany")
    public String add(Model model){
        model.addAttribute("company", new Company());
        return "addCompany";
    }

    @RequestMapping(value="/saveCompany")
    public String save(Model model, @Valid Company c, BindingResult bindingResult){
        if (bindingResult.hasErrors())
            return "addCompany";
        companyRepository.save(c);
        return "redirect:/companies";
    }

    @RequestMapping(value="/taxes")
    public String taxes(Model model, @RequestParam(name="code", defaultValue = "-1") Long code){
        model.addAttribute("companies", companyRepository.findAll());
        if(code==-1) model.addAttribute("taxes", new ArrayList<Taxe>());
        else{

            Company c= new Company();
            c.setCode(code);

            model.addAttribute("taxes", taxeRepository.findByCompany(c));
        }

        return "taxes";
    }

}
