package com.reach_u.kov48.rest.controller;


import com.reach_u.kov48.model.Child;
import com.reach_u.kov48.model.Support;
import org.junit.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

public class SupportServiceImplTest {

    private final SupportServiceImpl service = new SupportServiceImpl();

    @Test
    public void testApply() {
        Child child = new Child();
        Collection<Support> support = service.availableSupport(child);

        service.apply(child, support);

        Collection<Support> newState = service.availableSupport(child);
        assertThat(newState).hasSize(4);
        assertThat(newState.stream().filter(s -> "Menetluses".equals(s.getStatus())).count()).isEqualTo(2);
        for (Support s : newState) {
            assertThat(s.isSelected()).isTrue();
        }

    }

}