package com.reach_u.kov48.service;

import com.reach_u.kov48.model.Action;
import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Person;

public interface StateMachine {

    Action[] availableActions(Person person, Child child);

}
