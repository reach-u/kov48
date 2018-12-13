package com.reach_u.kov48.rest.controller;

import com.reach_u.kov48.rest.Constants;
import com.reach_u.kov48.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API_URL)
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "login/{phoneNumber}", method = RequestMethod.GET)
    public ResponseEntity<String> login(@PathVariable("phoneNumber") String phoneNumber) {
        return ResponseEntity.ok(loginService.login(phoneNumber));
    }

}
