package com.reach_u.kov48.rest.controller;

import com.reach_u.kov48.model.Person;
import com.reach_u.kov48.rest.Constants;
import com.reach_u.kov48.rest.auth.AuthUser;
import com.reach_u.kov48.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(Constants.API_URL)
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @RequestMapping(value = "login/{idCode}/{phone}", method = RequestMethod.GET)
    public ResponseEntity<String> login(@PathVariable("idCode") long idCode, @PathVariable("phone") long phone) {
        return ResponseEntity.ok(loginService.login(idCode, phone));
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public void logout(@AuthUser @ApiIgnore Person person) {
        loginService.logOut(person);
    }

}
