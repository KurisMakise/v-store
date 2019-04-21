package store.product.service.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.product.mapper.ProductParameterMapper;
import store.product.pojo.vo.ProductParameterVO;
import store.product.service.IProductParameterService;

import java.util.List;

/**
 * author  violet
 * createTime 2019/4/2 18:31
 * description 商品参数
 * version 1.0
 */
@RestController
@Api(tags = {"商品参数"})
@RequestMapping("/productParameter")
public class ProductParameterImpl implements IProductParameterService {
    private final ProductParameterMapper productParameterMapper;

    public ProductParameterImpl(ProductParameterMapper productParameterMapper) {
        this.productParameterMapper = productParameterMapper;
    }

    @Override
    @ApiOperation("商品参数列表")
    @PostMapping("/listProductParameterVO")
    public List<ProductParameterVO> listProductParameterVO(Long productId, Integer status) {
        return productParameterMapper.listProductParameterVO(productId, status);
    }
}
