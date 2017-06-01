import MyConnection.db.DbHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.StringJoiner;

/**
 * Created by lodo4ka on 21/05/2017.
 */
public class EntryPoint {

    public static void main(String[] args) {

        System.out.println("Hello My Friend.\nIf you want to register, please press 1;\nor if you have account, then press 2;");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            int choice = Integer.parseInt(reader.readLine());
            chooseVersionApplication(reader, choice);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void chooseVersionApplication(BufferedReader reader, int inputOption) throws IOException {


        // load the sqlite-JDBC driver using the current class loader
        DbHandler dbHandler = new DbHandler("jdbc:sqlite:HomeWorkNumberTen/DB/MYDataBase.sqlite");
        createTableUser(dbHandler);
        createTableProducts(dbHandler);
        createTableOrder(dbHandler);
        if (inputOption == 1) {
            precessRegistration(reader, dbHandler);
        } else if (inputOption == 2) {
            String name = processAuthorization(reader, dbHandler);

            System.out.println("If you want to see products press 1:\nIf you want to do order press 2:");
            int choice = Integer.parseInt(reader.readLine());
            {
                if (choice == 1) {
                    processShowAllProduct(reader, dbHandler);
                } else if (choice == 2) {
                    processOrdering(name,reader, dbHandler);
                }
            }
        } else {
            String msg = "Illegal Argument of this application";
            throw new IllegalArgumentException(msg);
        }
    }

    public static void processOrdering(String name,BufferedReader reader, DbHandler dbHandler) throws IOException {
        System.out.println("Please input your id products");

        String id = reader.readLine();
        System.out.println("Please input your amount products");
        String amount = reader.readLine();

        List<String> list = Arrays.asList("name", "description","amount", "orderDate");
        HashMap<String, String> conditionMap = new HashMap<>();
        conditionMap.put("productID", id);
        conditionMap.put("amount", amount);

        ResultSet resultSet = dbHandler.selectWithInnerJoin(list,"products", "OrderInfo",
                "id", "productID", conditionMap);

        StringJoiner tableJoiner = new StringJoiner("\n");

        try{
            while (resultSet.next()){
                StringJoiner rowJoiner = new StringJoiner("\t\t");
                rowJoiner.add(resultSet.getString("name")).
                        add(resultSet.getString("amount")).add(resultSet.getString("orderDate")).
                        add(resultSet.getString("description"));
                tableJoiner.add(rowJoiner.toString());
            }
        }
        catch (SQLException e){
            throw new IllegalStateException("Failed to retrieve result");
        }


        System.out.println("name:\t\t" + "product:\t" + "amount:\t\t" + "date:\t\t" + "description:");
        System.out.println(name + "\t\t" + tableJoiner);
    }

    private static void processShowAllProduct(BufferedReader reader, DbHandler dbHandler) {


        List<String> list = Arrays.asList("id", "name", "description");

        ResultSet resultSet = dbHandler.selectWithoutCondition(list, "products");


        StringJoiner tableJoiner = new StringJoiner("\n");


        try {
            while (resultSet.next()) {
                StringJoiner rowJoiner = new StringJoiner("\t\t");
                rowJoiner.add(resultSet.getString("id")).add(resultSet.getString("name")).
                        add(resultSet.getString("description"));
                tableJoiner.add(rowJoiner.toString());
            }

        } catch (SQLException e) {
            throw new IllegalStateException("Failed to retrieve result");
        }

        System.out.println(tableJoiner);
    }

    private static String getDescription(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                return resultSet.getString("description");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to retrieve result");
        }
        throw new IllegalArgumentException("id or name or description incorrect");

    }

    private static String getId(ResultSet resultSet) {

        try {
            while (resultSet.next()) {
                return resultSet.getString("id");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to retrieve result");
        }
        throw new IllegalArgumentException("id or name or description incorrect");
    }


    public static void createTableUser(DbHandler dbHandler) {
        HashMap<String, String> shopColumnMap = new HashMap<>();
        shopColumnMap.put("name", "text");
        shopColumnMap.put("email", "text");
        shopColumnMap.put("password", "text");

        dbHandler.createTable("user", shopColumnMap);

    }

    public static String processAuthorization(BufferedReader reader, DbHandler dbHandler) throws IOException {


        System.out.println("Welcome to authorized\nWrite your email");
        String email = reader.readLine();
        System.out.println("Write your password");
        String password = reader.readLine();

        List<String> columnList = Arrays.asList("name", "email", "password");
        HashMap<String, String> conditionMap = new HashMap<>();
        conditionMap.put("email", email);
        conditionMap.put("password", password);
        ResultSet resultSet = dbHandler.select(columnList, "user", conditionMap);

        String name = getName(resultSet);


        System.out.println("Hello, " + name + "!");
        return name;
    }


    public static void createTableProducts(DbHandler dbHandler) {
        HashMap<String, String> productsColumnMAp = new HashMap<>();
        productsColumnMAp.put("id", "integer");
        productsColumnMAp.put("name", "text");
        productsColumnMAp.put("description", "text");

        dbHandler.createTable("products", productsColumnMAp);
    }

    public static void createTableOrder(DbHandler dbHandler) {

        LocalDateTime now = LocalDateTime.now();

        HashMap<String, String> orderColumnMap = new HashMap<>();
        orderColumnMap.put("id", "integer");
        orderColumnMap.put("UserId", "integer");
        orderColumnMap.put("productID", "integer");
        orderColumnMap.put("amount", "integer");
        orderColumnMap.put("orderDate", "text");

        dbHandler.createTable("OrderInfo", orderColumnMap);


    }

    public static String getName(ResultSet resultSet) {
        try {
            while (resultSet.next()) {
                return resultSet.getString("name");
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Failed to retrieve result");
        }
        throw new IllegalArgumentException("Login or password incorrect");
    }

    public static void precessRegistration(BufferedReader reader, DbHandler dbHandler) throws IOException {
        System.out.println("Welcome for registration .\nWrite your name");
        String name = reader.readLine();
        System.out.println("Write your email");
        String email = reader.readLine();
        System.out.println("Write your password");
        String pass = reader.readLine();


        HashMap<String, String> columnValueMAp = new HashMap<>();
        columnValueMAp.put("name", name);
        columnValueMAp.put("email", email);
        columnValueMAp.put("password", pass);

        dbHandler.insertInto("user", columnValueMAp);


        System.out.println("Registration succeed!");
    }
}