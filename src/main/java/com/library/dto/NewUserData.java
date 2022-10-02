package com.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NewUserData {

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
