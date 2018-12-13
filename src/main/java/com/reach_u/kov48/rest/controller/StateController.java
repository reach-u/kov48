package com.reach_u.kov48.rest.controller;

import com.reach_u.kov48.model.Action;
import com.reach_u.kov48.model.Person;
import com.reach_u.kov48.rest.Constants;
import com.reach_u.kov48.rest.auth.AuthUser;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(Constants.API_URL)
@Secured("ROLE_USER")
public class StateController {

    @RequestMapping(value = "available_steps/{childIdCode}", method = RequestMethod.GET, produces = Constants.JSON)
    public ResponseEntity<Action[]> getAvailableSteps(@AuthUser @ApiIgnore Person person,
                                                      @PathVariable("childIdCode") long childIdCode) {
        Action[] actions = new Action[] { Action.CONFIRM_FATHER };
        return ResponseEntity.ok(actions);
    }

}
