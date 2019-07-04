package com.epam.poliak.utils;

import com.epam.poliak.io.Writer;
import com.epam.poliak.io.impl.WriterImpl;
import com.epam.poliak.service.TransportService;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableAllTransport {

    private TransportService transportService;

    public SerializableAllTransport(TransportService transportService) {
        this.transportService = transportService;
    }

    public void serializableData(String fileName) {
        Writer writer = new WriterImpl();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(transportService.getAllTransport());
            writer.writeLine("Successful serialization");
        } catch (IOException e) {
            writer.writeLine("error writing data to file");
        }
    }
}
