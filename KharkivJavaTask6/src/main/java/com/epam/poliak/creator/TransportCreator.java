package com.epam.poliak.creator;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.input.InputHelper;

public interface TransportCreator {

    Transport create(InputHelper helper);

    default void fillCommonData(Transport transport,InputHelper helper) {
        transport.setPrice(helper.getInteger("Price: "));
        transport.setProducer(helper.getString("Producer"));
    }

}
