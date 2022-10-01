package com.library.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String login;
    private String password;
    private String name;
    private String lastName;
    private String email;
    @OneToOne
    private Address address;

    @OneToMany
    private List<Rental> rental;

    @Enumerated(value = EnumType.STRING)
    @ManyToMany
    @JoinTable(name = "ROLE_USER",
    joinColumns = @JoinColumn(name = "ROLE_ID"),
    inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private List<Role> roles;





}
