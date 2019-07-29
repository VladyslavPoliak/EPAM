package com.epam.database;

import java.util.ArrayList;
import java.util.List;

public class ResultSetHandlerFactory {

    public static <T> ResultSetHandler<T> getSingleResultSetHandler(final ResultSetHandler<T> oneRowResultSetHandler) {
        return rs -> {
            if (rs.next()) {
                return oneRowResultSetHandler.handle(rs);
            } else {
                return null;
            }
        };
    }

    public static <T> ResultSetHandler<List<T>> getListResultSetHandler(final ResultSetHandler<T> oneRowResultSetHandler) {
        return rs -> {
            List<T> list = new ArrayList<>();
            while (rs.next()) {
                list.add(oneRowResultSetHandler.handle(rs));
            }
            return list;
        };
    }

    public static ResultSetHandler<Integer> getCountResultSetHandler() {
        return rs -> {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return 0;
            }
        };
    }

}
