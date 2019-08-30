package com.czz.mybatis.session.impl;

import com.czz.mybatis.proxy.MyMapperProxy;
import com.czz.mybatis.service.MyExecutor;
import com.czz.mybatis.service.impl.MyBaseExecutor;
import com.czz.mybatis.session.MySqlSession;

import java.lang.reflect.Proxy;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-08-30 21:35
 */
public class MyDefaultSqlSession implements MySqlSession {
    private MyExecutor executor = new MyBaseExecutor();

    @Override
    public <T> T selectOne(String sql) {
        return executor.query(sql);
    }

    @Override
    public <T> T getMapper(Class<T> interfaces) {
        // 类加载器 代理的类 动态代理的类型
        return (T) Proxy.newProxyInstance(interfaces.getClassLoader(),new Class[]{interfaces},new MyMapperProxy(this));
    }
}
