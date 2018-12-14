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
        KINDERGARTENS.add(new Kindergarten("Midrimaa", "Vanemuine 28, Tartu",
                new Coordinate(58.385284, 26.719494), 350, 500, 21));
        KINDERGARTENS.add(new Kindergarten("Sipsik", "Oa 6, Tartu",
                new Coordinate(58.383754, 26.714732), 2305, 200, 34));
        KINDERGARTENS.add(new Kindergarten("Kivila", "Kivi 15, Tartu",
                new Coordinate(58.383551, 26.719322), 582, 350, 78));
        KINDERGARTENS.add(new Kindergarten("Kratt", "Taara pst 46, Tartu",
                new Coordinate(58.382224, 26.718078), 1165, 50, 2));
        KINDERGARTENS.add(new Kindergarten("Lasteaed #1", "Vallikraavi7, Tartu",
                new Coordinate(58.383034, 26.709971), 3777, 110, 0));
    }

    @Override
    public Collection<Kindergarten> findAll() {
        return KINDERGARTENS;
    }
}
