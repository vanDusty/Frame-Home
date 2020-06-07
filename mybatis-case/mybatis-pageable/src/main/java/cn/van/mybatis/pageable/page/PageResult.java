package cn.van.mybatis.pageable.page;

import java.io.Serializable;
import java.util.List;
/**
 * Copyright (C), 2015-2019, 风尘博客
 * 公众号 : 风尘博客
 * FileName: PageResult
 *
 * @author: Van
 * Date:     2019-06-28 20:05
 * Description: 分页结果集
 * Version： V1.0
 */
public class PageResult<T> implements Serializable {
    /**
     * 是否为第一页
     */
    private Boolean isFirstPage = false;
    /**
     * 是否为最后一页
     */
    private Boolean isLastPage = false;
    /**
     * 当前页
     */
    private Integer pageNum;
    /**
     * 每页的数量
     */
    private Integer pageSize;
    /**
     * 总记录数
     */
    private Integer totalSize;
    /**
     * 总页数
     */
    private Integer totalPage;
    /**
     * 结果集
     */
    private List<T> data;

    public PageResult() {
    }

    public PageResult(List<T> data) {
        this.data = data;
        PageInterceptor.PageParam pageParam = PageInterceptor.PARAM_THREAD_LOCAL.get();
        if (pageParam != null) {
            pageNum = pageParam.pageNum;
            pageSize = pageParam.limit;
            totalSize = pageParam.totalSize;
            totalPage = pageParam.totalPage;
            isFirstPage = (pageNum == 1);
            isLastPage = (pageNum == totalPage);
            PageInterceptor.PARAM_THREAD_LOCAL.remove();
        }
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Integer totalSize) {
        this.totalSize = totalSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Boolean getFirstPage() {
        return isFirstPage;
    }

    public void setFirstPage(Boolean firstPage) {
        isFirstPage = firstPage;
    }

    public Boolean getLastPage() {
        return isLastPage;
    }

    public void setLastPage(Boolean lastPage) {
        isLastPage = lastPage;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "isFirstPage=" + isFirstPage +
                ", isLastPage=" + isLastPage +
                ", pageNum=" + pageNum +
                ", pageSize=" + pageSize +
                ", totalSize=" + totalSize +
                ", totalPage=" + totalPage +
                ", data=" + data +
                '}';
    }
}
