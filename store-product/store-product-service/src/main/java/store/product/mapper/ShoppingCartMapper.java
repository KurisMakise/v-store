package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.product.entity.ShoppingCart;
import store.product.pojo.vo.ShoppingCartVO;

import java.util.List;

public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

    List<ShoppingCartVO> list(long userId, int checkStatus);

    int deleteByPrimaryKey(Long cartId);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    ShoppingCart selectByPrimaryKey(Long cartId);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}