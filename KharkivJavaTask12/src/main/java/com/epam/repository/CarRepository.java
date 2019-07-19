package com.epam.repository;

import com.epam.entity.Car;
import com.epam.form.SearchForm;

import java.util.List;

public interface CarRepository {

    List<Car> getAllCars(String countDisplay);

    List<Car> getAllClasses();

    List<Car> getAllMarks();

    List<Car> listCarsBySearchForm(SearchForm searchForm);

    List<Car> listCarsByClass(String className);

}
