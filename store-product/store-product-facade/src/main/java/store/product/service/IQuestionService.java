package store.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import store.common.exception.ValidationException;
import store.product.entity.Question;
import store.product.pojo.vo.QuestionVO;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
public interface IQuestionService {
    Page<QuestionVO> listQuestionVOS(Long productId, Page<QuestionVO> page, Integer status);

    Integer insertQuestion(Question question, Long userId) throws ValidationException;

    Integer likeQuestion(Question question, Long userId) throws ValidationException;
}
