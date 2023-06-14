package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 10)
    private String username;

    @Column(length = 20)
    private String passwword;

    public Account(String username, String passwword) {
        this.username = username;
        this.passwword = passwword;
    }
}
