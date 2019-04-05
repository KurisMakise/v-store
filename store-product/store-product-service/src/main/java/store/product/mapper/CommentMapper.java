package store.product.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import store.product.pojo.vo.CommentVO;

import java.util.List;

public interface CommentMapper {

    List<CommentVO> listTimeLine(Long productId, Integer status, Page<CommentVO> page);

    List<CommentVO> listComment(Long productId, Integer status, Page<CommentVO> page);
}