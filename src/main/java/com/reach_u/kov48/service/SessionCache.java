package com.reach_u.kov48.service;

import com.reach_u.kov48.model.Person;

public interface SessionCache {

    Person get(String sessionId);

    void put(String sessionId, Person person);

    void invalidate(Person person);

}
