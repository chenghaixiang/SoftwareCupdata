package com.chenghaixiang.entiy;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Part {
    public int PARTKEY;//零件号
    public String NAME;//零件名称
    public String MFGR;//制造商名称
    public String BRAND;//零件品牌
    public String TYPE;//零件类型
    public int SIZE;//零件尺寸
    public String CONTAINER;//容器名称
    public double RETAILPRICE;//零件价格
    public String COMMENT;//备注

    @Override
    public String toString() {
        return "Obj11{" +
                "PARTKEY='" + PARTKEY + '\'' +
                ", NAME='" + NAME + '\'' +
                ", MFGR='" + MFGR + '\'' +
                ", BRAND='" + BRAND + '\'' +
                ", TYPE='" + TYPE + '\'' +
                ", SIZE='" + SIZE + '\'' +
                ", CONTAINER='" + CONTAINER + '\'' +
                ", RETAILPRICE='" + RETAILPRICE + '\'' +
                ", COMMENT='" + COMMENT + '\'' +
                '}';
    }
}
