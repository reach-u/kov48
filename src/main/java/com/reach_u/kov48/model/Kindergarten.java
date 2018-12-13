package com.reach_u.kov48.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kindergarten {

    private String name;

    private Coordinate crd;

    private int distance;

    private int capacity;

    private int waiting;
}
