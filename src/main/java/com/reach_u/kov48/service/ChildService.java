package com.reach_u.kov48.service;

import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Person;

import java.util.Collection;

public interface ChildService {

    Collection<Child> findChildren(Person parent);

    Child findChild(long idCode, Person parent);

    void confirmFather(Person father, long childIdCode);

}
