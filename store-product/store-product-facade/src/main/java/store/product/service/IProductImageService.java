package store.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.product.pojo.vo.ProductImageVO;

import java.util.List;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
@FeignClient(name = "store-product-service/productImageService")
public interface IProductImageService {

    @PostMapping("/getProductImageVO")
    List<ProductImageVO> getProductImageVO(@RequestParam("productId") Long productId);
}
