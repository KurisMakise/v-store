package store.product.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
@FeignClient("store-product-service/recommendService")
public interface IRecommendService {
}
