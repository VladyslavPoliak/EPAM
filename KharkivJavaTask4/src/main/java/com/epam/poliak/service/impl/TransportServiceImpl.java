package com.epam.poliak.service.impl;

import com.epam.poliak.dao.DAOTransport;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;

import java.util.ArrayList;

public class TransportServiceImpl implements TransportService {

    private DAOTransport daoTransport;

    public TransportServiceImpl(DAOTransport daoTransport) {
        this.daoTransport = daoTransport;
    }

    @Override
    public void showListCars() {
        ArrayList<Transport> transportList = daoTransport.getAllTransport();
        if (!transportList.isEmpty()) {
            transportList.forEach(System.out::println);
        } else {
            System.out.println("Sorry, there are no cars at the moment. Try later");
        }
    }

    @Override
    public Transport getTransportByID(int id) {
        return daoTransport.getTransportByID(id);
    }
}
