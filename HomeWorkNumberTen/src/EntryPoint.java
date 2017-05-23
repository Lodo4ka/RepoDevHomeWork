import MyConnection.db.DbHandler;
import org.sqlite.JDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
            processAuthorization(reader, dbHandler);
        } else {

            String msg = "Illegal Argument of this application";
            throw new IllegalArgumentException(msg);
        }
    }

    public static void createTable(DbHandler dbHandler) {
        HashMap<String, String> shopColumnMap = new HashMap<>();
        shopColumnMap.put("name", "text");
        shopColumnMap.put("email", "text");
        shopColumnMap.put("password", "text");

        dbHandler.createTable("shop", shopColumnMap);
    }

    public static void processAuthorization(BufferedReader reader, DbHandler dbHandler) throws IOException {
        System.out.println("Welcome to authorized\nWrite your email");
        String email = reader.readLine();
        System.out.println("Write your password");
        String password = reader.readLine();

        List<String> columnList = Arrays.asList("name", "email", "password");
        HashMap<String, String> conditionMap = new HashMap<>();
        conditionMap.put("email", email);
        conditionMap.put("password", password);
        ResultSet resultSet = dbHandler.select(columnList, "shop", conditionMap);

        String name = getName(resultSet);

        System.out.println("Hello, " + name + "!");
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

        dbHandler.insertInto("shop", columnValueMAp);
        System.out.println("Registration succed!");
    }
}