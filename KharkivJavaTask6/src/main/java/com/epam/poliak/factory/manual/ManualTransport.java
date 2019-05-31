package com.epam.poliak.factory.manual;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.factory.FactoryInterface;

public class ManualTransport implements FactoryInterface {

    @Override
    public Transport create() {
        Transport transport = new Transport();
        manualFillCommonData(transport);
        return transport;
    }
}
