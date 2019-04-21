package store.order.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * author  violet
 * createTime 2019/3/23 19:48
 * description TODO
 * version 1.0
 */
@FeignClient("store-order-service/orderStatusService")
public interface IOrderStatusService {
}
