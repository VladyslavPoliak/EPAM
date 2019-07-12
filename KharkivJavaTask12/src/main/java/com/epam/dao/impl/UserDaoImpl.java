package com.epam.dao.impl;

import com.epam.dao.UserDao;
import com.epam.database.DataBaseManager;
import com.epam.database.ResultSetHandler;
import com.epam.database.ResultSetHandlerFactory;
import com.epam.entity.User;
import com.epam.exception.InternalServerErrorException;
import com.epam.utils.AllRequestDB;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private final Logger LOGGER = Logger.getLogger(UserDaoImpl.class);
    private DataBaseManager dataBaseManager;

    public UserDaoImpl(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

    private final ResultSetHandler<User> USER_RESULT_SET_HANDLER = rs -> {
        if (rs.getMetaData().getColumnCount() == 1) {
            return new User.UserBuilder().setId(rs.getInt(1))
                    .build();
        } else {
            return new User.UserBuilder()
                    .setId(rs.getInt("id"))
                    .setName(rs.getString("name"))
                    .setSurname(rs.getString("sur_name"))
                    .setEmail("login")
                    .setPassword("password")
                    .build();
        }
    };

    @Override
    public List<User> getAllUsers() {
        try {
            return dataBaseManager.select(AllRequestDB.SELECT_ALL_USERS,
                    ResultSetHandlerFactory.getListResultSetHandler(USER_RESULT_SET_HANDLER));
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    @Override
    public void addNewUser(User user) {
        try {
            dataBaseManager.insert(AllRequestDB.INSERT_NEW_USER,
                    ResultSetHandlerFactory.getSingleResultSetHandler(USER_RESULT_SET_HANDLER),
                    user.getName(), user.getSurname(), user.getEmail(), user.getPassword());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }
}
