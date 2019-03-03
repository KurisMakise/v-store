package store.online.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.online.entity.AdvertDetail;

public interface AdvertDetailMapper extends BaseMapper<AdvertDetail> {

    int deleteByPrimaryKey(Long advertDetailId);

    int insert(AdvertDetail record);

    int insertSelective(AdvertDetail record);

    AdvertDetail selectByPrimaryKey(Long advertDetailId);

    int updateByPrimaryKeySelective(AdvertDetail record);

    int updateByPrimaryKey(AdvertDetail record);
}