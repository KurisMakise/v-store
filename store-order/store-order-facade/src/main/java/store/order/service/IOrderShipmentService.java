package store.order.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.order.entity.OrderShipment;

/**
 * author  violet
 * createTime 2019/3/23 19:48
 * description 订单配送
 * version 1.0
 */
@FeignClient(name = "store-order-service/orderShipmentService")
public interface IOrderShipmentService {

    @PostMapping("/getByOrderId")
    OrderShipment getByOrderId(@RequestParam("orderNumber") Long orderNumber);

}
