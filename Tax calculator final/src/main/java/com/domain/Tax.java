package com.domain;

import javax.persistence.*;

@Entity
@Table(name = "taxcalculator")
public class Tax {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email")
    private String email;


    @Column(name = "total")
    private Long total;





    public String geteMail() {
        return email;
    }

    public void setId(String email) {
        this.email = email;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }



}
