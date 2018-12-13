package com.reach_u.kov48.rest.controller;

import com.reach_u.kov48.model.Action;
import com.reach_u.kov48.model.Person;
import com.reach_u.kov48.rest.Constants;
import com.reach_u.kov48.rest.auth.AuthUser;
import com.reach_u.kov48.service.ChildService;
import com.reach_u.kov48.service.StateMachine;
import org.springframework.beans.factory.annotation.Autowired;
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

    private final StateMachine stateMachine;

    private final ChildService childService;

    @Autowired
    public StateController(StateMachine stateMachine, ChildService childService) {
        this.stateMachine = stateMachine;
        this.childService = childService;
    }

    @RequestMapping(value = "available_steps/{childIdCode}", method = RequestMethod.GET, produces = Constants.JSON)
    public ResponseEntity<Action[]> getAvailableSteps(@AuthUser @ApiIgnore Person person,
                                                      @PathVariable("childIdCode") long childIdCode) {
        return ResponseEntity.ok(stateMachine.availableActions(person, childService.findChild(childIdCode, person)));
    }

}
