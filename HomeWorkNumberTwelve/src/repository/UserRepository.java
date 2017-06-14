package repository;

import entity.User;
import exception.DatabaseException;
import repository.db.DbHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by lodo4ka on 06/06/2017.
 */
public class UserRepository {

    private DbHandler dbHandler = DbHandler.getInstance();

    public void create(final User user) {


        HashMap<String, Object> columnMap = new HashMap<>();
        columnMap.put("name", user.getName());
        columnMap.put("password", user.getPassword());
        dbHandler.insertInto("user", columnMap);
    }

    public int exists(final User user) {
        HashMap<String, String> conditionMap = new HashMap<>();
        conditionMap.put("name", user.getName());
        conditionMap.put("password", user.getPassword());

        ResultSet resultSet = dbHandler.select("user", conditionMap);

        try {
            return resultSet.getInt("id");
        } catch (SQLException e) {
           return -1;
        }

    }
}
