package service;

import entity.OrderInfo;
import entity.Product;
import entity.User;
import repository.OrderInfoRepository;
import repository.ProductRepository;

import java.util.List;

/**
 * Created by lodo4ka on 08/06/2017.
 */
public class ProductService {

    ProductRepository productRepository = new ProductRepository();

    OrderInfoRepository orderInfoRepository = new OrderInfoRepository();



    public List<Product> getProducts() {
        return productRepository.selectAllProducts();
    }

    public void addOrder(Integer id) {
        Product product = productRepository.getById(id);
        OrderInfo orderInfo = orderInfoRepository.insertOrderInfo(product, );
    }
}
