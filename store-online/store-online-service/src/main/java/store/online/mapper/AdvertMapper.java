package store.online.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import store.online.entity.Advert;

public interface AdvertMapper extends BaseMapper<Advert> {
    int deleteByPrimaryKey(Long advertId);

    int insert(Advert record);

    int insertSelective(Advert record);

    Advert selectByPrimaryKey(Long advertId);

    int updateByPrimaryKeySelective(Advert record);

    int updateByPrimaryKeyWithBLOBs(Advert record);

    int updateByPrimaryKey(Advert record);
}
