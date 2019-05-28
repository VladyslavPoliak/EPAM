package com.epam.poliak.dao.impl;

import com.epam.poliak.dao.DAOTransport;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.utils.DeserializableTransportList;

import java.util.ArrayList;
import java.util.Optional;

public class DAOTransportImpl implements DAOTransport {

    private ArrayList<Transport> transportList;

    public DAOTransportImpl() {
        DeserializableTransportList deserializableTransportList = new DeserializableTransportList();
        transportList = deserializableTransportList.deserializationData("serialisation.txt");
    }

    @Override
    public ArrayList<Transport> getAllTransport() {
        return transportList;
    }

    @Override
    public Transport getTransportByID(int id) {
        Optional<Transport> transportOptional = transportList.stream()
                .filter(c -> c.getId() == id)
                .findAny();
        return transportOptional.orElse(null);
    }

    @Override
    public void addNewTransport(int id, int price, String producer) {
        Transport newTransport = new Transport();
        newTransport.setId(id);
        newTransport.setPrice(price);
        newTransport.setProducer(producer);
        transportList.add(newTransport);
    }
}
