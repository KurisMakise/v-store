package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.product.entity.ProductCategory;
import store.product.pojo.vo.ProductVO;

import java.util.List;

public interface ProductCategoryMapper extends BaseMapper<ProductCategory> {
    /**
     *
     * @param categoryIds 分类ID
     * @param showInShelve 状态
     * @param showInTop 是否置顶
     * @param showNumber 显示数量
     */
    List<ProductVO> listTopProductByCategoryId(List<Long> categoryIds,int showInShelve,int showInTop,int showNumber);


    List<ProductVO> listNavByCategoryId(List<Long> categoryIds, int status,int showInNav,int showNumber);

    ProductCategory selectByPrimaryKey(Long productCategoryId);

    int updateByPrimaryKeySelective(ProductCategory record);

    int updateByPrimaryKey(ProductCategory record);
}