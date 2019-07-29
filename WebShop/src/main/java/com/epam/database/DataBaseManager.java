package com.epam.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DataBaseManager {

    private Connection connection;

    public DataBaseManager(Connection connection) {
        this.connection = connection;
    }

    public <T> T select(String sql, ResultSetHandler<T> resultSetHandler, Object... parameters) throws SQLException {
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            populatePreparedStatement(ps, parameters);
            ResultSet rs = ps.executeQuery();
            return resultSetHandler.handle(rs);
        }
    }

    public <T> T insert(String sql, ResultSetHandler<T> resultSetHandler, Object... parameters) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            populatePreparedStatement(preparedStatement, parameters);
            int result = preparedStatement.executeUpdate();
            if (result != 1) {
                connection.rollback();
                throw new SQLException("Can't insert row to database. Result=" + result);
            }
            connection.commit();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            return resultSetHandler.handle(resultSet);
        }
    }

    public void insertBatch(String sql, List<Object[]> paramList) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            for (Object[] param : paramList) {
                populatePreparedStatement(statement, param);
                statement.addBatch();
            }
            statement.executeBatch();
            connection.commit();
        }
    }

    private void populatePreparedStatement(PreparedStatement ps, Object... parameters) throws SQLException {
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
        }
    }

    public void populateSqlAndParams(StringBuilder sql, List<Object> params, List<String> producers, List<String> carClasses, String minPrice, String maxPrice) {
        if (producers != null && !producers.isEmpty()) {
            setNameParam(sql, params, producers);
        }
        if (carClasses != null && !carClasses.isEmpty()) {
            setClassParam(sql, params, carClasses);
        }
        setPriceParam(sql, params, minPrice, maxPrice);
    }

    private void setClassParam(StringBuilder sql, List<Object> params, List<String> carClasses) {
        sql.append(" and (class=?");
        for (int i = 0; i < carClasses.size(); i++) {
            params.add(carClasses.get(i));
            if (i != carClasses.size() - 1) {
                sql.append(" or class=?");
            }
        }
        sql.append(")");
    }

    private void setPriceParam(StringBuilder sql, List<Object> params, String minPrice, String maxPrice) {
        if (!minPrice.isEmpty()) {
            sql.append(" and (cost>=?)");
            params.add(minPrice);
        }
        if (!maxPrice.isEmpty()) {
            sql.append(" and (cost<=?)");
            params.add(maxPrice);
        }
    }

    private void setNameParam(StringBuilder sql, List<Object> params, List<String> producers) {
        sql.append(" and (mark=?");
        for (int i = 0; i < producers.size(); i++) {
            params.add(producers.get(i));
            if (i != producers.size() - 1) {
                sql.append(" or mark=?");
            }
        }
        sql.append(")");
    }
}
