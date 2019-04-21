package store.product.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import store.common.exception.ValidationException;
import store.product.entity.CommentReply;

/**
 * @author violet
 * @since 2019/2/27
 */
@FeignClient("store-product-service/commentReplyService")
public interface ICommentReplyService {

    @PostMapping("/replyComment")
    Integer replyComment(@RequestBody CommentReply commentReply,
                         @RequestParam("userId") Long userId) throws ValidationException;
}
