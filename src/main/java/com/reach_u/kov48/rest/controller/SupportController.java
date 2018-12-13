package com.reach_u.kov48.rest.controller;

import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Person;
import com.reach_u.kov48.model.Support;
import com.reach_u.kov48.rest.Constants;
import com.reach_u.kov48.rest.auth.AuthUser;
import com.reach_u.kov48.service.ChildService;
import com.reach_u.kov48.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Collection;

@RestController
@RequestMapping(Constants.API_URL + "support")
public class SupportController {

    private final SupportService supportService;

    private final ChildService childService;

    @Autowired
    public SupportController(SupportService supportService, ChildService childService) {
        this.supportService = supportService;
        this.childService = childService;
    }

    @RequestMapping(value = "available/{childIdCode}", method = RequestMethod.GET, produces = Constants.JSON)
    public ResponseEntity<Collection<Support>> findChild(@AuthUser @ApiIgnore Person person,
                                                         @PathVariable("childIdCode") long childIdCode) {
        return ResponseEntity.ok(supportService.availableSupport(childService.findChild(childIdCode, person)));
    }

    @RequestMapping(value = "apply/{childIdCode}", method = RequestMethod.POST, produces = Constants.JSON)
    private ResponseEntity<Collection<Support>> apply(@AuthUser @ApiIgnore Person person,
                                                      @PathVariable("childIdCode") long childIdCode,
                                                      @RequestBody Collection<Support> support) {
        Child child = childService.findChild(childIdCode, person);
        supportService.apply(child, support);
        return ResponseEntity.ok(supportService.availableSupport(child));
    }

}
