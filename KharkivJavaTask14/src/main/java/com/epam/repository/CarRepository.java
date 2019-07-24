package com.epam.repository;

import com.epam.entity.Car;
import com.epam.form.SearchForm;

import java.util.List;

public interface CarRepository {

    List<Car> getAllCars(int offset, int limit);

    int countAllCars();

    List<Car> getAllClasses();

    List<Car> getAllMarks();

    List<Car> listCarsBySearchForm(SearchForm searchForm, int limit, int offset);

    List<Car> listCarsByClass(String className);

    int countCarsBySearchForm(SearchForm searchForm);

}
