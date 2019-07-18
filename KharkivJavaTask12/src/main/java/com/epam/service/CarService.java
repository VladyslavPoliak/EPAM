package com.epam.service;

import com.epam.entity.Car;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    List<Car> getAllClasses();

    List<Car> getAllMarks();

}
