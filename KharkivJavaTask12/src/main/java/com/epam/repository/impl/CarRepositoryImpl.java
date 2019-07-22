package com.epam.repository.impl;

import com.epam.constans.AllRequestDB;
import com.epam.database.DataBaseManager;
import com.epam.database.ResultSetHandler;
import com.epam.database.ResultSetHandlerFactory;
import com.epam.database.SearchQuery;
import com.epam.entity.Car;
import com.epam.exception.InternalServerErrorException;
import com.epam.form.SearchForm;
import com.epam.repository.CarRepository;

import java.sql.SQLException;
import java.util.ArrayList;
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
    private final ResultSetHandler<Car> CLASSES_RESULT_SET_HANDLER = rs -> new Car.CarBuilder()
            .setClassCar(rs.getString("class"))
            .build();
    private final ResultSetHandler<Car> MARKS_RESULT_SET_HANDLER = rs -> new Car.CarBuilder()
            .setMark(rs.getString("mark"))
            .build();
    private DataBaseManager dataBaseManager;

    public CarRepositoryImpl(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

    @Override
    public List<Car> getAllCars(int offset, int limit) {
        try {
            return dataBaseManager.select(AllRequestDB.SELECT_ALL_CARS,
                    ResultSetHandlerFactory.getListResultSetHandler(CAR_RESULT_SET_HANDLER), limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    @Override
    public int countAllCars() {
        try {
            return dataBaseManager.select(AllRequestDB.SELECT_ALL_CARS_COUNT,
                    ResultSetHandlerFactory.getCountResultSetHandler());
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
        try {
            SearchQuery sq = buildSearchQuery(searchForm);
            return dataBaseManager.select(sq.getSql().toString(), ResultSetHandlerFactory.getListResultSetHandler(CAR_RESULT_SET_HANDLER), sq.getParams().toArray());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Car> listCarsByClass(String className) {
        try {
            return dataBaseManager.select(AllRequestDB.SELECT_CARS_BY_CLASS,
                    ResultSetHandlerFactory.getListResultSetHandler(CLASSES_RESULT_SET_HANDLER), className);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    private SearchQuery buildSearchQuery(SearchForm form) {
        List<Object> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select ");
        sql.append(" * ").append(" from car where (name like ? or mark like ?)");
        params.add("%" + form.getQuery() + "%");
        params.add("%" + form.getQuery() + "%");
        dataBaseManager.populateSqlAndParams(sql, params, form.getProducers(), form.getCarClasses(), form.getMinPrice(), form.getMaxPrice());
        return new SearchQuery(sql, params);
    }
}
