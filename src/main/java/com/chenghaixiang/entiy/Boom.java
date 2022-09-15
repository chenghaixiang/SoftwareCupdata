package com.chenghaixiang.entiy;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Boom {
    public Integer PARTKEY;
    public Integer QUANTITY;
    public Boom boom;

    public Boom() {
    }

    public Boom(Integer PARTKEY, Integer QUANTITY) {
        this.PARTKEY = PARTKEY;
        this.QUANTITY = QUANTITY;
    }

    @Override
    public String toString() {
        return "Boom{" +
                "PARTKEY=" + PARTKEY +
                ", QUANTITY=" + QUANTITY +
                '}';
    }
}
