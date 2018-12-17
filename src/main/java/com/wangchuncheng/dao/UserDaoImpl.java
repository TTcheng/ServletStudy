package com.wangchuncheng.dao;

import com.wangchuncheng.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    /**
     * 保存用户信息
     * @param connection
     * @param user
     * @throws SQLException
     */
    @Override
    public boolean save(Connection connection, User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareCall("INSERT INTO ServletStudyUser VALUES (?,?,?,?)");
        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getName());
        preparedStatement.setString(4,user.getEmail());
        return preparedStatement.execute();
    }

    /**
     * 根据指定id更新用户信息
     * @param connection
     * @param user
     * @throws SQLException
     */
    @Override
    public boolean update(Connection connection, Long id, User user) throws SQLException {
        String updateSql = "UPDATE ServletStudyUser SET \"uname\"=?,\"upwd\"=?,\"umail\"=? WHERE \"id\"=?";
        PreparedStatement preparedStatement = connection.prepareCall(updateSql);
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getPassword());
        preparedStatement.setString(3,user.getEmail());
        preparedStatement.setLong(4,id);
        return preparedStatement.execute();
    }

    /**
     * 根据删除指定用户信息
     * @param connection
     * @param user
     * @throws SQLException
     */
    @Override
    public boolean delete(Connection connection, User user) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareCall("DELETE FROM ServletStudyUser WHERE \"uid\" = ?");
        preparedStatement.setLong(1,user.getId());
        return preparedStatement.execute();
    }

    @Override
    public ResultSet get(Connection connection, User user) throws SQLException {
        String sql = "SELECT * FROM ServletStudyUser WHERE \"uname\"=? AND \"upwd\"=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,user.getName());
        preparedStatement.setString(2,user.getPassword());
        return preparedStatement.executeQuery();
    }
}
