package store.product.pojo.vo;

/**
 * author  violet
 * createTime 2019/4/2 23:21
 * description
 * version 1.0
 */
public class ProductAttributeVO {

    /**
     * 评论数
     */
    private String commentNumber;

    /**
     * 满意度
     */
    private String commentAverage;

    /**
     * 提问数
     */
    private String questionNumber;

    public String getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(String commentNumber) {
        this.commentNumber = commentNumber;
    }

    public String getCommentAverage() {
        return commentAverage;
    }

    public void setCommentAverage(String commentAverage) {
        this.commentAverage = commentAverage;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }
}

