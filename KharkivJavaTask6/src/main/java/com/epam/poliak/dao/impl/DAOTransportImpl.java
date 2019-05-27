package com.epam.poliak.dao.impl;

import com.epam.poliak.dao.DAOTransport;
import com.epam.poliak.entity.Car;
import com.epam.poliak.entity.Transport;
import com.epam.poliak.utils.SerializableTransportList;
import com.epam.poliak.utils.Utils;

import java.util.ArrayList;
import java.util.Optional;

public class DAOTransportImpl implements DAOTransport {

    private ArrayList<Transport> transportList;

    public DAOTransportImpl() {
        SerializableTransportList serializableTransportList=new SerializableTransportList();
        transportList = serializableTransportList.deserializationData("serialisation2.txt");
//                Utils.deserializableAllTransportList("serialisation.txt");
//                new ArrayList<>();
//        transportList.add(new Car(0, 5500, "Nissan", 200, 2011));
//        transportList.add(new Car(1, 5000, "Nissan", 150, 2010));
//        transportList.add(new Car(2, 6000, "Toyota", 152, 2011));
//        transportList.add(new Car(3, 2000, "Mazda", 155, 2014));
//        transportList.add(new Car(4, 7000, "Nissan", 140, 2013));
//        transportList.add(new Car(5, 4000, "Nissan", 145, 2014));
//        transportList.add(new Car(6, 2000, "Chevrolet", 100, 2010));
    }

    @Override
    public ArrayList<Transport> getAllTransport() {
        return transportList;
    }

    @Override
    public Transport getTransportByID(int id) {
        Optional<Transport> transportOptional = transportList.stream()
                .filter(c -> c.getId() == id)
                .findAny();
        return transportOptional.orElse(null);
    }
}
