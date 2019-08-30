package com.czz.mybatis.mapper;

import com.czz.mybatis.bean.User;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-08-30 21:27
 */
public interface UserMapper {
    public User findUserById(int id);

    public void insertStudent(User user);
}
