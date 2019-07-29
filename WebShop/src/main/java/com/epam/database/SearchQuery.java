package com.epam.database;

import java.util.List;

public class SearchQuery {

    private StringBuilder sql;
    private List<Object> params;

    public SearchQuery(StringBuilder sql, List<Object> params) {
        super();
        this.sql = sql;
        this.params = params;
    }

    public StringBuilder getSql() {
        return sql;
    }

    public List<Object> getParams() {
        return params;
    }
}
