package com.reach_u.kov48.service;

import com.google.common.collect.Maps;
import com.reach_u.kov48.model.Address;
import com.reach_u.kov48.model.Coordinate;
import com.reach_u.kov48.model.Person;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Map;

@Service
public class PersonServiceImpl implements PersonService {

    private static final Map<Long, Person> PERSONS = Maps.newHashMap();

    static {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 7);
        calendar.set(Calendar.YEAR, 1992);

        Address address = new Address("Tartu", "Herne", "11", new Coordinate(58.384948, 26.717172));

        Person juta = new Person();
        juta.setIdCode(49200000000L);
        juta.setFirstName("Juta");
        juta.setLastName("Tamm");
        juta.setBirthPlace("Tartu");
        juta.setSex('F');
        juta.setPhone(50112233L);
        juta.setDateOfBirth(calendar.getTime());
        juta.setAddress(address);
        juta.setPhone(50123456);

        calendar.set(Calendar.DAY_OF_MONTH, 22);
        calendar.set(Calendar.YEAR, 1989);

        Person taavet = new Person();
        taavet.setIdCode(38900000000L);
        taavet.setFirstName("Taavet");
        taavet.setLastName("Tamm");
        taavet.setSex('M');
        taavet.setDateOfBirth(calendar.getTime());
        taavet.setBirthPlace("Viljandi");
        taavet.setAddress(address);
        taavet.setPhone(51222222);

        PERSONS.put(juta.getIdCode(), juta);
        PERSONS.put(taavet.getIdCode(), taavet);

    }

    @Override
    public Person findByIdCode(long idCode) {
        return PERSONS.get(idCode);
    }
}
