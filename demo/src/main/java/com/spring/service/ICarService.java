package com.spring.service;

import com.spring.entity.Car;

import java.util.List;

public interface ICarService {

    List<Car> getAllCars();

    List<String> getAllMarks();

    List<String> getAllClasses();

    List<Car> getCarsByMark(String mark);

    List<Car> getCarsByClass(String className);
}
