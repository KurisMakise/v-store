package store.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.order.entity.OrderProduct;

import java.util.List;

/**
 * author  violet
 * createTime 2019/3/23 19:47
 * description
 * version 1.0
 */
@FeignClient(name = "store-order-service/orderProductService")
public interface IOrderProductService {

    @PostMapping("/listByOrderId")
    List<OrderProduct> listByOrderId(@RequestParam("orderId") Long orderId);
}
