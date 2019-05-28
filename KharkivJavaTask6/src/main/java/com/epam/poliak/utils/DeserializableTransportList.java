package com.epam.poliak.utils;

import com.epam.poliak.entity.Transport;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializableTransportList {

    public ArrayList<Transport> deserializationData(String fileName) {
        ArrayList<Transport> list = null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            list = (ArrayList<Transport>) objectInputStream.readObject();
            System.out.println("Successful deserialization");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Failed to load data from file");
        }
        return list;
    }

}
