package com.reach_u.kov48.service;


import com.reach_u.kov48.model.Action;
import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Person;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StateMachineImplTest {

    private final Person father;
    private final Person mother;
    private final Child child;


    private final StateMachineImpl sm = new StateMachineImpl();

    public StateMachineImplTest() {
        father = new Person();
        father.setIdCode(1);
        father.setSex('M');

        mother = new Person();
        mother.setIdCode(2);
        mother.setSex('F');

        child = new Child();
        child.setIdCode(3);
        child.setFather(father);
        child.setMother(mother);
        child.setFatherConfirmed(true);
    }

    @Test
    public void ifFatherNotConfirmedThenFatherCanOnlyConfirm() {
        Child child;
        child = new Child();
        child.setIdCode(21);
        child.setFather(father);
        assertThat(sm.availableActions(father, child)).containsExactly(Action.CONFIRM_FATHER);
    }

    @Test
    public void ifChildHasNoNameThenFatherCanOnlySetName() {
        assertThat(sm.availableActions(father, child)).containsExactly(Action.SET_NAME);
    }

    @Test
    public void ifChildHasNoNameThenMotherCanOnlySetName() {
        assertThat(sm.availableActions(mother, child)).containsExactly(Action.SET_NAME);
    }


}