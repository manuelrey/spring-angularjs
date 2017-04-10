package com.manuelrey.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE", discriminatorType = DiscriminatorType.STRING, length = 4)
public abstract class Taxe implements Serializable {
    @Id @GeneratedValue
    private Long id;
    private String Title;
    private Date dateTaxe;
    private double amount;
    @ManyToOne
    @JoinColumn(name = "CODE_COMPANY")
    private Company company;

    public Taxe() {
    }

    public Taxe(String title, Date dateTaxe, double amount, Company company) {
        this.Title = title;
        this.dateTaxe = dateTaxe;
        this.amount = amount;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getDateTaxe() {
        return dateTaxe;
    }

    public void setDateTaxe(Date dateTaxe) {
        this.dateTaxe = dateTaxe;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
