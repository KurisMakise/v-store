package store.product.mapper;

import store.product.entity.Question;

public interface QuestionMapper {
    int deleteByPrimaryKey(Long questionId);

    int insertSelective(Question record);

    Question selectByPrimaryKey(Long questionId);

    int updateByPrimaryKeySelective(Question record);

    int updateByPrimaryKey(Question record);
}