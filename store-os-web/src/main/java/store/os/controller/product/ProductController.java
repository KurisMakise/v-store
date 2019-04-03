package store.os.controller.product;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import store.common.enums.StatusEnum;
import store.product.entity.Category;
import store.product.pojo.dto.ProductSpecificationDTO;
import store.product.pojo.vo.*;
import store.product.service.*;

import java.util.List;

/**
 * author  violet
 * createTime 2019/4/2 14:24
 * description 商品控制器
 * version 1.0
 */

@Controller
@Api("商品")
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
    @GetMapping("/detail/{productNumber}")
    public String item(Model model, @PathVariable Long productNumber) {

        //商品详情
        ProductVO productVO = productService.getProductVO(productNumber);
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
}
