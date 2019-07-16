package com.epam.dao.impl;

import com.epam.dao.UserDao;
import com.epam.database.DataBaseManager;
import com.epam.database.ResultSetHandler;
import com.epam.database.ResultSetHandlerFactory;
import com.epam.entity.User;
import com.epam.exception.InternalServerErrorException;
import com.epam.utils.AllRequestDB;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {


    private final ResultSetHandler<User> USER_RESULT_SET_HANDLER = rs -> new User.UserBuilder()
            .setId(rs.getInt("id"))
            .setName(rs.getString("name"))
            .setSurname(rs.getString("sur_name"))
            .setEmail(rs.getString("login"))
            .setPassword(rs.getString("password"))
            .setImageUrl(rs.getString("image_url"))
            .build();
    private DataBaseManager dataBaseManager;

    public UserDaoImpl(DataBaseManager dataBaseManager) {
        this.dataBaseManager = dataBaseManager;
    }

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
                    user.getName(), user.getSurname(), user.getEmail(), user.getPassword(), user.getImageUrl());
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

    @Override
    public User getUserByEmailAndPass(String login, String pass) {
        try {
            return dataBaseManager.select(AllRequestDB.SELECT_USER_BY_EMAIL_AND_PASS,
                    ResultSetHandlerFactory.getSingleResultSetHandler(USER_RESULT_SET_HANDLER), login, pass);
        } catch (SQLException e) {
            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
        }
    }

//    @Override
//    public void setImageUrl(String fileNameForSpecificUser, String  login) {
//        try {
//            System.out.println(fileNameForSpecificUser);
//            System.out.println(login);
//            dataBaseManager.update(AllRequestDB.UPDATE_USER_IMAGE_URL,
//                    ResultSetHandlerFactory.getSingleResultSetHandler(USER_RESULT_SET_HANDLER),fileNameForSpecificUser,login);
//        } catch (SQLException e) {
//            throw new InternalServerErrorException("Cant't execute SQL query: " + e.getMessage(), e);
//        }
//    }
}
