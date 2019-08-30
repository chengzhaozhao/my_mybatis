package com.czz.mybatis.session;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-08-30 21:33
 */
public interface MySqlSession {

    <T>  T selectOne(String  var1);

    <T> T getMapper(Class<T> var1);
 }
