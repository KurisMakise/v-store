package store.product.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import store.common.exception.ValidationException;
import store.product.entity.CommentReply;
import store.product.pojo.vo.CommentVO;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
@FeignClient("store-product-service/commentService")
public interface ICommentService {

    @PostMapping("/listTimeLine")
    Page<CommentVO> listTimeLine(@RequestParam("productId") Long productId,
                                 @RequestParam("status") Integer status,
                                 Page<CommentVO> page);

    @PostMapping("/listComment")
    Page<CommentVO> listComment(@RequestParam("productId") Long productId,
                                @RequestParam("status") Integer status,
                                @RequestBody Page<CommentVO> page);
}
