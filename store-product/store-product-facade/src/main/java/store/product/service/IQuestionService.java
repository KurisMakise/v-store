package store.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import store.common.exception.ValidationException;
import store.product.entity.Question;
import store.product.pojo.vo.QuestionVO;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */

@FeignClient("store-product-service/questionService")
public interface IQuestionService {
    @PostMapping("/listQuestionVOS")
    Page<QuestionVO> listQuestionVOS(@RequestParam("productId") Long productId,
                                     @RequestBody Page<QuestionVO> page,
                                     @RequestParam("status") Integer status);

    @PostMapping("/insertQuestion")
    Integer insertQuestion(@RequestBody Question question,
                           @RequestParam("userId") Long userId) throws ValidationException;

    @PostMapping("/likeQuestion")
    Integer likeQuestion(@RequestBody Question question,
                         @RequestParam("userId") Long userId) throws ValidationException;
}
