package store.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.product.pojo.dto.ProductSpecificationDTO;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
@FeignClient(name = "store-product-service/productSpecificationService")
public interface IProductSpecificationService {

    @PostMapping("/listProductSpec")
    ProductSpecificationDTO listProductSpec(@RequestParam("productId") Long productId,
                                            @RequestParam("status") Integer status);
}
