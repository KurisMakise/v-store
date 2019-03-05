package store.online.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */

@Service
public class AdvertDetailServiceImpl implements IAdvertDetailService {
    @Autowired
    private AdvertMapper advertMapper;

    @Autowired
    private AdvertDetailMapper advertDetailMapper;

    @Override
    public Integer insertAdvertDetail(AdvertDetail advertDetail, String userName) {
        return null;
    }

    @Override
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
//                    .gt("begin_time", date)
//                    .lt("end_time", date)
                    .apply(false, " limit", advert.getDefultNumber());
            return advertDetailMapper.selectList(advertDetailQueryWrapper);
        }
        return null;
    }

    @Override
    public BasePageDTO<AdvertDetail> listByPage(Long advertId, PageInfo pageInfo, String search) {
        return null;
    }

    @Override
    public Integer updateStatus(Long advertDetailId) {
        return null;
    }

    @Override
    public Integer updateNavigationBar(AdvertDetail advertDetail, String userName) {
        return null;
    }

    @Override
    public Integer deleteByadvertDetailId(Long advertDetailId) {
        return null;
    }
}
