package com.wmq.pojo;

/**
 * @author Wang
 * @version 1.0.0
 * @createTime 2020年07月07日 21:52:00
 * @Description: TODO
 */
public class Area {
    private int id;
    private int pid;
    private String name;

    @Override
    public String toString() {
        return "Area{" +
                "id=" + id +
                ", pid=" + pid +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Area(int id, int pid, String name) {
        this.id = id;
        this.pid = pid;
        this.name = name;
    }

    public Area() {

    }
}
