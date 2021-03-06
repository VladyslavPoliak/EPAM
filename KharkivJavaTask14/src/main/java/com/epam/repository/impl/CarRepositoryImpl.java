package com.epam.repository.impl;

import com.epam.constans.SqlQueries;
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

    private final ResultSetHandler<Car> CAR_RESULT_SET_HANDLER = rs -> Car.builder()
            .setId(rs.getInt("id_car"))
            .setName(rs.getString("name"))
            .setMark(rs.getString("mark"))
            .setClassCar(rs.getString("class"))
            .setCost(rs.getInt("cost"))
            .setImageURL(rs.getString("image"))
            .build();
    private final ResultSetHandler<Car> CLASSES_RESULT_SET_HANDLER = rs -> Car.builder()
            .setClassCar(rs.getString("class"))
            .build();
    private final ResultSetHandler<Car> MARKS_RESULT_SET_HANDLER = rs -> Car.builder()
            .setMark(rs.getString("mark"))
            .build();
    private DataBaseManager dataBaseManager;

    public CarRepositoryImpl(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

    @Override
    public List<Car> getAllCars(int offset, int limit) {
        try {
            return dataBaseManager.select(SqlQueries.SELECT_ALL_CARS,
                    ResultSetHandlerFactory.getListResultSetHandler(CAR_RESULT_SET_HANDLER), limit, offset);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    @Override
    public int countAllCars() {
        try {
            return dataBaseManager.select(SqlQueries.SELECT_ALL_CARS_COUNT,
                    ResultSetHandlerFactory.getCountResultSetHandler());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    @Override
    public Car getCarById(int id) {
        try {
            return dataBaseManager.select(SqlQueries.SELECT_CAR_BY_ID,
                    ResultSetHandlerFactory.getSingleResultSetHandler(CAR_RESULT_SET_HANDLER), id);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Car> getAllClasses() {
        try {
            return dataBaseManager.select(SqlQueries.SELECT_ALL_CLASSES,
                    ResultSetHandlerFactory.getListResultSetHandler(CLASSES_RESULT_SET_HANDLER));
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Car> getAllMarks() {
        try {
            return dataBaseManager.select(SqlQueries.SELECT_ALL_MARKS,
                    ResultSetHandlerFactory.getListResultSetHandler(MARKS_RESULT_SET_HANDLER));
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Car> listCarsByClass(String className) {
        try {
            return dataBaseManager.select(SqlQueries.SELECT_CARS_BY_CLASS,
                    ResultSetHandlerFactory.getListResultSetHandler(CLASSES_RESULT_SET_HANDLER), className);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    @Override
    public List<Car> listCarsBySearchForm(SearchForm searchForm, int limit, int offset) {
        try {
            SearchQuery sq = buildSearchQuery(searchForm, "SELECT * ");
            return dataBaseManager.select(getSqlQuery(sq.getSql(), limit, offset), ResultSetHandlerFactory.getListResultSetHandler(CAR_RESULT_SET_HANDLER),
                    sq.getParams().toArray());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    @Override
    public int countCarsBySearchForm(SearchForm searchForm) {
        try {
            SearchQuery sq = buildSearchQuery(searchForm, " SELECT COUNT(*) ");
            return dataBaseManager.select(sq.getSql().toString(), ResultSetHandlerFactory.getCountResultSetHandler(), sq.getParams().toArray());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Can't execute SQL request: " + e.getMessage(), e);
        }
    }

    private SearchQuery buildSearchQuery(SearchForm form, String command) {
        List<Object> params = new ArrayList<>();
        StringBuilder sql = new StringBuilder(command);
        sql.append(" from car where (name like ? or mark like ?)");
        params.add("%" + form.getQuery() + "%");
        params.add("%" + form.getQuery() + "%");
        dataBaseManager.populateSqlAndParams(sql, params, form.getProducers(), form.getCarClasses(), form.getMinPrice(), form.getMaxPrice());
        return new SearchQuery(sql, params);
    }

    private String getSqlQuery(StringBuilder stringBuilder, int limit, int offset) {
        stringBuilder.append(" limit ").append(limit)
                .append(" offset ").append(offset);
        return stringBuilder.toString();
    }
}
