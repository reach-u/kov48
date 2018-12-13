package com.reach_u.kov48.service;

import com.google.common.collect.Maps;
import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Person;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChildServiceImpl implements ChildService, InitializingBean {

    private static final Map<Long, Child> CHILDREN = Maps.newHashMap();

    private final PersonService personService;

    @Autowired
    public ChildServiceImpl(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public Collection<Child> findChildren(Person parent) {
        return CHILDREN.values().stream().filter(c -> c.isParent(parent)).collect(Collectors.toList());
    }

    @Override
    public Child findChild(long idCode) {
        return CHILDREN.get(idCode);
    }

    @Override
    public void confirmFather(Person father, long childIdCode) {
        Child child = CHILDREN.get(childIdCode);
        if (child != null && child.getFather().getIdCode() == father.getIdCode()) {
            child.setFatherConfirmed(true);
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Child child = new Child();
        child.setBirthPlace("Tartu");
        child.setSex('M');
        child.setDateOfBirth(new Date());
        child.setIdCode(51800000000L);

        child.setMother(personService.findByIdCode(49200000000L));
        child.setFather(personService.findByIdCode(38900000000L));

        CHILDREN.put(child.getIdCode(), child);
    }
}