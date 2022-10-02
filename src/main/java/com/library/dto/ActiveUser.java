package com.library.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActiveUser {

    private Integer id;
    private String login;
    private String password;
    private String name;
    private String lastName;
    private String email;

    private String city;
    private String country;
    private String street;
    private String zipCode;
    private String buildingNumber;
    private String apartmentNumber;
}
