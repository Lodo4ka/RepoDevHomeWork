package service;

import entity.OrderInfo;
import repository.OrderInfoRepository;

import java.util.List;

/**
 * Created by lodo4ka on 08/06/2017.
 */
public class OrderInfoService {

   OrderInfoRepository orderInfoRepository = new OrderInfoRepository();

   public List<OrderInfo>getInfo(){
       return orderInfoRepository.selectInfo();
   }
}
