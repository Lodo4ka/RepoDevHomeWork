package repository.db;


import java.sql.*;
import java.util.*;

/**
 * Created by lodo4ka on 20/05/2017.
 */
public class DbHandler {

    Statement statement;
    Connection connection;
    private static DbHandler instance;


    private DbHandler(final String connectionString) {
        try {
            this.connection = DriverManager.getConnection(connectionString);
            this.statement = connection.createStatement();
        } catch (SQLException e) {
            throw new IllegalStateException("Database Exception. Reason: " + e.getMessage());
        }
    }

    public static DbHandler getInstance() {
        if(instance ==null){
            instance = new DbHandler("jdbc:sqlite:HomeWorkNumberTwelve/DB/registration.sqlite");
            HashMap<String, String> columnMap = new HashMap<>();
            columnMap.put("name", "text");
            columnMap.put("password", "text");
            instance.createTable("user", columnMap);
        }
        return instance;
    }

    public void insertInto(String table, Map<String, String> columnValueMap) {

        StringJoiner columnJoiner = new StringJoiner(",");
        StringJoiner valuesJoiner = new StringJoiner(",");


        Set<Map.Entry<String, String>> entries = columnValueMap.entrySet();


        for (Map.Entry<String, String> entry : entries) {
            columnJoiner.add(entry.getKey());
            valuesJoiner.add("'" + entry.getValue() + "'");
        }


        try {
            String sqlQuery = "INSERT INTO " + table + "( " + columnJoiner.toString() + ") VALUES (" + valuesJoiner.toString() + ")";
            System.out.println("querying Db" + sqlQuery);
            statement.execute(sqlQuery);
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to execute inert query. Reason: " + e.getMessage());
        }
    }


    public void createTable(String tableName, Map<String, String> namesTypesMap) {

        StringJoiner stringJoiner = new StringJoiner(",");
        Set<Map.Entry<String, String>> entries = namesTypesMap.entrySet();

        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            stringJoiner.add(key + " " + value);
        }

        try {
            String sqlQuery = "CREATE TABLE IF NOT EXISTS " + tableName + " (" + stringJoiner.toString() + ")";
            System.out.println(sqlQuery);
            statement.execute(sqlQuery);
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to create table. Reason: " + e.getMessage());
        }
    }

    public void dropTableIfExists(String tableName) {

        try {
            statement.execute("DROP  TABLE IF EXISTS " + tableName);
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to drop table. Reason: " + e.getMessage());
        }

    }


    public ResultSet selectWithInnerJoin( List<String> columns ,String tableName1, String tableName2,
                                         String condition1, String condition2,Map<String, String> whereConditionMap) {

        StringJoiner stringJoiner = new StringJoiner(",");
        for (String column : columns) {
            stringJoiner.add(column);
        }


        StringJoiner stringJoiner2 = new StringJoiner(" AND ");
        Set<Map.Entry<String, String>> entries = whereConditionMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            stringJoiner2.add(entry.getKey() + "='" + entry.getValue() + "'");
        }

        try {
            String sqlQuery = "SELECT *"+ " FROM " + tableName1
                    + " INNER JOIN " + tableName2+ " ON " + tableName1 + "." + condition1 + " = " + tableName2 +"." + condition2
                    +  " WHERE " + stringJoiner2.toString();
            System.out.println(sqlQuery);
            return statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            throw new IllegalStateException("Filed to select command. Reason: " + e.getMessage());
        }

    }

    public ResultSet select(String tableName, Map<String, String> whereConditionMap) {

        StringJoiner stringJoiner2 = new StringJoiner(" AND ");

        Set<Map.Entry<String, String>> entries = whereConditionMap.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            stringJoiner2.add(entry.getKey() + "='" + entry.getValue() + "'");
        }


        try {
            String sqlQuery = "SELECT  * FROM " + tableName + " WHERE " + stringJoiner2.toString();
            System.out.println(sqlQuery);
            return statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            throw new IllegalStateException("Filed to select command. Reason: " + e.getMessage());
        }
    }

    public ResultSet selectWithoutCondition(List<String> columns, String tableName) {


        StringJoiner stringJoiner1 = new StringJoiner(",");
        for (String column : columns) {
            stringJoiner1.add(column);
        }

        try {
            String sqlQuery = "SELECT " + stringJoiner1.toString() + " FROM " + tableName;
            System.out.println(sqlQuery);
            return statement.executeQuery(sqlQuery);
        } catch (SQLException e) {
            throw new IllegalStateException("Filed to select command. Reason: " + e.getMessage());
        }
    }

    public void close() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to close db.");
        }
    }
}
