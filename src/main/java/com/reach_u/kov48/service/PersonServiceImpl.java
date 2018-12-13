package com.reach_u.kov48.service;

import com.reach_u.kov48.model.Person;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {

    @Override
    public Person findByIdCode(long idCode) {
        Person person = new Person();
        person.setIdCode(idCode);
        return person;
    }
}
