package com.epam.poliak.utils;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.io.Writer;
import com.epam.poliak.io.impl.WriterImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializableAllTransport {

    public ArrayList<Transport> deserializationData(String fileName) {
        ArrayList<Transport> list = new ArrayList<>();
        Writer writer = new WriterImpl();
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            list = (ArrayList<Transport>) objectInputStream.readObject();
            writer.writeLine("Successful deserialization");
        } catch (ClassNotFoundException | IOException e) {
            writer.writeLine("Failed to load data from file");
        }
        return list;
    }

}
