package com.aoao.bean;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author aoao
 * @create 2025-02-15-16:24
 */
public class Type implements Serializable {
    private static final long serialVersionUID = 2L;

    private Integer tid;//类型编号
    private String tname;//类型名称

    public Type() {}

    public Type(Integer tid, String tname) {
        this.tid = tid;
        this.tname = tname;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return Objects.equals(tid, type.tid) && Objects.equals(tname, type.tname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tid, tname);
    }

    @Override
    public String toString() {
        return "Type{" +
                "tid=" + tid +
                ", tname='" + tname + '\'' +
                '}';
    }
}
