package com.reach_u.kov48.service;


import com.reach_u.kov48.model.Action;
import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Person;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StateMachineImplTest {

    private final Person father;

    private final Child child;

    private final StateMachineImpl sm = new StateMachineImpl();

    public StateMachineImplTest() {
        father = new Person();
        father.setIdCode(1);
        father.setSex('M');

        child = new Child();
        child.setIdCode(2);
        child.setFather(father);
    }

    @Test
    public void ifFatherNotConfirmedThenFatherCanOnlyConfirm() {
        assertThat(sm.availableActions(father, child)).containsExactly(Action.CONFIRM_FATHER);
    }

}