package store.product.service.impl;

import org.springframework.stereotype.Service;
import store.common.constant.CommonReturnCode;
import store.common.exception.ValidationException;
import store.product.entity.CommentReply;
import store.product.mapper.CommentReplyMapper;
import store.product.service.ICommentReplyService;
import store.user.mapper.UserMapper;
import store.user.pojo.vo.UserVO;

import java.util.Date;

/**
 * <p>
 * 评论回复服务
 * </p>
 *
 * @author violet
 * @version 1.0
 * @since 2019/4/4 23:00
 */
@Service
public class CommentReplyServiceImpl implements ICommentReplyService {

    private final CommentReplyMapper commentReplyMapper;

    private final UserMapper userMapper;

    public CommentReplyServiceImpl(CommentReplyMapper commentReplyMapper, UserMapper userMapper) {
        this.commentReplyMapper = commentReplyMapper;
        this.userMapper = userMapper;
    }

    @Override
    public Integer replyComment(CommentReply commentReply, Long userId) throws ValidationException {
        UserVO userVO = userMapper.getUserVOById(userId);
        if (userVO == null) {
            throw new ValidationException(CommonReturnCode.BAD_PARAM.getCode(), "用户不存在");
        }
        if (commentReply == null) {
            throw new ValidationException(CommonReturnCode.BAD_PARAM);
        }
        if (userId == null) {
            throw new ValidationException(CommonReturnCode.UNAUTHORIZED);
        }

        commentReply.setUserId(userId);
        commentReply.setUserName(userVO.getUserName());
        commentReply.setPicImg(userVO.getPicImg());
        commentReply.setCreateTime(new Date());
        commentReply.setCreateBy(userVO.getUserName());
        commentReply.setUpdateTime(new Date());
        commentReply.setUpdateBy(userVO.getUserName());
        return commentReplyMapper.insert(commentReply);
    }
}
