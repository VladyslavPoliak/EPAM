package com.epam.poliak.creator;

import com.epam.poliak.creator.impl.BicycleCreator;
import com.epam.poliak.creator.impl.CarCreator;
import com.epam.poliak.creator.impl.CargoCarCreator;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.input.InputHelper;
import com.epam.poliak.io.Writer;

import java.util.HashMap;
import java.util.Map;

public class ChooseCreator {

    private Writer writer;
    private InputHelper inputHelper;
    private Map<String, TransportCreator> creatorMap = new HashMap<>();

    public ChooseCreator(Writer writer, InputHelper inputHelper) {
        this.inputHelper = inputHelper;
        this.writer = writer;
    }

    public Transport doCreate(String key) {
        creatorMap.put("1", new BicycleCreator(writer));
        creatorMap.put("2", new CarCreator());
        creatorMap.put("3", new CargoCarCreator(writer));
        return creatorMap.get(key).create(inputHelper);
    }
}
