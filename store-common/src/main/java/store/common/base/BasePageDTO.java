package store.common.base;

import store.common.support.page.PageInfo;

import java.io.Serializable;
import java.util.List;

/**
 * creator violet
 * createTime 2019/2/23
 * description
 */
public class BasePageDTO<T> implements Serializable {

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

    @Override
    public int hashCode() {
        return pageInfo.getCurrent().hashCode() + pageInfo.getLimit().hashCode();
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }


}
