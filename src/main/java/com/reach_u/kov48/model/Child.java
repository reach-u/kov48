package com.reach_u.kov48.model;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;

@Data
public class Child extends Person {

    private Person mother;

    private Person father;

    private boolean fatherConfirmed;

    private ArrayList<Kindergarten> kindergartens = Lists.newArrayList();

    private Support support;

    public boolean isParent(Person person) {
        return person.getIdCode() == mother.getIdCode() || person.getIdCode() == father.getIdCode();
    }

}
