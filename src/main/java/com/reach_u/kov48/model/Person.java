package com.reach_u.kov48.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;

@RequiredArgsConstructor
@Data
public class Person {

    private long idCode;

    private String firstName;

    private String lastName;

    private char sex;

    private Date dateOfBirth;

    private String birthPlace;

    private Address address;

    private long phone;

}
