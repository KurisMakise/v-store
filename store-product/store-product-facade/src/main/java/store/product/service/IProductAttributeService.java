package store.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.product.pojo.vo.ProductAttributeVO;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
@FeignClient(name = "store-product-service/productAttributeService")
public interface IProductAttributeService {

    @PostMapping("/getProductAttrVO")
    ProductAttributeVO getProductAttrVO(@RequestParam("productId") Long productId);

}
