package com.epam.poliak.utils;

import com.epam.poliak.entity.Transport;
import com.epam.poliak.service.TransportService;

import java.io.*;
import java.util.ArrayList;

public class SerializableTransportList {

    private TransportService transportService;

    public SerializableTransportList(TransportService transportService) {
        this.transportService = transportService;
    }

    public SerializableTransportList() {
    }

    public void serializableData(String fileName) {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            objectOutputStream.writeObject(transportService.getAllTransport());
            System.out.println("Успешно сериализация");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Transport> deserializationData(String fileName) {
        ArrayList<Transport> list=null;
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            list = (ArrayList<Transport>) objectInputStream.readObject();
            System.out.println("Успешно десериализация");
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Не удалось загрузить данные с файла");
        }
        return list;

    }

}
