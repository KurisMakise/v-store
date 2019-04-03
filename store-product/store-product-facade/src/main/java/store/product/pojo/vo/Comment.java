package store.product.pojo.vo;

/**
 * author  violet
 * createTime 2019/4/2 15:37
 * description
 * version 1.0
 */
public class Comment {

    private Long commentId;

    private String content;

    private String userName;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
