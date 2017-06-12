package repository;

import entity.OrderInfo;
import entity.Product;
import entity.User;
import repository.db.DbHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by lodo4ka on 08/06/2017.
 */
public class OrderInfoRepository {

    private DbHandler dbHandler = DbHandler.getInstance();


    public List<OrderInfo> selectInfo() {
        ResultSet resultSet = dbHandler.selectWithoutCondition("orderInfo");

        LinkedList<OrderInfo> orderInfos = new LinkedList<>();

        try {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int product = resultSet.getInt("product");
                int amount = resultSet.getInt("amount");
                int price = resultSet.getInt("price");
                OrderInfo orderInfo = new OrderInfo(id, name, product, amount, price);
                orderInfos.add(orderInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderInfos;
    }

    public OrderInfo insertOrderInfo(Product product, User user) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("name", user.getName());
        map.put("product", product.getId());

        map.put("price", product.getPrice() * ); //TODO add amount product from field amount
        dbHandler.insertInto("orderInfo", map);

    }
}
