package com.reach_u.kov48.rest.controller;

import com.reach_u.kov48.model.Kindergarten;
import com.reach_u.kov48.rest.Constants;
import com.reach_u.kov48.service.KindergartenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(Constants.API_URL + "kindergarten")
@Secured("ROLE_USER")
public class KingergartenController {

    private final KindergartenService service;

    @Autowired
    public KingergartenController(KindergartenService service) {
        this.service = service;
    }

    @RequestMapping(value = "find", method = RequestMethod.GET, produces = Constants.JSON)
    public ResponseEntity<Collection<Kindergarten>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
