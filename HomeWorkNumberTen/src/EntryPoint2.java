import MyConnection.db.DbHandler;
import org.sqlite.JDBC;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by lodo4ka on 21/05/2017.
 */
public class EntryPoint2 {

    public static void main(String[] args) {

        System.out.println("Hello My Friend.\nIf you want to register, please press 1;\nor if you have account, then press 2;");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int choice = Integer.parseInt(reader.readLine());



        // load the sqlite-JDBC driver using the current class loader
        DbHandler dbHandler = new DbHandler("jdbc:sqlite:HomeWorkNumberTen/DB/MYDataBase.sqlite");



    }
}