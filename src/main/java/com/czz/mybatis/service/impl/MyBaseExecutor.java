package com.czz.mybatis.service.impl;

import com.czz.mybatis.bean.User;
import com.czz.mybatis.service.MyExecutor;

import java.sql.*;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-08-30 21:13
 */
public class MyBaseExecutor implements MyExecutor{

    private final String CONNECTIONURL = "jdbc:mysql://39.98.200.95:3306/czz_java";
    private final String Driver = "com.mysql.jdbc.Driver";
    private final String USERNAME = "root";
    private final String PASSWORD = "Shikp@2019";

    @Override
    public <T> T query(String statement) {
        //jdbc 完成DB 操作获得结果
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet =null;

        try {
            Class.forName(Driver);
            connection = DriverManager.getConnection(CONNECTIONURL,USERNAME,PASSWORD);
            String sql = statement;
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();

            User user = null;
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setSex(resultSet.getInt("sex"));
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setAddress(resultSet.getString("address"));
            }
            return (T) user;

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                preparedStatement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }


        return null;
    }
}
