package com.epam.poliak.repository;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.utils.DeserializableAllTransport;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TransportRepository implements Repository<Transport> {

    private ArrayList<Transport> transportList;

    public TransportRepository() {
        DeserializableAllTransport deserializableAllTransport = new DeserializableAllTransport();
        transportList = deserializableAllTransport.deserializationData("serialisation.txt");
    }

    @Override
    public List<Transport> getAll() {
        return transportList;
    }

    @Override
    public Transport get(int id) {
        Optional<Transport> transportOptional = transportList.stream()
                .filter(c -> c.getId() == id)
                .findAny();
        return transportOptional.orElse(null);
    }

    @Override
    public void addNew(int id, Transport transport) {
        transport.setId(id);
        transportList.add(transport);
    }
}
