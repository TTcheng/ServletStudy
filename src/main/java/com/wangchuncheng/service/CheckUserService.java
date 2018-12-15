package com.wangchuncheng.service;

import com.wangchuncheng.ConnectionFactory;
import com.wangchuncheng.dao.UserDaoImpl;
import com.wangchuncheng.dao.UserDao;
import com.wangchuncheng.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckUserService {
    private UserDao userDao = new UserDaoImpl();
    public boolean check(User user){
        Connection connection = null;
        connection=ConnectionFactory.getInstance().makeConnection();
        try {
            connection.setAutoCommit(false);
            ResultSet resultSet = userDao.get(connection,user);
            while (resultSet.next()){
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
