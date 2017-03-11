package com.xiaoqiang.network;

import java.io.Serializable;

/**
 * Created by xiaoqiang on 2017/3/10.
 * 这个类主要用于统一封装model对象
 */

public class HttpMethods<T> implements Serializable {
    private int count;
    private int start;
    private int total;
    private String title;
    private T subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public T getSubjects() {
        return subjects;
    }

    public void setSubjects(T subjects) {
        this.subjects = subjects;
    }
}
