package com.epam.database;

import org.apache.commons.dbcp2.BasicDataSource;

public class DataBaseManager {
    private BasicDataSource dataSource;

    public DataBaseManager(BasicDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public <T> T doOperation(DbOperation<T> operation){
return null;
    }
}
