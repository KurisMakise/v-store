package store.online.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import store.common.annotation.RedisCache;
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
@RestController
@Api("导航栏")
@RequestMapping("/navigationBarService")
public class NavigationBarServiceImpl implements INavigationBarService {

    private final NavigationMapper navigationMapper;
    private final NavigationBarMapper navigationBarMapper;

    public NavigationBarServiceImpl(NavigationMapper navigationMapper, NavigationBarMapper navigationBarMapper) {
        this.navigationMapper = navigationMapper;
        this.navigationBarMapper = navigationBarMapper;
    }

    @Override
    @ApiOperation("插入导航")
    @PostMapping("/insertNavigationBar")
    public Integer insertNavigationBar(NavigationBar navigationBar, String userName) {
        return null;
    }

    @Override
//    @RedisCache(type = NavigationBar.class)
    @ApiOperation("导航列表")
    @PostMapping("/listByNavigationId")
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
    @ApiOperation("导航分类")
    @PostMapping("/listByPage")
    public BasePageDTO<NavigationBar> listByPage(Long navigationId, PageInfo pageInfo, String search) {
        return null;
    }

    @Override
    @ApiOperation("更新状态")
    @PostMapping("/updateStatus")
    public Integer updateStatus(Long navigationBarId) {
        return null;
    }

    @Override
    @ApiOperation("更新导航")
    @PostMapping("/updateNavigationBar")
    public Integer updateNavigationBar(NavigationBar navigationBar, String userName) {
        return null;
    }

    @Override
    @ApiOperation("删除导航")
    @PostMapping("/deleteByNavigationBarId")
    public Integer deleteByNavigationBarId(Long navigationBarId) {
        return null;
    }
}
