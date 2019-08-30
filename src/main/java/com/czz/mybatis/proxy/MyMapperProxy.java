package com.czz.mybatis.proxy;

import com.czz.mybatis.mapper.xml.UserXml;
import com.czz.mybatis.session.MySqlSession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-08-30 21:38
 */
public class MyMapperProxy implements InvocationHandler {
    public MySqlSession sqlSession;

    public MyMapperProxy() {
    }

    public MyMapperProxy(MySqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    /**
     * 动态代理
     * @param o
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object o, Method method, Object[] args) throws Throwable {
        String mapperCLass = method.getDeclaringClass().getName();
        if (UserXml.namespace.equals(mapperCLass)) {
            String methodName = method.getName();
            String originSql = UserXml.getMethodSql(methodName);
            // 替换 %d
            String formattedSql = String.format(originSql,String.valueOf(args[0]));
            return sqlSession.selectOne(formattedSql);
        }

        return null;
    }
}
