package com.epam.service;

import com.epam.entity.Car;
import com.epam.form.SearchForm;

import java.util.List;

public interface CarService {

    List<Car> getAllCars(int offset, int limit);

    int countAllCars();

    List<Car> getAllClasses();

    List<Car> getAllMarks();

    List<Car> listCarsBySearchForm(SearchForm searchForm, int limit, int offset);

    int countCarsBySearchForm(SearchForm searchForm);

    List<Car> listCarsByClass(String className);

}
