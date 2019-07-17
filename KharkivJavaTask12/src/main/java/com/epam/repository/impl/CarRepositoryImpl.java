package com.epam.repository.impl;

import com.epam.database.DataBaseManager;
import com.epam.database.ResultSetHandler;
import com.epam.database.ResultSetHandlerFactory;
import com.epam.entity.Car;
import com.epam.exception.InternalServerErrorException;
import com.epam.repository.CarRepository;
import com.epam.constans.AllRequestDB;

import java.sql.SQLException;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {

    private final ResultSetHandler<Car> CAR_RESULT_SET_HANDLER = rs -> new Car.CarBuilder()
            .setId(rs.getInt("id_car"))
            .setName(rs.getString("name"))
            .setMark(rs.getString("mark"))
            .setClassCar(rs.getString("class"))
            .setCost(rs.getInt("cost"))
            .setImageURL(rs.getString("image"))
            .build();
    private DataBaseManager dataBaseManager;

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
}
