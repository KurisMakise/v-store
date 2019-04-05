package store.os.controller.question;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.common.base.BaseController;
import store.common.constant.CommonReturnCode;
import store.common.enums.OrderSortEnum;
import store.common.enums.StatusEnum;
import store.common.exception.ValidationException;
import store.os.common.result.OsResult;
import store.os.controller.common.util.SingletonLoginUtils;
import store.product.common.enums.QuestionSortTypeEnum;
import store.product.entity.Category;
import store.product.entity.Question;
import store.product.pojo.vo.ProductAttributeVO;
import store.product.pojo.vo.ProductVO;
import store.product.pojo.vo.QuestionVO;
import store.product.service.ICategoryService;
import store.product.service.IProductAttributeService;
import store.product.service.IProductService;
import store.product.service.IQuestionService;

import java.util.List;

/**
 * author  violet
 * createTime 2019/4/3 23:24
 * description
 * version 1.0
 */
@Api("商品提问")
@RequestMapping("/question")
@Controller
public class QuestionController extends BaseController {

    private final IQuestionService questionService;

    private final IProductService productService;

    private final ICategoryService categoryService;

    private final IProductAttributeService productAttributeService;


    public QuestionController(IQuestionService questionService, IProductService productService, ICategoryService categoryService, IProductAttributeService productAttributeService) {
        this.questionService = questionService;
        this.productService = productService;
        this.categoryService = categoryService;
        this.productAttributeService = productAttributeService;
    }

    @ApiOperation("提问列表")
    @GetMapping("/list")
    public String questionList(Model model, @RequestParam Long productId,
                               @RequestParam(name = "page", defaultValue = "1") Long current,
                               @RequestParam(name = "limit", defaultValue = "10") Long size,
                               @RequestParam(name = "sort", defaultValue = "0") Integer type) {

        Page<QuestionVO> questionVOPage = new Page<>(current, size);
        setOrder(questionVOPage, type);
        questionService.listQuestionVOS(productId, questionVOPage, StatusEnum.SHOW.getStatus());

        //商品详情
        ProductVO productVO = productService.getProductVOById(productId);
        //商品属性
        ProductAttributeVO productAttrVO = productAttributeService.getProductAttrVO(productId);
        //分类
        List<Category> upperCategories = categoryService.listUpperByProductId(productId, StatusEnum.SHOW.getStatus());

        model.addAttribute("questionVOPage", questionVOPage);
        model.addAttribute("totalPage", questionVOPage.getPages());
        model.addAttribute("productVO", productVO);
        model.addAttribute("productAttrVO", productAttrVO);
        model.addAttribute("upperCategories", upperCategories);
        model.addAttribute("sort", type);
        return "/modules/question/question_list";
    }

    private void setOrder(Page page, Integer type) {
        //判断排序字段升序还是降序
        QuestionSortTypeEnum sortTypeEnum = QuestionSortTypeEnum.typeOf(type);
        if (sortTypeEnum.getOrder().equals(OrderSortEnum.ASC.getOrder())) {
            page.setAsc(sortTypeEnum.getSort());
        } else if (sortTypeEnum.getOrder().equals(OrderSortEnum.DESC.getOrder())) {
            page.setDesc(sortTypeEnum.getSort());
        }
    }

    @ApiOperation("商品详情提问")
    @GetMapping("/productDetail")
    public String productDetailQuestion(Model model, @RequestParam Long productId,
                                        @RequestParam(defaultValue = "1", name = "page") Long current,
                                        @RequestParam(defaultValue = "0", name = "sort") Integer type,
                                        @RequestParam(defaultValue = "6", name = "limit") Long size) {

        Page<QuestionVO> questionPage = new Page<>(current, size);
        setOrder(questionPage, type);
        questionPage = questionService.listQuestionVOS(productId, questionPage, StatusEnum.SHOW.getStatus());
        model.addAttribute("questionPage", questionPage);
        return "/modules/question/product_detail_question";
    }

    @ApiOperation("创建商品提问")
    @PostMapping("/ask")
    @ResponseBody
    public Object create(Question question) {
        try {
            Integer count = questionService.insertQuestion(question, SingletonLoginUtils.getUserId());
            if (count > 0)
                return new OsResult(CommonReturnCode.SUCCESS, count);
        } catch (ValidationException e) {
            logger.error(e.getMessage(), e);
            return new OsResult(e.getCode(), e.getMessage());
        }
        return new OsResult(CommonReturnCode.UNKNOWN);
    }

    @ApiOperation("商品提问点赞")
    @PutMapping("/like")
    @ResponseBody
    public Object like(Question question) {
        try {
            Integer goodCount = questionService.likeQuestion(question, SingletonLoginUtils.getUserId());
            return new OsResult(CommonReturnCode.SUCCESS, goodCount);
        } catch (ValidationException e) {
            logger.error(e.getMessage(), e);
            return new OsResult(e.getCode(), e.getMessage());
        }
    }
}
