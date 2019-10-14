package com.spring.service;

import com.spring.entity.Car;

import java.util.List;

public interface ICarService {

    List<Car> getAllCars();

    List<String> getAllMarks();

    List<Car> getAllClasses();

    List<Car> getCarsByMark(String mark);
}
