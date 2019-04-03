package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import store.product.entity.Category;
import store.product.pojo.vo.CategoryVO;

import java.util.Date;
import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    Category getCategory(Long productId, Integer status);

    /**
     * @param status       状态
     * @param type         分类类型
     * @param showInTop    是否置顶
     * @param advertNumber 广告数量
     * @param advertDate   广告时间
     * @return 分类列表
     */
    List<CategoryVO> listTopCategoryAdvert(int status, int type, int showInTop, int advertNumber, Date advertDate);

    /**
     * @param categoryId 分类id
     * @param status     状态
     * @return 子分类id
     */
    List<Long> listSubCategoryIds(long categoryId, @Param("status") int status);


}