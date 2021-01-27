package com.qfedu.util;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaseDaoNew {

    public static <T> List<T> select(String sql, Object[] paras, Class<T> cls) throws SQLException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        if (sql == null) {
            throw new NullPointerException();
        }
        Connection connection = PoolJdbc.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();
        if (paras != null && parameterCount == paras.length) {
            for (int i = 1; i <= parameterCount; i++) {
                preparedStatement.setObject(i, paras[i - 1]);
            }

        }
        ResultSet resultSet = preparedStatement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        List<T> list = new ArrayList<>();
        while (resultSet.next()) {
            T t = cls.getConstructor(null).newInstance(null);
            for (int i = 1; i <= columnCount; i++) {
                String columnName = metaData.getColumnName(i);
                Object values = resultSet.getObject(columnName);
                BeanUtils.setProperty(t, columnName, values);
            }
            list.add(t);
        }

        return list;
    }

    public static ResultSet select(String sql, Object[] obj) throws Exception {
        ResultSet result = null;
        Connection conn = PoolJdbc.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < obj.length; i++) {
            ps.setObject(i + 1, obj[i]);

        }
        //result=ps.executeQuery();
        result = ps.executeQuery();
        return result;
    }
    public static int update(String sql, Object[] paras) throws SQLException {
        int j = 0;
        if (sql != null) {
            Connection connection = PoolJdbc.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int parameterCount = preparedStatement.getParameterMetaData().getParameterCount();
            if (paras != null && paras.length == parameterCount) {
                for (int i = 1; i <= parameterCount; i++) {
                    preparedStatement.setObject(i, paras[i - 1]);
                }
                j = preparedStatement.executeUpdate();
            }
            PoolJdbc.close(connection,preparedStatement);
        }

        return j;
    }
}