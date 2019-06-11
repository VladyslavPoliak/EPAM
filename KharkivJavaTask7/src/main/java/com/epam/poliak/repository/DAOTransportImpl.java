package com.epam.poliak.repository;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.utils.DeserializableAllTransport;

import java.util.ArrayList;
import java.util.Optional;

public class DAOTransportImpl implements DAOTransport {

    private ArrayList<Transport> transportList;

    public DAOTransportImpl() {
        DeserializableAllTransport deserializableAllTransport = new DeserializableAllTransport();
        transportList = deserializableAllTransport.deserializationData("serialisation.txt");
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
    public void addNewTransport(int id, Transport transport) {
        transport.setId(id);
        transportList.add(transport);
    }
}
