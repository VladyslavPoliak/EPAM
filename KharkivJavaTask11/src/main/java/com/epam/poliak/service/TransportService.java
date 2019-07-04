package com.epam.poliak.service;

import com.epam.poliak.entity.Transport;

import java.util.ArrayList;

public interface TransportService {

    ArrayList<Transport> getAllTransport();

    Transport getTransportByID(int id);

    void addNewTransport(Transport transport);

    int getCountOfTransport();

}
