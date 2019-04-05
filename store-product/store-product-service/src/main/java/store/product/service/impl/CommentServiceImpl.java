package store.product.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
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
@Service
public class CommentServiceImpl implements ICommentService {

    private final CommentMapper commentMapper;

    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }


    @Override
    public Page<CommentVO> listTimeLine(Long productId, Integer status, Page<CommentVO> page) {
        List<CommentVO> commentVOS = commentMapper.listTimeLine(productId, status, page);
        page.setRecords(commentVOS);
        return page;
    }

    @Override
    public Page<CommentVO> listComment(Long productId, Integer status, Page<CommentVO> page) {
        List<CommentVO> commentVOS = commentMapper.listComment(productId, status, page);
        page.setRecords(commentVOS);
        return page;
    }
}
