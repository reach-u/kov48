package com.reach_u.kov48.service;

import com.google.common.collect.Lists;
import com.reach_u.kov48.model.Coordinate;
import com.reach_u.kov48.model.Kindergarten;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class KindergartenServiceImpl implements KindergartenService {

    private static final Collection<Kindergarten> KINDERGARTENS = Lists.newArrayList();

    static {
        KINDERGARTENS.add(new Kindergarten("Midrimaa", new Coordinate(58.385284, 26.719494), 0, 500, 21));
        KINDERGARTENS.add(new Kindergarten("Sipsik", new Coordinate(58.383754, 26.714732), 0, 200, 34));
        KINDERGARTENS.add(new Kindergarten("Kivila", new Coordinate(58.383551, 26.719322), 0, 350, 78));
        KINDERGARTENS.add(new Kindergarten("Kratt", new Coordinate(58.382224, 26.718078), 0, 50, 2));
        KINDERGARTENS.add(new Kindergarten("Lasteaed #1", new Coordinate(58.383034, 26.709971), 0, 110, 0));
    }

    @Override
    public Collection<Kindergarten> findAll() {
        return KINDERGARTENS;
    }
}
