import MyConnection.db.DbHandler;
import org.sqlite.JDBC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lodo4ka on 21/05/2017.
 */
public class EntryPoint2 {

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



    public static void chooseVersionApplication(BufferedReader reader, int v) throws IOException {


        // load the sqlite-JDBC driver using the current class loader
        DbHandler dbHandler = new DbHandler("jdbc:sqlite:HomeWorkNumberTen/DB/MYDataBase.sqlite");



        if(v == 1){
            System.out.println("Welcome for registration .Write your name");
            String name = reader.readLine();
            System.out.println("Write your email");
            String email = reader.readLine();
            Map<String, String> personMap = new HashMap<>();
            personMap.put("name", "email");
            dbHandler.execute_createTable("person", personMap);
            List<String> list = Arrays.asList(name, email);
            dbHandler.execute_Insert("person", list);
        }
        else if(v == 2){

        }
        else {

            String msg = "Illegal Argument of this application";
            throw  new IllegalArgumentException(msg);
        }
    }
}