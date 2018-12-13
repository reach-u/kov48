package com.reach_u.kov48.rest.controller;

import com.reach_u.kov48.model.Person;
import com.reach_u.kov48.rest.Constants;
import com.reach_u.kov48.rest.auth.AuthUser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(Constants.API_URL)
public class ActiveUserController {

    @RequestMapping(value = "active_user", method = RequestMethod.GET, produces = Constants.JSON)
    public ResponseEntity<Person> getActivePerson(@AuthUser @ApiIgnore Person person) {
        return ResponseEntity.ok(person);
    }

}
