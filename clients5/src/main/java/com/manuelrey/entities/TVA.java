package com.manuelrey.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("TVA")
public class TVA extends Taxe {
    public TVA() {
    }

    public TVA(String title, Date dateTaxe, double amount, Company company) {
        super(title, dateTaxe, amount, company);
    }
}
