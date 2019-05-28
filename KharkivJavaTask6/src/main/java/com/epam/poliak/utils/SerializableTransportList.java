package com.epam.poliak.utils;

import com.epam.poliak.service.TransportService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableTransportList {

    private TransportService transportService;

    public SerializableTransportList(TransportService transportService) {
        this.transportService = transportService;
    }

    public void serializableData(String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(transportService.getAllTransport());
            System.out.println("Successful serialization");
        } catch (IOException e) {
            System.out.println("error writing data to file");
        }
    }
}
