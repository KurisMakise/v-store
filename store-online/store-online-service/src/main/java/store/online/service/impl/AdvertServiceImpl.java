package store.online.service.impl;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.online.service.IAdvertService;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
@RestController
@Api(tags = {"广告服务"})
@RequestMapping("/advertService")
public class AdvertServiceImpl implements IAdvertService {

}
