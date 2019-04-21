package store.online.service;

import org.springframework.cloud.openfeign.FeignClient;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
@FeignClient("store-online-service/navigationService")
public interface INavigationService {
}
