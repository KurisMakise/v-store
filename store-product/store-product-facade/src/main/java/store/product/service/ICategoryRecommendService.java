package store.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import store.product.pojo.vo.CategoryVO;

import java.util.List;

/**
 * @creator violet
 * @createTime 2019/3/13
 * @description
 */
@FeignClient(name = "store-product-service")
public interface ICategoryRecommendService {

    @PostMapping("/listTop")
    List<CategoryVO> listTop(@RequestParam("showNumber") int showNumber,
                             @RequestParam("advertNumber") int advertNumber);

    @PostMapping("/listHot")
    List<CategoryVO> listHot(@RequestParam("showNumber") int showNumber,
                             @RequestParam("advertNumber") int advertNumber,
                             @RequestParam("type") int type);

}
