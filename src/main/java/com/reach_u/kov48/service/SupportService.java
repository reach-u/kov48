package com.reach_u.kov48.service;

import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Support;

import java.util.Collection;

public interface SupportService {

    Collection<Support> availableSupport(Child child);

    void apply(Child child, Collection<Support> support);

}
