package com.reach_u.kov48.service;

import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Person;

import java.util.Collection;

public interface ChildService {

    Collection<Child> findChildren(Person parent);

    /**
     * Finds child by ID code. Method throws exception if child not found or specified person is not child's parent
     *
     * @param idCode Child ID code
     * @param parent parent
     * @return child
     */
    Child findChild(long idCode, Person parent);

    void confirmFather(Person father, long childIdCode);

}
