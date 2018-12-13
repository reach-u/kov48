package com.reach_u.kov48.service;

import com.reach_u.kov48.model.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    private final PersonService personService;

    private final SessionCache sessionCache;

    @Autowired
    public LoginServiceImpl(PersonService personService, SessionCache sessionCache) {
        this.personService = personService;
        this.sessionCache = sessionCache;
    }

    @Override
    public String login(long idCode, long phone) {
        log.info("login: {}", idCode);
        Person person = personService.findByIdCode(idCode);
        if (person != null) {
            String sessionId = UUID.randomUUID().toString();
            sessionCache.put(sessionId, person);
            return sessionId;
        }

        return null;
    }

    @Override
    public void logOut(Person person) {
        sessionCache.invalidate(person);
    }

}
