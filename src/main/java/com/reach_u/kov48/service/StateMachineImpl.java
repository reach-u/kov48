package com.reach_u.kov48.service;

import com.reach_u.kov48.model.Action;
import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.Objects;

@Component
public class StateMachineImpl implements StateMachine {

    private static final char MALE = 'M';
    private static final char FEMALE = 'F';

    private static final StateReceiver[] RECEIVERS;

    static {
        RECEIVERS = new StateReceiver[] {
                // father has not confirmed
                new StateReceiver((person, child) -> person.getSex() == MALE && !child.isFatherConfirmed(),
                        new Action[] { Action.CONFIRM_FATHER }),
                // child has no name
                new StateReceiver((person, child) -> StringUtils.isEmpty(child.getFirstName()),
                        new Action[] { Action.SET_NAME })
        };
    }

    @Override
    public Action[] availableActions(Person person, Child child) {
        return Arrays.stream(RECEIVERS).map(d -> d.get(person, child)).filter(Objects::nonNull).findFirst()
                .orElseThrow(() -> new IllegalStateException("Invalid state"));
    }

    private interface StateDecider {

        boolean apply(Person person, Child child);

    }

    @RequiredArgsConstructor
    private static class StateReceiver {

        private final StateDecider decider;

        private final Action[] actions;

        public Action[] get(Person person, Child child) {
            return decider.apply(person, child) ? actions : null;
        }
    }
}
