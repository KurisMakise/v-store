package store.product.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.common.constant.CommonReturnCode;
import store.common.enums.StatusEnum;
import store.common.exception.ValidationException;
import store.product.entity.Question;
import store.product.mapper.ProductMapper;
import store.product.mapper.QuestionMapper;
import store.product.pojo.vo.ProductVO;
import store.product.pojo.vo.QuestionVO;
import store.product.service.IQuestionService;
import store.user.common.util.UserUtils;
import store.user.mapper.UserMapper;
import store.user.pojo.vo.UserVO;

import java.util.Date;
import java.util.List;

/**
 * @author violet
 * @version 1.0
 */
@RestController
@Api(tags = {"提问服务"})
@RequestMapping("/questionService")
public class QuestionServiceImpl implements IQuestionService {

    private final QuestionMapper questionMapper;

    private final UserMapper userMapper;

    private final ProductMapper productMapper;

    public QuestionServiceImpl(QuestionMapper questionMapper, UserMapper userMapper, ProductMapper productMapper) {
        this.questionMapper = questionMapper;
        this.userMapper = userMapper;
        this.productMapper = productMapper;
    }


    @Override
    @ApiOperation("提问列表")
    @PostMapping("/listQuestionVOS")
    public Page<QuestionVO> listQuestionVOS(Long productId, Page<QuestionVO> page, Integer status) {
        List<QuestionVO> questionVOS = questionMapper.listQuestionVOS(productId, status, page);
        page.setRecords(questionVOS);
        return page;
    }

    @Override
    @ApiOperation("新增提问")
    @PostMapping("/insertQuestion")
    public Integer insertQuestion(Question question, Long userId) throws ValidationException {

        if (question == null || question.getProductId() == null) {
            throw new ValidationException(CommonReturnCode.BAD_PARAM);
        }
        ProductVO productVO = productMapper.getProductVOById(question.getProductId());
        if (productVO == null) {
            throw new ValidationException(CommonReturnCode.BAD_PARAM.getCode(), "商品不存在");
        }
        if (userId == null) {
            throw new ValidationException(CommonReturnCode.UNAUTHORIZED);
        }
        UserVO userVO = userMapper.getUserVOById(userId);
        if (userVO == null) {
            throw new ValidationException(CommonReturnCode.INTERNAL_SERVER_ERROR);
        }

        question.setCreateBy(userVO.getUserName());
        question.setCreateTime(new Date());
        question.setUserId(userId);
        question.setUserName(userVO.getUserName());
        question.setUpdateBy(userVO.getUserName());
        question.setUpdateTime(new Date());
        question.setStatus(StatusEnum.SHOW.getStatus().byteValue());
        question.setPicImg(UserUtils.getPicImg());
        return questionMapper.insert(question);
    }

    @Override
    @ApiOperation("点赞提问")
    @PostMapping("/likeQuestion")
    public Integer likeQuestion(Question question, Long userId) throws ValidationException {
        if (userId == null) {
            throw new ValidationException(CommonReturnCode.UNAUTHORIZED);
        }
        if (question == null || question.getQuestionId() == null) {
            throw new ValidationException(CommonReturnCode.BAD_PARAM);
        }
        //TODO 增加一个用户商品点赞表,记录用户点赞记录
        int goodCount = question.getGoodCount() == null ? 0 : question.getGoodCount() + 1;
        question.setGoodCount(goodCount);
        questionMapper.updateById(question);
        return goodCount;
    }
}
