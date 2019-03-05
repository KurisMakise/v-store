package store.online.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.common.base.BasePageDTO;
import store.common.enums.StatusEnum;
import store.common.support.page.PageInfo;
import store.online.entity.Navigation;
import store.online.entity.NavigationBar;
import store.online.mapper.NavigationBarMapper;
import store.online.mapper.NavigationMapper;
import store.online.service.INavigationBarService;

import java.util.List;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
@Service
public class NavigationBarServiceImpl implements INavigationBarService {

    @Autowired
    private NavigationMapper navigationMapper;
    @Autowired
    private NavigationBarMapper navigationBarMapper;

    @Override
    public Integer insertNavigationBar(NavigationBar navigationBar, String userName) {
        return null;
    }

    @Override
    public List<NavigationBar> listByNavigationId(Long navigationId) {

        QueryWrapper<Navigation> navigationQueryWrapper = new QueryWrapper<>();
        navigationQueryWrapper
                .eq("navigation_id", navigationId)
                .eq("status", StatusEnum.SHOW.getStatus());

        Navigation navigation = navigationMapper.selectOne(navigationQueryWrapper);

        if (navigation != null) {
            QueryWrapper<NavigationBar> navigationBarQueryWrapper = new QueryWrapper<>();
            navigationBarQueryWrapper
                    .eq("navigation_id", navigationId)
                    .eq("status", StatusEnum.SHOW.getStatus())
                    .apply(false, " limit {0}", navigation.getShowNumber());
            return navigationBarMapper.selectList(navigationBarQueryWrapper);
        }
        return null;
    }

    @Override
    public BasePageDTO<NavigationBar> listByPage(Long navigationId, PageInfo pageInfo, String search) {
        return null;
    }

    @Override
    public Integer updateStatus(Long navigationBarId) {
        return null;
    }

    @Override
    public Integer updateNavigationBar(NavigationBar navigationBar, String userName) {
        return null;
    }

    @Override
    public Integer deleteByNavigationBarId(Long navigationBarId) {
        return null;
    }
}
