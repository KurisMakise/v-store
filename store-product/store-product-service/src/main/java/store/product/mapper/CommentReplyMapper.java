package store.product.mapper;

import store.product.entity.CommentReply;

public interface CommentReplyMapper {
    int deleteByPrimaryKey(Long commentReplyId);

    int insertSelective(CommentReply record);

    CommentReply selectByPrimaryKey(Long commentReplyId);

    int updateByPrimaryKeySelective(CommentReply record);

    int updateByPrimaryKey(CommentReply record);
}