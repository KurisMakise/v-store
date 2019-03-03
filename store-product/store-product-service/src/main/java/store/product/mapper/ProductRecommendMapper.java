package store.product.mapper;

import store.product.entity.ProductRecommend;

public interface ProductRecommendMapper {
    int deleteByPrimaryKey(Long recommendProductId);

    int insert(ProductRecommend record);

    int insertSelective(ProductRecommend record);

    ProductRecommend selectByPrimaryKey(Long recommendProductId);

    int updateByPrimaryKeySelective(ProductRecommend record);

    int updateByPrimaryKey(ProductRecommend record);
}