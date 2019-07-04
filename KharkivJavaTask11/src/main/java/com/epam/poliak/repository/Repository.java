package com.epam.poliak.repository;

import com.epam.poliak.entity.Transport;

import java.util.ArrayList;

public interface Repository {

    ArrayList<Transport> getAllTransport();

    Transport getTransportByID(int id);

    void addNewTransport(int id, Transport transport);

    int getSize();
}
