package com.epam.poliak.service;

import com.epam.poliak.entity.Transport;

public interface TransportService {

    void showListCars();

    Transport getTransportByID(int id);

}
