package com.epam.repository.impl;

import com.epam.constans.SqlQueries;
import com.epam.database.DataBaseManager;
import com.epam.database.ResultSetHandler;
import com.epam.database.ResultSetHandlerFactory;
import com.epam.entity.Order;
import com.epam.entity.OrderItem;
import com.epam.entity.User;
import com.epam.exception.InternalServerErrorException;
import com.epam.model.ShoppingCart;
import com.epam.repository.OrderRepository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private DataBaseManager dataBaseManager;

    private final ResultSetHandler<Order> ORDER_RESULT_SET_HANDLER = rs -> {
        Order order = new Order();
        rs.next();
        order.setId(rs.getInt(1));
        return order;
    };

    private final ResultSetHandler<Order> GET_DATA_ORDER_RESULT_SET_HANDLER = rs -> {
        Order order = new Order();
        order.setIdAccount(rs.getInt("id_account"));
        order.setCreated(rs.getTimestamp("created"));
        order.setId(rs.getInt("id"));
        order.setStatus(rs.getString("order_status"));
        order.setStatusDescription(rs.getString("status_description"));
        return order;
    };

    public OrderRepositoryImpl(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

    @Override
    public int makeOrder(ShoppingCart shoppingCart, User currentAccount) {
        if (shoppingCart == null || shoppingCart.getCars().isEmpty()) {
            throw new InternalServerErrorException("shoppingCart is null or empty");
        }
        try {
            Order order = dataBaseManager.insert(SqlQueries.CREATE_NEW_ORDER, ORDER_RESULT_SET_HANDLER,
                    currentAccount.getId(), new Timestamp(System.currentTimeMillis()), "test", "test");
            order = dataBaseManager.select(SqlQueries.GET_DATA_NEW_ORDER,
                    ResultSetHandlerFactory.getSingleResultSetHandler(GET_DATA_ORDER_RESULT_SET_HANDLER), order.getId());
            dataBaseManager.insertBatch(SqlQueries.CREATE_NEW_ORDER_ITEM, toOrderItemParameterList(order.getId(), shoppingCart.getCars()));
            return order.getId();
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    private List<Object[]> toOrderItemParameterList(int id, Collection<OrderItem> cars) {
        List<Object[]> parametersList = new ArrayList<>();
        for (OrderItem item : cars) {
            parametersList.add(new Object[]{id, item.getCar().getId(), item.getDays()});
        }
        return parametersList;
    }
}
