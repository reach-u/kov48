package com.reach_u.kov48.model;

import lombok.Data;

@Data
public class Child extends Person {

    private Person mother;

    private Person father;

    private boolean fatherConfirmed;

    public boolean isParent(Person person) {
        return person.getIdCode() == mother.getIdCode() || person.getIdCode() == father.getIdCode();
    }

}
