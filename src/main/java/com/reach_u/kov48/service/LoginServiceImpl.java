package com.reach_u.kov48.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public String login(String phoneNumber) {
        log.info("login: {}", phoneNumber);

        return UUID.randomUUID().toString();
    }
}
