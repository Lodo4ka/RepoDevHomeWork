import java.sql.*;
import java.util.StringJoiner;

/**
 * Created by lodo4ka on 20/05/2017.
 */
public class EntryPoint {

    public static void main(String[] args) {

        try {
            Class<?> aClass = Class.forName("org.sqlite.JDBC");

            Connection connection = DriverManager.getConnection("jdbc:sqlite:HomeWorkNumberTen/DB/MYDataBase.sqlite");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            queries(statement);

        } catch (ClassNotFoundException e) {
            System.out.println("SQLITE library not in classpath. Reason: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Failed to established connection. Reason: " + e.getMessage());
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void queries(Statement statement){

        try {
            statement.executeUpdate("DROP TABLE IF EXISTS person");
            statement.executeUpdate("CREATE TABLE person (ID  INTEGER , NAME TEXT, AGE INTEGER , CITY STRING)");
            statement.executeUpdate("INSERT INTO person VALUES (0, 'Vasya', 20, 'Moscow')");
            statement.executeUpdate("INSERT INTO person VALUES (1, 'Petya', 30, 'Moscow')");

            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");


            StringBuilder stringBuilder = new StringBuilder();
            while (resultSet.next()){
                StringJoiner stringJoiner = new StringJoiner("\t\t");
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NAME");
                String city = resultSet.getString("CITY");

                stringJoiner.add(id+ "").add(name).add(city);
                stringBuilder.append(stringJoiner.toString()).append("\n");
            }

            System.out.println(stringBuilder.toString());

        } catch (SQLException e) {
            throw new IllegalStateException("Failed to execute query. Reason:" + e.getMessage());
        }
    }
}