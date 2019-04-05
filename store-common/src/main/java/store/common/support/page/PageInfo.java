package store.common.support.page;

import java.io.Serializable;

/**
 * creator violet
 * createTime 2019/2/27
 * description
 */
public class PageInfo implements Serializable {

    private static final long serialVersionUID = -6951670330693473121L;
    /**
     * 总记录
     */
    private long total;

    /**
     * 总页数
     */
    private long totalPage;

    /**
     * 偏移量，从第几条开始
     */
    private long offset;

    /**
     * 每页显示记录
     */
    private long limit;

    /**
     * 当前页面
     */
    private long current;

    /**
     * 排序字段
     */
    private String sort;

    /**
     * 排序类型 asc desc
     */
    private String order;

    public PageInfo(long limit, long current) {
        this.current = current < 1 ? 1 : current;
        this.limit = limit < 1 ? 1 : limit;
        this.offset = (this.current - 1) * this.limit;
    }

    public PageInfo(long limit, long current, String sort, String order) {
        this.current = current < 1 ? 1 : current;
        this.limit = limit < 1 ? 1 : limit;
        this.offset = (this.current - 1) * this.limit;
        this.sort = sort;
        this.order = order;
    }

    private void count() {
        long totalPageTmp = this.total / this.limit;
        long remain = this.total % this.limit == 0 ? 0 : 1;
        this.totalPage = totalPageTmp + remain;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total < 0 ? 0 : total;
        count();
    }

    public long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(long totalPage) {
        this.totalPage = totalPage;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset < 1 ? 1 : offset;
        current();
    }

    private void current() {
        this.current = this.offset / this.limit + 1;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit < 1 ? 1 : limit;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current < 0 ? 0 : current;
        this.offset = (this.current - 1) * this.limit;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
