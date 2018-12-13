package com.reach_u.kov48.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    private String city;

    private String street;

    private String house;

    private Coordinate crd;

}
