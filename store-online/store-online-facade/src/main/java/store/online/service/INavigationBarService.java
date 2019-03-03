package store.online.service;

import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.online.entity.NavigationBar;

import java.util.List;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
public interface INavigationBarService {

    /**
     * 创建导航栏,更新导航中导航栏数量
     * @param navigationBar 导航栏信息
     * @param userName 操作人
     * @return
     */
    Integer insertNavigationBar(NavigationBar  navigationBar, String userName);

    /**
     * 根据导航ID查找显示导航栏
     * @param navigationId 导航ID
     * @return
     */
    List<NavigationBar> listByNavigationId(Long navigationId);

    /**
     * 根据导航ID/分页信息/搜索内容查找导航列表
     * @param navigationId 导航ID
     * @param pageInfo 分页信息
     * @param search 搜索内容
     * @return
     */
    BasePageDTO<NavigationBar> listByPage(Long navigationId, PageInfo pageInfo, String search);

    /**
     * 更新导航栏状态
     * @param navigationBarId 导航栏ID
     * @return
     */
    Integer updateStatus(Long navigationBarId);

    /**
     * 更新导航栏信息
     * @param navigationBar 导航栏信息
     * @param userName 操作人
     * @return
     */
    Integer updateNavigationBar(NavigationBar navigationBar, String userName);

    /**
     * 根据导航栏ID删除导航栏
     * @param navigationBarId 导航栏ID
     * @return
     */
    Integer deleteByNavigationBarId(Long navigationBarId);
}
