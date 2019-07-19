package com.epam.service.impl;

import com.epam.entity.Car;
import com.epam.form.SearchForm;
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

    @Override
    public List<Car> listCarsBySearchForm(SearchForm searchForm) {
        return carRepository.listCarsBySearchForm(searchForm);
    }

    @Override
    public List<Car> listCarsByClass(String className) {
        return carRepository.listCarsByClass(className);
    }

}
