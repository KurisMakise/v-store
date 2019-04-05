package store.product.pojo.vo;

import java.util.Date;
import java.util.List;

/**
 * author  violet
 * createTime 2019/4/3 18:00
 * description
 * version 1.0
 */
public class CommentVO {

    //评论ID
    private Long commentId;

    //创建时间
    private Date createTime;

    //用户名
    private String userName;

    //评论内存
    private String content;

    //点赞数
    private Integer goodCount;

    private String picImg;

    private List<CommentReplyVO> replyComments;

    public String getPicImg() {
        return picImg;
    }

    public void setPicImg(String picImg) {
        this.picImg = picImg;
    }

    public List<CommentReplyVO> getReplyComments() {
        return replyComments;
    }

    public void setReplyComments(List<CommentReplyVO> replyComments) {
        this.replyComments = replyComments;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(Integer goodCount) {
        this.goodCount = goodCount;
    }
}
