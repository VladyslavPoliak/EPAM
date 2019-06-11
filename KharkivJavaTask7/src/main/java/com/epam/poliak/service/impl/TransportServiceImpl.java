package com.epam.poliak.service.impl;

import com.epam.poliak.repository.DAOTransport;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;

import java.util.ArrayList;

public class TransportServiceImpl implements TransportService {

    private DAOTransport daoTransport;

    public TransportServiceImpl(DAOTransport daoTransport) {
        this.daoTransport = daoTransport;
    }

    @Override
    public ArrayList<Transport> getAllTransport() {
        return daoTransport.getAllTransport();
    }

    @Override
    public Transport getTransportByID(int id) {
        return daoTransport.getTransportByID(id);
    }

    @Override
    public void addNewTransport(Transport transport) {
        daoTransport.addNewTransport(daoTransport.getAllTransport().size(), transport);
    }
}
