package com.czz.mybatis.service;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-08-30 15:06
 * 执行器
 */
public interface MyExecutor {
    public <T> T query(String statement);
}
