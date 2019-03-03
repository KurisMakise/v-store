package store.online.service;

import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.online.entity.AdvertDetail;

import java.util.List;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
public interface IAdvertDetailService {
    Integer insertAdvertDetail(AdvertDetail advertDetail, String userName);

    /**
     * 根据广告位ID查找显示广告列表
     * param advertId 广告位ID
     * return
     */
    List<AdvertDetail> listByAdvertId(Long advertId);

    /**
     * 根据广告ID/分页信息/搜索内容查找导航列表
     * param advertId 广告ID
     * param pageInfo 分页信息
     * param search 搜索内容
     * return
     */
    BasePageDTO<AdvertDetail> listByPage(Long advertId, PageInfo pageInfo, String search);

    /**
     * 更新广告详情状态
     * param advertDetailId 广告详情ID
     * return
     */
    Integer updateStatus(Long advertDetailId);

    /**
     * 更新广告详情信息
     * param advertDetail 广告详情信息
     * param userName 操作人
     * return
     */
    Integer updateNavigationBar(AdvertDetail advertDetail, String userName);

    /**
     * 根据广告详情ID删除广告详情,同时更新广告位数量
     * param advertDetailId 广告详情ID
     * return
     */
    Integer deleteByadvertDetailId(Long advertDetailId);
}
