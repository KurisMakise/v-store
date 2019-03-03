package store.product.mapper;

import store.product.entity.ShoppingCart;

public interface ShoppingCartMapper {
    int deleteByPrimaryKey(Long cartId);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Long cartId);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}