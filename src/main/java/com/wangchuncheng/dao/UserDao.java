package com.wangchuncheng.dao;

import com.wangchuncheng.entity.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface UserDao {
    public boolean save(Connection connection, User user) throws SQLException;
    public boolean update(Connection connection, Long id, User user)throws SQLException;
    public boolean delete(Connection connection, User user)throws SQLException;
    public ResultSet get(Connection connection,User user) throws SQLException;
}
