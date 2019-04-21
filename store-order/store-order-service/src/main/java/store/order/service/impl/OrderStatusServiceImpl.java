package store.order.service.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.order.service.IOrderStatusService;

/**
 * author  violet
 * createTime 2019/3/23 19:50
 * description 订单状态
 * version 1.0
 */
@RestController
@RequestMapping("/orderStatusService")
@Api(tags = {"订单状态"})
public class OrderStatusServiceImpl implements IOrderStatusService {

}
