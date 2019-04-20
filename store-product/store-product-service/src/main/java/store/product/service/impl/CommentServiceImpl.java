package store.product.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.product.mapper.CommentMapper;
import store.product.pojo.vo.CommentVO;
import store.product.service.ICommentService;

import java.util.List;

/**
 * author  violet
 * createTime 2019/4/3 17:58
 * description
 * version 1.0
 */
@RestController
@Api(tags = {"评论服务"})
@RequestMapping("/commentService")
public class CommentServiceImpl implements ICommentService {

    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }


    @Override
    @ApiOperation("最新评论")
    @GetMapping("/listTimeLine")
    public Page<CommentVO> listTimeLine(Long productId, Integer status, Page<CommentVO> page) {
        List<CommentVO> commentVOS = commentMapper.listTimeLine(productId, status, page);
        page.setRecords(commentVOS);
        return page;
    }

    @Override
    @ApiOperation("评论列表")
    @GetMapping("/listComment")
    public Page<CommentVO> listComment(Long productId, Integer status, Page<CommentVO> page) {
        List<CommentVO> commentVOS = commentMapper.listComment(productId, status, page);
        page.setRecords(commentVOS);
        return page;
    }
}
