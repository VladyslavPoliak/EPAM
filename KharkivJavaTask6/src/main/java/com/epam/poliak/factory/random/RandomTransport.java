package com.epam.poliak.factory.random;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.factory.FactoryInterface;

public class RandomTransport implements FactoryInterface {

    @Override
    public Transport create() {
        Transport transport = new Transport();
        randomFillCommonData(transport);
        return transport;
    }
}
