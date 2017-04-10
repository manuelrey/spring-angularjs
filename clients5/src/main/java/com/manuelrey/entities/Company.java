package com.manuelrey.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
@Entity
public class Company implements Serializable{
    @Id @GeneratedValue
    private Long code;
    @NotEmpty
    @Size(min=2, max=20)
    private String name;
    @NotEmpty
    private String email;
    @NotEmpty
    @Size(min=2, max=30)
    private String socialReason;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private Collection<Taxe> taxes;

    public Company() {
    }

    public Company(String name, String email, String socialReason) {
        this.name = name;
        this.email = email;
        this.socialReason = socialReason;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialReason() {
        return socialReason;
    }

    public void setSocialReason(String socialReason) {
        this.socialReason = socialReason;
    }

    @JsonIgnore
    public Collection<Taxe> getTaxes() {
        return taxes;
    }

    public void setTaxes(Collection<Taxe> taxes) {
        this.taxes = taxes;
    }
}
