package com.czz.mybatis;

import com.czz.mybatis.bean.User;
import com.czz.mybatis.mapper.UserMapper;
import com.czz.mybatis.session.MySqlSession;
import com.czz.mybatis.session.impl.MyDefaultSqlSession;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyMybatisApplication.class, args);

        start();
    }

    private static void start() {
        // 获取数据库连接
        MySqlSession sqlSession = new MyDefaultSqlSession();
        //  创建代理类的实例->动态代理的类型
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // 执行操作
        User user = userMapper.findUserById(1);

        System.out.println(user);
    }

}
