package store.common.base;

import store.common.support.page.PageInfo;

import java.util.List;

/**
 * creator violet
 * createTime 2019/2/23
 * description
 */
public class BasePageDTO<T> {

    /**
     * 分页信息
     */
    private PageInfo pageInfo;

    /**
     * 分页实体表
     */
    private List<T> list;

    public BasePageDTO(PageInfo pageInfo, List<T> list) {
        this.pageInfo = pageInfo;
        this.list = list;
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
