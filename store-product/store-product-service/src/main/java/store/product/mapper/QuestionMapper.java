package store.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import store.product.entity.Question;
import store.product.pojo.vo.QuestionVO;

import java.util.List;

public interface QuestionMapper extends BaseMapper<Question> {

    List<QuestionVO> listQuestionVOS(Long productId, Integer status, Page page);


}