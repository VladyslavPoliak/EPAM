package com.epam.poliak.factory;

import com.epam.poliak.factory.random.RamdomCargoCar;
import com.epam.poliak.factory.random.RandomBicycles;
import com.epam.poliak.factory.random.RandomCar;
import com.epam.poliak.factory.random.RandomTransport;

import java.util.HashMap;
import java.util.Map;

public class RandomFactory implements Builder {

    @Override
    public FactoryInterface chooseType(String key) {
        Map<String, FactoryInterface> map = new HashMap<>();
        map.put("1", new RandomBicycles());
        map.put("2", new RandomCar());
        map.put("3", new RamdomCargoCar());
        map.put("4", new RandomTransport());
        return map.get(key);
    }
}
