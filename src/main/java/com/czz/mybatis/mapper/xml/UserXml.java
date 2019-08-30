package com.czz.mybatis.mapper.xml;

import java.util.HashMap;
import java.util.Map;

/**
 * @author chengzhzh@datangmobile.com
 * @create 2019-08-30 21:29
 */
public class UserXml {
    public static final String namespace = "com.czz.mybatis.mapper.UserMapper";

    private static Map<String,String> methodSqlMap = new HashMap<>();

    static {
        methodSqlMap.put("findUserById","select *  from tb_user where id = %s");
    }

    public static String getMethodSql(String method) {
        return methodSqlMap.get(method);
    }
}
