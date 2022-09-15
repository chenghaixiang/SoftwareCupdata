package com.chenghaixiang.entiy;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Total {
    public String BRAND;//零件品牌
    public double QUANTITY;//零件数量

    public Total() {
    }

    public Total(String BRAND, int QUANTITY) {
        this.BRAND = BRAND;
        this.QUANTITY = QUANTITY;
    }

    @Override
    public String toString() {
        return "Total{" +
                "BRAND='" + BRAND + '\'' +
                ", QUANTITY=" + QUANTITY +
                '}';
    }
}
