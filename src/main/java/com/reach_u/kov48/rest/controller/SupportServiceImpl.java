package com.reach_u.kov48.rest.controller;

import com.google.common.collect.Lists;
import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Support;
import com.reach_u.kov48.service.SupportService;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class SupportServiceImpl implements SupportService {

    private static final String PAID = "Makstud";
    private static final String NOT_APPLIED = "Esitamata";
    private static final String PROCESSING = "Menetluses";


    private static final Collection<Support> SUPPORT = Lists.newArrayList();

    static {
        SUPPORT.add(new Support("Sünnitoetus (Riik)", 320, PAID, true));
        SUPPORT.add(new Support("Sünnitoetus (KOV)", 1000, PAID, true));
        SUPPORT.add(new Support("Lepsetoetus (Riik)", 32, NOT_APPLIED, false));
        SUPPORT.add(new Support("Vanemahüvitis (Riik)", 1500, NOT_APPLIED, false));
    }

    @Override
    public Collection<Support> availableSupport(Child child) {
        return SUPPORT;
    }

    @Override
    public void apply(Child child, Collection<Support> support) {

    }
}
