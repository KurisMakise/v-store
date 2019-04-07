package store.os.controller.product;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import store.common.enums.OrderSortEnum;
import store.common.enums.StatusEnum;
import store.product.common.enums.CategoryTypeEnum;
import store.product.common.enums.CommentTypeEnum;
import store.product.common.enums.ProductRecommendTypeEnum;
import store.product.common.enums.ProductSortTypeEnum;
import store.product.entity.Category;
import store.product.pojo.dto.ProductSpecificationDTO;
import store.product.pojo.vo.*;
import store.product.service.*;

import java.util.ArrayList;
import java.util.List;

/**
 * author  violet
 * createTime 2019/4/2 14:24
 * description 商品控制器
 * version 1.0
 */

@Controller
@Api(tags = {"商品"})
public class ProductController {

    private final IProductService productService;

    private final IProductImageService productImages;

    private final IProductSpecificationService productSpecificationService;

    private final IProductParameterService productParameterService;

    private final IProductAttributeService productAttributeService;

    private final ICategoryService categoryService;

    public ProductController(IProductService productService, IProductImageService productImages, IProductSpecificationService productSpecificationService, IProductParameterService productParameterService, IProductAttributeService productAttributeService, ICategoryService categoryService) {
        this.productService = productService;
        this.productImages = productImages;
        this.productSpecificationService = productSpecificationService;
        this.productParameterService = productParameterService;
        this.productAttributeService = productAttributeService;
        this.categoryService = categoryService;
    }

    @ApiOperation("商品详情")
    @GetMapping("/detail/{productId}")
    public String item(Model model, @PathVariable Long productId) {

        //商品详情
        ProductVO productVO = productService.getProductVOById(productId);
        if (productVO != null) {
            //页面展示图片
            List<ProductImageVO> productImageVO = productImages.getProductImageVO(productVO.getProductId());

            //商品参数
            List<ProductParameterVO> productParameterVOS = productParameterService.listProductParameterVO(productVO.getProductId(), StatusEnum.SHOW.getStatus());

            //规格参数
            ProductSpecificationDTO productSpecificationDTO = productSpecificationService.listProductSpec(productVO.getProductId(), StatusEnum.SHELVE.getStatus());

            //商品属性
            ProductAttributeVO productAttrVO = productAttributeService.getProductAttrVO(productVO.getProductId());

            //产品分类
            List<Category> upperCategories = categoryService.listUpperByProductId(productVO.getProductId(), StatusEnum.SHOW.getStatus());

            //评论

            //提问
            model.addAttribute("productParameterVOS", productParameterVOS);
            model.addAttribute("productImageVOS", productImageVO);
            model.addAttribute("productVO", productVO);
            model.addAttribute("productSpecVOS", JSON.toJSON(productSpecificationDTO.getProductSpecificationVOS()));
            model.addAttribute("specificationVOS", productSpecificationDTO.getSpecificationVOS());
            model.addAttribute("productAttrVO", productAttrVO);
            model.addAttribute("upperCategories", upperCategories);
        }
        return "/modules/product/product_detail";
    }

    @ApiOperation("商品列表")
    @GetMapping("/list")
    public String list(Model model,
                       @RequestParam(defaultValue = "1") Long page,
                       @RequestParam(defaultValue = "20") Long limit,
                       @RequestParam(required = false) String search,
                       @RequestParam(defaultValue = "1") Long categoryId,
                       @RequestParam(defaultValue = "0") Integer sort) {

        CategoryVO category = categoryService.getById(categoryId, StatusEnum.SHOW.getStatus());

        if (category != null) {
            //导航目录
            List<CategoryVO> upperCategories = categoryService.listUpperCategories(categoryId, StatusEnum.SHOW.getStatus());

            //商品分类
            List<CategoryVO> lowerCategories = categoryService.listLowerCategories(categoryId, StatusEnum.SHOW.getStatus());

            //商品
            Page<ProductVO> productVOPage = new Page<>(page, limit);
            setOrder(productVOPage, sort);
            List<Long> categoryIds = getLowerCategory(lowerCategories);
            categoryIds.add(categoryId);
            productService.listProductVO(categoryIds, StatusEnum.SHELVE.getStatus(), search, productVOPage);

            model.addAttribute("upperCategories", upperCategories);
            model.addAttribute("lowerCategories", lowerCategories);
            model.addAttribute("productVOPage", productVOPage);
            model.addAttribute("sort", sort);
            model.addAttribute("search", search);
            model.addAttribute("totalPage", productVOPage.getPages());
            model.addAttribute("category", category);
        }
        return "/modules/product/product_list";
    }

    private List<Long> getLowerCategory(List<CategoryVO> categories) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (CategoryVO category : categories) {
            arrayList.add(category.getCategoryId());
        }
        return arrayList;
    }

    private void setOrder(Page page, Integer order) {
        ProductSortTypeEnum typeEnum = ProductSortTypeEnum.typeOf(order);
        if (typeEnum.getOrder().equals(OrderSortEnum.ASC.getOrder())) {
            page.setAsc(typeEnum.getSort());
        } else if (typeEnum.getOrder().equals(OrderSortEnum.DESC.getOrder())) {
            page.setDesc(typeEnum.getSort());
        }
    }
}
