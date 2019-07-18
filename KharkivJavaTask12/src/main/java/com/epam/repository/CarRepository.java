package com.epam.repository;

import com.epam.entity.Car;

import java.util.List;

public interface CarRepository {

    List<Car> getAllCars();

    List<Car> getAllClasses();

    List<Car> getAllMarks();

}
