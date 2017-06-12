package repository;

import entity.Product;
import repository.db.DbHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lodo4ka on 08/06/2017.
 */
public class ProductRepository {


    private DbHandler dbHandler = DbHandler.getInstance();

    public List<Product> selectAllProducts() {


        LinkedList<Product> products = new LinkedList<>();
        ResultSet resultSet = dbHandler.selectWithoutCondition("product");
        try {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                String type = resultSet.getString("type");
                Product product = new Product(id,name, description, type, price);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }


    public Product getById(Integer id) {

        HashMap<Object, Object> map = new HashMap<>();
        map.put("id", id);
        ResultSet resultSet = dbHandler.select("product", map);

        try {
            while (resultSet.next()){
                int id1 = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String description = resultSet.getString("description");
                String type = resultSet.getString("type");
                Product product = new Product(id1,name, description, type, price);
                return product;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
