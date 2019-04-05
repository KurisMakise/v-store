package store.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import store.common.exception.ValidationException;
import store.product.entity.CommentReply;
import store.product.pojo.vo.CommentVO;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
public interface ICommentService {

    Page<CommentVO> listTimeLine(Long productId, Integer status, Page<CommentVO> page);

    Page<CommentVO> listComment(Long productId, Integer status, Page<CommentVO> page);
}
