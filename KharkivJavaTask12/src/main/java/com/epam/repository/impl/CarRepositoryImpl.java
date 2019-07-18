package com.epam.repository.impl;

import com.epam.constans.AllRequestDB;
import com.epam.database.DataBaseManager;
import com.epam.database.ResultSetHandler;
import com.epam.database.ResultSetHandlerFactory;
import com.epam.entity.Car;
import com.epam.exception.InternalServerErrorException;
import com.epam.form.SearchForm;
import com.epam.repository.CarRepository;

import java.sql.SQLException;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    private DataBaseManager dataBaseManager;
    private final ResultSetHandler<Car> CAR_RESULT_SET_HANDLER = rs -> new Car.CarBuilder()
            .setId(rs.getInt("id_car"))
            .setName(rs.getString("name"))
            .setMark(rs.getString("mark"))
            .setClassCar(rs.getString("class"))
            .setCost(rs.getInt("cost"))
            .setImageURL(rs.getString("image"))
            .build();
    private final ResultSetHandler<Car> CLASSES_RESULT_SET_HANDLER = rs -> new Car.CarBuilder()
            .setClassCar(rs.getString("class"))
            .build();
    private final ResultSetHandler<Car> MARKS_RESULT_SET_HANDLER = rs -> new Car.CarBuilder()
            .setMark(rs.getString("mark"))
            .build();

    public CarRepositoryImpl(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

    @Override
    public List<Car> getAllCars() {
        try {
            return dataBaseManager.select(AllRequestDB.SELECT_ALL_CARS,
                    ResultSetHandlerFactory.getListResultSetHandler(CAR_RESULT_SET_HANDLER));
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Car> getAllClasses() {
        try {
            return dataBaseManager.select(AllRequestDB.SELECT_ALL_CLASSES,
                    ResultSetHandlerFactory.getListResultSetHandler(CLASSES_RESULT_SET_HANDLER));
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Car> getAllMarks() {
        try {
            return dataBaseManager.select(AllRequestDB.SELECT_ALL_MARKS,
                    ResultSetHandlerFactory.getListResultSetHandler(MARKS_RESULT_SET_HANDLER));
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Car> listCarsBySearchForm(SearchForm searchForm) {
        System.out.println("SELECT * FROM car WHERE name like '%" + searchForm.getQuery()
                + "%' or mark like '%" + searchForm.getQuery() + "%'" );
        try {
            return dataBaseManager.select("SELECT * FROM car WHERE name like '%" + searchForm.getQuery()
                            + "%' or mark like '%" + searchForm.getQuery() + "%' ",
                    ResultSetHandlerFactory.getListResultSetHandler(CAR_RESULT_SET_HANDLER));
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }
}
