package com.reach_u.kov48.rest.controller;

import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Support;
import com.reach_u.kov48.service.SupportService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SupportServiceImpl implements SupportService {

    @Override
    public Collection<Support> availableSupport(Child child) {
        return null;
    }

    @Override
    public void apply(Child child, Collection<Support> support) {

    }
}
