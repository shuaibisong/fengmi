package com.qfedu.util;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PoolJdbc {

    private static ComboPooledDataSource pool = new ComboPooledDataSource();

    public static Connection getConnection() throws SQLException {
        Connection connection = pool.getConnection();
        return connection;
    }


    public static void close(Connection connection) throws SQLException {
        close(connection,null,null);
    }

    public static void close(Connection connection, Statement statement ) throws SQLException {
        close(connection, statement,null);
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet) throws SQLException {
        if(connection!=null){
            connection.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(resultSet!=null){
            resultSet.close();
        }
    }
}
