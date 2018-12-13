package com.reach_u.kov48.service;

import com.google.common.collect.Maps;
import com.reach_u.kov48.model.Person;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class SessionCacheImpl implements SessionCache {

    private static final Map<String, Person> SESSIONS = Maps.newHashMap();

    @Override
    public Person get(String sessionId) {
        return SESSIONS.get(sessionId);
    }

    @Override
    public void put(String sessionId, Person person) {
        SESSIONS.put(sessionId, person);
    }

    @Override
    public void invalidate(Person person) {
        SESSIONS.entrySet().stream().filter(e -> e.getValue().getIdCode() == person.getIdCode()).map(Map.Entry::getKey)
                .findFirst().ifPresent(SESSIONS::remove);
    }

}
