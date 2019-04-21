package store.online.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import store.common.base.BasePageDTO;
import store.common.support.page.PageInfo;
import store.online.entity.NavigationBar;

import java.util.List;

/**
 * @creator violet
 * @createTime 2019/2/27
 * @description
 */
@FeignClient(name = "STORE-ONLINE-SERVICE/navigationBarService")
public interface INavigationBarService {

    /**
     * 创建导航栏,更新导航中导航栏数量
     *
     * @param navigationBar 导航栏信息
     * @param userName      操作人
     * @return
     */
    @PostMapping("/insertNavigationBar")
    Integer insertNavigationBar(@RequestBody NavigationBar navigationBar,
                                @RequestParam("userName") String userName);

    /**
     * 根据导航ID查找显示导航栏
     *
     * @param navigationId 导航ID
     * @return
     */
    @PostMapping("/listByNavigationId")
    List<NavigationBar> listByNavigationId(@RequestParam("navigationId") Long navigationId);

    /**
     * 根据导航ID/分页信息/搜索内容查找导航列表
     *
     * @param navigationId 导航ID
     * @param pageInfo     分页信息
     * @param search       搜索内容
     * @return
     */
    @PostMapping("/listByPage")
    BasePageDTO<NavigationBar> listByPage(@RequestParam("navigationId") Long navigationId,
                                          @RequestBody PageInfo pageInfo,
                                          @RequestParam("search") String search);

    /**
     * 更新导航栏状态
     *
     * @param navigationBarId 导航栏ID
     * @return
     */
    @PostMapping("/updateStatus")
    Integer updateStatus(@RequestParam("navigationBarId") Long navigationBarId);

    /**
     * 更新导航栏信息
     *
     * @param navigationBar 导航栏信息
     * @param userName      操作人
     * @return
     */
    @PostMapping("/updateNavigationBar")
    Integer updateNavigationBar(@RequestBody NavigationBar navigationBar,
                                @RequestParam("userName") String userName);

    /**
     * 根据导航栏ID删除导航栏
     *
     * @param navigationBarId 导航栏ID
     * @return
     */
    @PostMapping("/deleteByNavigationBarId")
    Integer deleteByNavigationBarId(@RequestParam("navigationBarId") Long navigationBarId);
}
