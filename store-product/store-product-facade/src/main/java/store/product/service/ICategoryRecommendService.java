package store.product.service;

import store.product.pojo.vo.CategoryVO;

import java.util.List;

/**
 * @creator violet
 * @createTime 2019/3/13
 * @description
 */
public interface ICategoryRecommendService {

    List<CategoryVO> listTop(int showNumber, int advertNumber);

    List<CategoryVO> listHot(int showNumber, int advertNumber, int type);

}
