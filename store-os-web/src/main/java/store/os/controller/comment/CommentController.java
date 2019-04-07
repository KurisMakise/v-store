package store.os.controller.comment;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import store.common.constant.CommonReturnCode;
import store.common.enums.OrderSortEnum;
import store.common.enums.StatusEnum;
import store.common.exception.ValidationException;
import store.os.common.result.OsResult;
import store.os.controller.common.util.SingletonLoginUtils;
import store.product.common.enums.CommentSortTypeEnum;
import store.product.entity.Category;
import store.product.entity.CommentReply;
import store.product.pojo.vo.CommentVO;
import store.product.pojo.vo.ProductAttributeVO;
import store.product.pojo.vo.ProductVO;
import store.product.service.*;

import java.util.List;

/**
 * @author violet
 * @version 1.0
 * @since 2019/4/3 17:53
 * description 评论控制器
 */

@Api(tags = {"商品评论"})
@Controller
@RequestMapping("/comment")

//TODO 将评论分页查询改为两次，一次查评论，一次查回复
public class CommentController {
    private final ICommentService commentService;

    private final ICommentReplyService commentReplyService;

    private final ICategoryService categoryService;

    private final IProductAttributeService productAttributeService;

    private final IProductService productService;

    public CommentController(ICommentService commentService, ICategoryService categoryService, IProductAttributeService productAttributeService, IProductService productService, ICommentReplyService commentReplyService) {
        this.commentService = commentService;
        this.categoryService = categoryService;
        this.productAttributeService = productAttributeService;
        this.productService = productService;
        this.commentReplyService = commentReplyService;
    }


    @ApiOperation("最新评论")
    @GetMapping("/timeLine")
    public String commentTimeLineList(Model model, @RequestParam Long productId,
                                      @RequestParam(name = "sort", defaultValue = "0") Integer type,
                                      @RequestParam(name = "page", defaultValue = "1") Long current,
                                      @RequestParam(name = "limit", defaultValue = "6") Long size) {

        Page<CommentVO> commentVOPage = new Page<>(current, size);
        //排序
        setOrder(commentVOPage, type);
        commentVOPage = commentService.listTimeLine(productId, StatusEnum.SHOW.getStatus(), commentVOPage);
        model.addAttribute("commentVOPage", commentVOPage);
        return "/modules/comment/time_line_comment";
    }

    @ApiOperation("评论列表")
    @GetMapping("/list")
    public String commentList(Model model, @RequestParam Long productId,
                              @RequestParam(name = "page", defaultValue = "1") Long current,
                              @RequestParam(name = "limit", defaultValue = "10") Long size,
                              @RequestParam(name = "sort", defaultValue = "0") Integer type) {
        List<Category> upperCategories = categoryService.listUpperByProductId(productId, StatusEnum.SHOW.getStatus());

        //评论
        Page<CommentVO> commentVOPage = new Page<>(current, size);
        setOrder(commentVOPage, type);
        commentService.listComment(productId, StatusEnum.SHOW.getStatus(), commentVOPage);

        //商品详情
        ProductVO productVO = productService.getProductVOById(productId);
        //商品属性
        ProductAttributeVO productAttrVO = productAttributeService.getProductAttrVO(productId);

        model.addAttribute("commentVOPage", commentVOPage);
        model.addAttribute("upperCategories", upperCategories);
        model.addAttribute("productVO", productVO);
        model.addAttribute("productAttrVO", productAttrVO);
        model.addAttribute("sort", type);
        model.addAttribute("totalPage", commentVOPage.getPages());

        return "/modules/comment/comment_list";
    }

    private void setOrder(Page page, Integer type) {
        CommentSortTypeEnum typeEnum = CommentSortTypeEnum.typeOf(type);
        //判断升序还是降序
        //TODO 排序字段两张表同名,1修改字段名,2加上前缀
        if (typeEnum.getOrder().equals(OrderSortEnum.ASC.getOrder())) {
            page.setAsc("c." + typeEnum.getSort());
        } else if (typeEnum.getOrder().equals(OrderSortEnum.DESC.getOrder())) {
            page.setDesc("c." + typeEnum.getSort());
        }
    }

    @ApiOperation("评论列表")
    @GetMapping("/sup")
    public String commentSup(Model model, @RequestParam Long productId,
                             @RequestParam(name = "page", defaultValue = "1") Long current,
                             @RequestParam(name = "limit", defaultValue = "8") Long size,
                             @RequestParam(name = "sort", defaultValue = "0") Integer type) {
        Page<CommentVO> commentVOPage = new Page<>(current, size);
        //排序
        setOrder(commentVOPage, type);
        commentService.listComment(productId, StatusEnum.SHOW.getStatus(), commentVOPage);

        model.addAttribute("commentVOPage", commentVOPage);
        return "/modules/comment/sup_comment";
    }

    @ApiOperation("评论回复")
    @PostMapping("/reply")
    @ResponseBody
    public Object reply(CommentReply commentReply) {
        try {
            Integer count = commentReplyService.replyComment(commentReply, SingletonLoginUtils.getUserId());
            if (count > 0)
                return new OsResult(CommonReturnCode.SUCCESS);
        } catch (ValidationException e) {
            return new OsResult(e.getCode(), e.getMessage());
        }
        return new OsResult(CommonReturnCode.UNKNOWN);
    }
}
