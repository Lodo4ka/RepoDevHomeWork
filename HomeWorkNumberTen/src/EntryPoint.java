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
        createTable(dbHandler);

        if (inputOption == 1) {
            precessRegistration(reader, dbHandler);
        } else if (inputOption == 2) {
            if(processAuthorization(reader, dbHandler)){
                createTableForPerson(dbHandler);
                System.out.println("If you want to see all products then press 1" +
                        "If you want to order then press 2");
                if(inputOption == 1){
                    List<String> columnlist = Arrays.asList("id", "name", "description");
                    HashMap<String, String> conditionMap = new HashMap<>();
                    ResultSet products = dbHandler.select(columnlist, "products", conditionMap);

                    String string = products.toString();
                    System.out.println(string);
                }
                else if (inputOption == 2){
                    System.out.println("Please input id products");
                    String id = reader.readLine();
                    System.out.println("Please input amount products");
                    String amount = reader.readLine();
                    List<String> list = Arrays.asList("UserId", "productId", "amount", "orderDate");
                    HashMap<String, String> conditionMap = new HashMap<>();
                    ResultSet order = dbHandler.select(list, "Order", conditionMap);
                    String string = order.toString();
                    System.out.println(string);
                }
            };
        } else {

            String msg = "Illegal Argument of this application";
            throw new IllegalArgumentException(msg);
        }
    }

    private static void orderVerification() {


    }

    public static void createTableForPerson(DbHandler dbHandler) {
        createTableProducts(dbHandler);
        createTableOrder(dbHandler);
    }

    public static void createTable(DbHandler dbHandler) {
        HashMap<String, String> shopColumnMap = new HashMap<>();
        shopColumnMap.put("name", "text");
        shopColumnMap.put("email", "text");
        shopColumnMap.put("password", "text");

        dbHandler.createTable("person", shopColumnMap);
    }

    public static boolean processAuthorization(BufferedReader reader, DbHandler dbHandler) throws IOException {


        System.out.println("Welcome to authorized\nWrite your email");
            String email = reader.readLine();
            System.out.println("Write your password");
            String password = reader.readLine();

            List<String> columnList = Arrays.asList("name", "email", "password");
            HashMap<String, String> conditionMap = new HashMap<>();
            conditionMap.put("email", email);
            conditionMap.put("password", password);
            ResultSet resultSet = dbHandler.select(columnList, "person", conditionMap);

            String name = getName(resultSet);

            System.out.println("Hello, " + name + "!");
            return true;
    }


     public static void createTableProducts(DbHandler dbHandler) {
        HashMap<String, String> productsColumnMAp = new HashMap<>();
        productsColumnMAp.put("id", "integer");
        productsColumnMAp.put("name", "text");
        productsColumnMAp.put("description", "text");

        dbHandler.createTable("products", productsColumnMAp);

        HashMap<String, String> productsInsertMap = new HashMap<>();
        productsInsertMap.put("id", "0");
        productsInsertMap.put("name", "Vasya");
        productsInsertMap.put("description", "I m Vasya");

         productsInsertMap.put("id", "1");
         productsInsertMap.put("name", "Petya");
         productsInsertMap.put("description", "I m Petya");

         productsInsertMap.put("id", "2");
         productsInsertMap.put("name", "Vova");
         productsInsertMap.put("description", "I m Vova");

        dbHandler.insertInto("products", productsInsertMap);
    }

    public static void createTableOrder(DbHandler dbHandler) {

        HashMap<String, String> orderColumnMap = new HashMap<>();
        orderColumnMap.put("id", "integer");
        orderColumnMap.put("UserId", "integer");
        orderColumnMap.put("productID", "integer");
        orderColumnMap.put("amount", "integer");
        orderColumnMap.put("orderDate", "text");

        dbHandler.createTable("Order", orderColumnMap);

        HashMap<String, String> orderInsertMap = new HashMap<>();
        LocalDateTime now = LocalDateTime.now();

        orderInsertMap.put("id", "0");
        orderInsertMap.put("UserId", "01");
        orderInsertMap.put("productID", "0");
        orderInsertMap.put("amount", "1");
        orderInsertMap.put("orderDate", Timestamp.valueOf(now).toString());

        orderInsertMap.put("id", "1");
        orderInsertMap.put("UserId", "02");
        orderInsertMap.put("productID", "1");
        orderInsertMap.put("amount", "2");
        orderInsertMap.put("orderDate", Timestamp.valueOf(now).toString());

        orderInsertMap.put("id", "2");
        orderInsertMap.put("UserId", "03");
        orderInsertMap.put("productID", "2");
        orderInsertMap.put("amount", "3");
        orderInsertMap.put("orderDate", Timestamp.valueOf(now).toString());

        dbHandler.insertInto("Order", orderInsertMap);
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

        dbHandler.insertInto("person", columnValueMAp);
        System.out.println("Registration succeed!");
    }
}