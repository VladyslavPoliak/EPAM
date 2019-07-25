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
    public List<Car> getAllCars(int offset, int limit) {
        return carRepository.getAllCars(offset, limit);
    }

    @Override
    public int countAllCars() {
        return carRepository.countAllCars();
    }

    @Override
    public Car getCarById(int id) {
        return carRepository.getCarById(id);
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
    public List<Car> listCarsBySearchForm(SearchForm searchForm, int limit, int offset) {
        return carRepository.listCarsBySearchForm(searchForm, limit, offset);
    }

    @Override
    public int countCarsBySearchForm(SearchForm searchForm) {
        return carRepository.countCarsBySearchForm(searchForm);
    }

}
