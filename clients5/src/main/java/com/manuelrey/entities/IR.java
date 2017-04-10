package com.manuelrey.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.Date;

@Entity
@DiscriminatorValue("IR")
public class IR extends Taxe {
    public IR() {
    }

    public IR(String title, Date dateTaxe, double amount, Company company) {
        super(title, dateTaxe, amount, company);
    }
}
