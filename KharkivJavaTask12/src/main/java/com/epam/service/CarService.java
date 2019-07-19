package com.epam.service;

import com.epam.entity.Car;
import com.epam.form.SearchForm;

import java.util.List;

public interface CarService {

    List<Car> getAllCars();

    List<Car> getAllClasses();

    List<Car> getAllMarks();

    List<Car> listCarsBySearchForm(SearchForm searchForm);

    int countCarsBySearchForm(SearchForm searchForm);

}
