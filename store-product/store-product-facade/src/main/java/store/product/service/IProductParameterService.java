package store.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.product.pojo.vo.ProductParameterVO;

import java.util.List;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */

@FeignClient("store-product-service/productParameterService")
public interface IProductParameterService {

    @PostMapping("/listProductParameterVO")
    List<ProductParameterVO> listProductParameterVO(@RequestParam("productId") Long productId,
                                                    @RequestParam("status") Integer status);
}
