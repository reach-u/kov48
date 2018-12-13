package com.reach_u.kov48.rest.controller;

import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Person;
import com.reach_u.kov48.rest.Constants;
import com.reach_u.kov48.rest.auth.AuthUser;
import com.reach_u.kov48.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(Constants.API_URL + "child")
@Secured("ROLE_USER")
public class ChildController {

    private final ChildService childService;

    @Autowired
    public ChildController(ChildService childService) {
        this.childService = childService;
    }

    @RequestMapping(value = "find/{childIdCode}", method = RequestMethod.GET, produces = Constants.JSON)
    public ResponseEntity<Child> findChild(@AuthUser @ApiIgnore Person person,
                                           @PathVariable("childIdCode") long childIdCode) {
        Child child = childService.findChild(childIdCode);
        if (child == null || !child.isParent(person)) {
            throw new IllegalArgumentException("Not found");
        }
        return ResponseEntity.ok(child);
    }

    @RequestMapping(value = "confirm_father/{childIdCode}", method = RequestMethod.GET, produces = Constants.JSON)
    public ResponseEntity<Child> confirmFather(@AuthUser @ApiIgnore Person father,
                                               @PathVariable("childIdCode") long childIdCode) {
        childService.confirmFather(father, childIdCode);
        return ResponseEntity.ok(childService.findChild(childIdCode));
    }

}
