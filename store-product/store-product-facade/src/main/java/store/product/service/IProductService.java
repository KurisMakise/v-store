package store.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import store.product.pojo.vo.ProductVO;

import java.util.List;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
@FeignClient("store-product-service/productService")
public interface IProductService {

    @PostMapping("/getProductVO")
    ProductVO getProductVO(@RequestParam("productNumber") Long productNumber);

    @PostMapping("/getProductVOById")
    ProductVO getProductVOById(@RequestParam("productId") Long productId);

    @PostMapping("/listProductVO")
    void listProductVO(@RequestBody List<Long> categoryIds,
                       @RequestParam("showInShelve") Integer showInShelve,
                       @RequestParam("search") String search,
                       @RequestParam("page") Page<ProductVO> page);
}
