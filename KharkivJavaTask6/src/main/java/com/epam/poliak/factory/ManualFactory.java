package com.epam.poliak.factory;

import com.epam.poliak.factory.manual.ManualBicycles;
import com.epam.poliak.factory.manual.ManualCar;
import com.epam.poliak.factory.manual.ManualCargoCar;
import com.epam.poliak.factory.manual.ManualTransport;

import java.util.HashMap;
import java.util.Map;

public class ManualFactory implements Builder {

    @Override
    public FactoryInterface chooseType(String key) {
        Map<String, FactoryInterface> map = new HashMap<>();
        map.put("1", new ManualBicycles());
        map.put("2", new ManualCar());
        map.put("3", new ManualCargoCar());
        map.put("4", new ManualTransport());
        return map.get(key);
    }
}
