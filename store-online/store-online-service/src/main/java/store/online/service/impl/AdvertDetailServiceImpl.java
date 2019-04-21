package store.online.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.common.base.BasePageDTO;
import store.common.enums.StatusEnum;
import store.common.support.page.PageInfo;
import store.online.entity.Advert;
import store.online.entity.AdvertDetail;
import store.online.mapper.AdvertDetailMapper;
import store.online.mapper.AdvertMapper;
import store.online.service.IAdvertDetailService;

import java.util.Date;
import java.util.List;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */

@RestController
@Api(tags = {"广告详情"})
@RequestMapping("/advertDetailService")
public class AdvertDetailServiceImpl implements IAdvertDetailService {
    private final AdvertMapper advertMapper;

    private final AdvertDetailMapper advertDetailMapper;

    public AdvertDetailServiceImpl(AdvertMapper advertMapper, AdvertDetailMapper advertDetailMapper) {
        this.advertMapper = advertMapper;
        this.advertDetailMapper = advertDetailMapper;
    }

    @Override
    @ApiOperation("插入广告")
    @PostMapping("/insertAdvertDetail")
    public Integer insertAdvertDetail(AdvertDetail advertDetail, String userName) {
        return null;
    }

    @Override
    @ApiOperation("广告列表")
    @PostMapping("/listByAdvertId")
    public List<AdvertDetail> listByAdvertId(Long advertId) {
        QueryWrapper<Advert> advertQueryWrapper = new QueryWrapper<>();

        advertQueryWrapper
                .eq("advert_id", advertId)
                .eq("status", StatusEnum.SHOW.getStatus());
        Advert advert = advertMapper.selectOne(advertQueryWrapper);

        if (advert != null) {
            QueryWrapper<AdvertDetail> advertDetailQueryWrapper = new QueryWrapper<>();
            Date date = new Date();
            advertDetailQueryWrapper
                    .eq("advert_id", advertId)
                    .eq("status", StatusEnum.SHOW.getStatus())
                    .gt("begin_time", date)
                    .lt("end_time", date)
                    .apply(false, " limit", advert.getDefultNumber());
            return advertDetailMapper.selectList(advertDetailQueryWrapper);
        }
        return null;
    }

    @Override
    @ApiOperation("分页查询")
    @PostMapping("/listByPage")
    public BasePageDTO<AdvertDetail> listByPage(Long advertId, PageInfo pageInfo, String search) {
        return null;
    }

    @Override
    @ApiOperation("更新状态")
    @PostMapping("/updateStatus")
    public Integer updateStatus(Long advertDetailId) {
        return null;
    }

    @Override
    @ApiOperation("更新导航")
    @PostMapping("/updateNavigationBar")
    public Integer updateNavigationBar(AdvertDetail advertDetail, String userName) {
        return null;
    }

    @Override
    @ApiOperation("删除广告")
    @PostMapping("/deleteByAdvertDetailId")
    public Integer deleteByAdvertDetailId(Long advertDetailId) {
        return null;
    }
}
