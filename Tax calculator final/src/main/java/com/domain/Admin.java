package com.domain;


import javax.persistence.*;

@Entity
@Table(name="adminTable")
public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Integer ID;




    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;









    public Admin(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Admin() {

    }






    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }



    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }




}
