package com.reach_u.kov48.service;

import com.reach_u.kov48.model.Person;

public interface LoginService {

    String login(long idCode, long phone);

    void logOut(Person person);

}
