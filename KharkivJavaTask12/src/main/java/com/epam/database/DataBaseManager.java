package com.epam.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public boolean insert(String sql, Object... parameters) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            populatePreparedStatement(preparedStatement, parameters);
            int result = preparedStatement.executeUpdate();
            if (result != 1) {
                connection.rollback();
                throw new SQLException("Can't insert row to database. Result=" + result);
            }
            connection.commit();
            return true;
        }
    }

    private void populatePreparedStatement(PreparedStatement ps, Object... parameters) throws SQLException {
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                ps.setObject(i + 1, parameters[i]);
            }
        }
    }
}
