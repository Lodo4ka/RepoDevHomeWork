package service;

import entity.OrderInfo;
import entity.Product;
import entity.User;
import repository.OrderInfoRepository;

import java.util.List;

/**
 * Created by lodo4ka on 08/06/2017.
 */
public class OrderInfoService {

   OrderInfoRepository orderInfoRepository = new OrderInfoRepository();

   public List<OrderInfo>getInfo(){
       return orderInfoRepository.selectOrders();
   }

    public void addOrder(final Product product, final User user, final int amount) {

        final int price = product.getPrice() * amount;
        orderInfoRepository.addOrder(product.getId(), user, amount, price);
        return ;
    }
}
