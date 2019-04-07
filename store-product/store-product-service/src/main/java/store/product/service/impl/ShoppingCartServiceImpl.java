package store.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.stereotype.Service;
import store.common.constant.CommonReturnCode;
import store.common.enums.StatusEnum;
import store.common.exception.ValidationException;
import store.product.entity.ProductSpecification;
import store.product.entity.ShoppingCart;
import store.product.mapper.ProductSpecificationMapper;
import store.product.mapper.ShoppingCartMapper;
import store.product.pojo.vo.CartVO;
import store.product.pojo.vo.ShoppingCartVO;
import store.product.service.IShoppingCartService;

import java.util.Date;
import java.util.List;

/**
 * creator violet
 * createTime 2019/3/21
 * description
 */
@Service
public class ShoppingCartServiceImpl implements IShoppingCartService {

    private final ShoppingCartMapper shoppingCartMapper;

    private final ProductSpecificationMapper productSpecificationMapper;

    public ShoppingCartServiceImpl(ShoppingCartMapper shoppingCartMapper, ProductSpecificationMapper productSpecificationMapper) {
        this.shoppingCartMapper = shoppingCartMapper;
        this.productSpecificationMapper = productSpecificationMapper;
    }

    @Override
    public Integer insertShoppingCart(Long productSpecNumber, Long userId) throws ValidationException {
        if (productSpecNumber == null)
            throw new ValidationException(CommonReturnCode.BAD_PARAM.getCode(), "productSpecNumber不存在");
        if (userId == null)
            throw new ValidationException(CommonReturnCode.UNAUTHORIZED);

        //检查商品是否存在
        QueryWrapper<ProductSpecification> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("product_spec_number", productSpecNumber);
        ProductSpecification productSpecification = productSpecificationMapper.selectOne(queryWrapper);
        if (productSpecification == null)
            throw new ValidationException(CommonReturnCode.BAD_PARAM.getCode(), "商品不存在");


        //判断购物车是否存在
        QueryWrapper<ShoppingCart> cartQueryWrapper = new QueryWrapper<>();
        cartQueryWrapper.eq("product_spec_number", productSpecNumber);
        ShoppingCart shoppingCart = shoppingCartMapper.selectOne(cartQueryWrapper);
        if (shoppingCart == null) {
            shoppingCart = new ShoppingCart();
            shoppingCart.setCreateTime(new Date());
            shoppingCart.setUserId(userId);
            shoppingCart.setProductSpecNumber(productSpecNumber);
            shoppingCart.setBuyNumber(1);
            shoppingCart.setUpdateTime(new Date());
            return shoppingCartMapper.insert(shoppingCart);
        } else {
            shoppingCart.setBuyNumber(shoppingCart.getBuyNumber() + 1);
            shoppingCart.setUpdateTime(new Date());
            return shoppingCartMapper.updateById(shoppingCart);
        }
    }

    @Override
    public ShoppingCartVO getCart(Long userId, Long productSpecNumber) {

        return shoppingCartMapper.getCart(userId, productSpecNumber);
    }

    @Override
    public CartVO list(Long userId, Integer checkStatus) throws ValidationException {
        if (userId == null)
            throw new ValidationException(CommonReturnCode.UNAUTHORIZED);
        //根据用户ID查询购物车列表
        List<ShoppingCartVO> shoppingCartVOS = shoppingCartMapper.list(userId, checkStatus);
        CartVO cartVO = new CartVO();
        cartVO.setShoppingCartVOs(shoppingCartVOS);
        return cartVO;
    }

    @Override
    public Integer updateBuyNumber(Long productSpecNumber, Long userId, Integer buyNumber) {
        ShoppingCart shoppingCart = checkShoppingCart(productSpecNumber, userId);

        if (shoppingCart != null) {
            shoppingCart.setBuyNumber(buyNumber);
            shoppingCart.setUpdateTime(new Date());
            return shoppingCartMapper.updateById(shoppingCart);
        }
        return null;
    }

    private ShoppingCart checkShoppingCart(long productSpecNumber, long userId) {
        //查询用户购物车是否存在
        QueryWrapper<ShoppingCart> shoppingCartQueryWrapper = new QueryWrapper<>();
        shoppingCartQueryWrapper.eq("product_spec_number", productSpecNumber);
        shoppingCartQueryWrapper.eq("user_id", userId);
        return shoppingCartMapper.selectOne(shoppingCartQueryWrapper);
    }

    @Override
    public Integer updateStatus(Long productSpecNumber, Long userId, Integer checkStatus) {
        //查询用户购物车是否存在
        ShoppingCart shoppingCart = checkShoppingCart(productSpecNumber, userId);

        if (shoppingCart != null) {
            shoppingCart.setCheckStatus(checkStatus.byteValue());
            shoppingCart.setUpdateTime(new Date());
            return shoppingCartMapper.updateById(shoppingCart);
        }
        return null;
    }

    @Override
    public Integer delete(Long productSpecNumber, Long userId) {
        return null;
    }

    @Override
    public Integer deleteCheckProduct(Long userId) {
        UpdateWrapper<ShoppingCart> shoppingCartWrapper = new UpdateWrapper<>();
        shoppingCartWrapper.eq("user_id", userId);
        shoppingCartWrapper.eq("check_status", StatusEnum.CHECKED.getStatus());
        return shoppingCartMapper.delete(shoppingCartWrapper);
    }
}
