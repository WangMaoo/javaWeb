package com.wmq.pojo;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月11日 20:12:00
 * @Description: TODO
 */
public class Category {
    private int cid;
    private String cname;

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                '}';
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }
}
