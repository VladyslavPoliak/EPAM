package com.epam.service.impl;

import com.epam.entity.Car;
import com.epam.repository.CarRepository;
import com.epam.service.CarService;

import java.util.List;

public class CarServiceImpl implements CarService {

    private CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.getAllCars();
    }

    @Override
    public List<Car> getAllClasses() {
        return carRepository.getAllClasses();
    }

    @Override
    public List<Car> getAllMarks() {
        return carRepository.getAllMarks();
    }
}
