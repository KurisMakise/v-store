package store.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.product.entity.Category;
import store.product.pojo.vo.CategoryVO;

import java.util.List;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
@FeignClient("store-product-service/categoryService")
public interface ICategoryService {
    /**
     * 创建广告
     * param category 广告详情
     * param userName 操作人
     * return
     */
    @PostMapping("/insertAdvert")
    Integer insertAdvert(@RequestBody Category category,
                         @RequestParam("userName") String userName);

    /**
     * 根据商品显示数量/广告数量查找显示置顶分类列表
     * param showNumber 商品显示数量
     * param advertNumber 广告数量
     * return
     */
    @PostMapping("/listTop")
    List<CategoryVO> listTop(@RequestParam("showNumber") Integer showNumber,
                             @RequestParam("advertNumber") Integer advertNumber);

    /**
     * 根据商品显示数量/广告数量查找显示热门分类列表
     * param showNumber 商品显示数量
     * param advertNumber 广告数量
     * param type 评论类型
     * return
     */
    @PostMapping("/listHot")
    List<CategoryVO> listHot(@RequestParam("showNumber") Integer showNumber,
                             @RequestParam("advertNumber") Integer advertNumber,
                             @RequestParam("type") Integer type);

    /**
     * 根据商品显示数量/分类显示数量查找显示导航分类列表
     * param showNumber 商品显示数量
     * param navNumber 分类显示数量
     * return
     */
    @PostMapping("/listNav")
    List<CategoryVO> listNav(@RequestParam("showNumber") Integer showNumber,
                             @RequestParam("navNumber") Integer navNumber);

    /**
     * 根据类目ID查找当前类目信息
     * param categoryId 类目ID
     * param status 类目状态
     * return
     */
    @PostMapping("/getById")
    CategoryVO getById(@RequestParam("categoryId") Long categoryId,
                       @RequestParam("status") Integer status);

    /**
     * 根据类目ID查找子类目列表（如果沒有则返回当前目录列表）
     * param categoryId 类目ID
     * param status 子类目状态
     * return
     */
    @PostMapping("/listLowerCategories")
    List<CategoryVO> listLowerCategories(@RequestParam("categoryId") Long categoryId,
                                         @RequestParam("status") Integer status);

    /**
     * 根据类目ID查找父类目列表（如果沒有则返回当前目录列表）
     * param categoryId 类目ID
     * param status 父类目状态
     * return
     */
    @PostMapping("/listUpperCategories")
    List<CategoryVO> listUpperCategories(@RequestParam("categoryId") Long categoryId,
                                         @RequestParam("status") Integer status);

    /**
     * 根据商品ID查找父类目列表
     * param productId 商品ID
     * param status 父类目状态
     * return
     */
    @PostMapping("/listUpperByProductId")
    List<Category> listUpperByProductId(@RequestParam("productId") Long productId,
                                        @RequestParam("status") Integer status);

    /**
     * 根据分页信息/搜索内容查找一级分类列表
     * param pageInfo 分页信息
     * param search 搜索内容
     * param parentId 父类目ID
     * return
     */
    @PostMapping("/listParentByPage")
    BasePageDTO<Category> listParentByPage(@RequestBody PageInfo pageInfo,
                                           @RequestParam("search") String search,
                                           @RequestParam("parentId") Long parentId);

    /**
     * 更新类目状态
     * param categoryId 类目ID
     * return
     */
    @PostMapping("/updateStatus")
    Integer updateStatus(@RequestParam("categoryId") Long categoryId);

    /**
     * 更新类目
     * param category 类目信息
     * param userName 操作人
     *
     * @return
     */
    @PostMapping("/updateCategory")
    Integer updateCategory(@RequestBody Category category,
                           @RequestParam("userName") String userName);
}
