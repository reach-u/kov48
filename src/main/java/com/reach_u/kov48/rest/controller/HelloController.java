package com.reach_u.kov48.rest.controller;

import com.reach_u.kov48.model.User;
import com.reach_u.kov48.rest.Constants;
import com.reach_u.kov48.rest.auth.AuthUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Constants.API_URL)
@Secured("ROLE_USER")
public class HelloController {

    @RequestMapping(value = "hello", method = RequestMethod.GET)
    public ResponseEntity<String> hello(@AuthUser User user) {
        return ResponseEntity.ok("Hello " + user + "!!!");
    }

}
