package com.manuelrey;

import com.manuelrey.dao.CompanyRepository;
import com.manuelrey.dao.TaxeRepository;
import com.manuelrey.entities.Company;
import com.manuelrey.entities.IR;
import com.manuelrey.entities.TVA;
import com.manuelrey.entities.Taxe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class Clients5Application implements CommandLineRunner {
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private TaxeRepository taxeRepository;
	public static void main(String[] args) {
		SpringApplication.run(Clients5Application.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Company c1=companyRepository.save(new Company("a1", "a1@gmail.com", "aaa"));
		Company c2=companyRepository.save(new Company("a2", "a2@gmail.com", "aaa"));

		taxeRepository.save(new TVA("TVA Room",new Date(), 900, c1));
        taxeRepository.save(new TVA("TVA Car",new Date(), 8000, c1));
        taxeRepository.save(new IR("IR 2222",new Date(), 2000, c1));
        taxeRepository.save(new TVA("TVA Room",new Date(), 500, c2));
	}
}
