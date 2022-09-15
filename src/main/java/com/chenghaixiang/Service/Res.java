package com.chenghaixiang.Service;

import com.chenghaixiang.entiy.Total;

import java.util.ArrayList;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Res {
    public String name;
    public Integer code;
    public String err;
    public ArrayList<Total> dataList;
    public double sum;
    public Integer partnumber;


    @Override
    public String toString() {
        return "Res{" +
                "name='" + name + '\'' +
                ", code=" + code +
                ", err='" + err + '\'' +
                ", dataList=" + dataList +
                '}';
    }
}
