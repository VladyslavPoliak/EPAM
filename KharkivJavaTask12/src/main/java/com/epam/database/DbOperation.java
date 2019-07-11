package com.epam.database;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface DbOperation<T> {

    T handle(ResultSet resultSet) throws SQLException;
}
