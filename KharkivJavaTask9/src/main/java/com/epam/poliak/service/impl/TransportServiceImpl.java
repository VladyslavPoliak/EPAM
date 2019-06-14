package com.epam.poliak.service.impl;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.repository.Repository;
import com.epam.poliak.service.TransportService;

import java.util.ArrayList;

public class TransportServiceImpl implements TransportService {

    private Repository repository;

    public TransportServiceImpl(Repository repository) {
        this.repository = repository;
    }

    @Override
    public ArrayList<Transport> getAllTransport() {
        return repository.getAllTransport();
    }

    @Override
    public Transport getTransportByID(int id) {
        return repository.getTransportByID(id);
    }

    @Override
    public void addNewTransport(Transport transport) {
        repository.addNewTransport(repository.getAllTransport().size(), transport);
    }
}
