package store.product.mapper;

import store.product.entity.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Long commentId);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Long commentId);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}