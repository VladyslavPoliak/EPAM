package com.spring.service.impl;

import com.spring.entity.Car;
import com.spring.repository.CarRepository;
import com.spring.service.ICarService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements ICarService {

    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }
}
