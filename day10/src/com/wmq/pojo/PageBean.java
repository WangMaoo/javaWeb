package com.wmq.pojo;

import java.util.List;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月04日 21:25:00
 * @Description: TODO
 */
public class PageBean<T> {
    List<T> data;
    /**
     * 第几页
     */
    int pageNumber;
    /**
     * 每页显示的条数
     */
    int pageSize;
    /**
     * 总条数
     */
    int totalCount;
    /**
     * 总页数
     */
    int totalPage;

    @Override
    public String toString() {
        return "PageBean{" +
                "data=" + data +
                ", pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + getTotalPage() +
                '}';
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return (int)Math.ceil(totalCount * 1.0 / pageSize);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }
}
