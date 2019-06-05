package com.epam.poliak.creator;

import com.epam.poliak.creator.impl.BicycleCreator;
import com.epam.poliak.creator.impl.CarCreator;
import com.epam.poliak.creator.impl.CargoCarCreator;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.input.InputHelper;

import java.util.HashMap;
import java.util.Map;

public class ChooseCreator {

    private InputHelper inputHelper;
    private Map<String, TransportCreator> creatorMap = new HashMap<>();

    public ChooseCreator(InputHelper inputHelper) {
        this.inputHelper = inputHelper;
    }

    public Transport doCreate(String key) {
        creatorMap.put("1", new BicycleCreator());
        creatorMap.put("2", new CarCreator());
        creatorMap.put("3", new CargoCarCreator());
        return creatorMap.get(key).create(inputHelper);
    }
}
