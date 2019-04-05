package store.product.service;

import store.common.exception.ValidationException;
import store.product.entity.CommentReply;

/**
 * @author violet
 * @since 2019/2/27
 */
public interface ICommentReplyService {
    Integer replyComment(CommentReply commentReply, Long userId) throws ValidationException;
}
