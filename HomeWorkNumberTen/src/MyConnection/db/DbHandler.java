package MyConnection.db;

import com.sun.org.apache.xpath.internal.operations.String;

import java.sql.*;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

/**
 * Created by lodo4ka on 20/05/2017.
 */
public class DbHandler {

    Statement statement;
    Connection connection;


    public DbHandler(final java.lang.String connectionString) {
        try {
            this.connection = DriverManager.getConnection(connectionString);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            throw new IllegalStateException("Database Exception. Reason: " + e.getMessage());
        }
    }

    public void execute_Insert(String table, List<String> values) {

        StringJoiner stringJoiner = new StringJoiner(",");

        for (String value : values
                ) {
            stringJoiner.add("" + value + "");

        }
        try {
            statement.execute("INSERT INTO " + table + " VALUES (" + stringJoiner.toString() + ")");
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to execute inert query. Reason: " + e.getMessage());
        }
    }


    public void execute_createTable(java.lang.String tableName, Map namesTypesMap) {

        StringJoiner stringJoiner = new StringJoiner(",");

        for (Object value : namesTypesMap.entrySet()) {
            stringJoiner.add("" + value + "");
        }

        try {
            statement.execute("CREATE TABLE " + tableName + " VAlUES (" + stringJoiner.toString() + ")");
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create table. Reason: " + e.getMessage());
        }
    }

    public void execute_dropTableIfExists(java.lang.String tableName) {

        try {
            statement.execute("DROP  TABLE IF EXISTS " + tableName);
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to drop table. Reason: " + e.getMessage());
        }

    }

    ResultSet execute_select(List columns, String tableName, Map whereConditionMap) {


        ResultSet resultSet;
        StringJoiner stringJoiner1 = new StringJoiner(",");

        for (Object val: columns
             ) {
            stringJoiner1.add("" + val + "");

        }

        StringJoiner stringJoiner2 = new StringJoiner(",");



        for (Object value : whereConditionMap.entrySet()
                ) {
            stringJoiner2.add("" + value + "");
        }


        try {
          resultSet = statement.executeQuery("SELECT " + stringJoiner1.toString() + " FROM " + tableName + " WHERE " + stringJoiner2.toString());
        } catch (SQLException e) {
            throw new IllegalStateException("Filed to select command. Reason: " + e.getMessage());
        }

        return resultSet;
    }


    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to close db.");
        }
    }


}
