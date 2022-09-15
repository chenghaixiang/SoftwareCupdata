package com.chenghaixiang.entiy;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Lineitem {
    public int ORDERKEY;//订单号
    public int PARTKEY;//零件号
    public int SUPPKEY;//供应商
    public int LINENUMBER;//订单细目号
    public int QUANTITY;//零件数量
    public double EXTENDEDPRICE;//零件价格
//    String DISCOUNT;//零件折扣
//    String TAX;//税率
//    String RETURNFLAG;//订单退回标志
//    String LINESTATUS;//订单状态
//    String SHIPDATE;//发货日期
//    String COMMITDATE;//提交日期
//    String RECEIPTDATE;//接收日期
//    String SHIPINSTRUCT;//发货指令
//    String SHIPMODE;//发货方式
//    String COMMENT;//备注


    @Override
    public String toString() {
        return "Dindan{" +
                "ORDERKEY='" + ORDERKEY + '\'' +
                ", PARTKEY='" + PARTKEY + '\'' +
                ", SUPPKEY='" + SUPPKEY + '\'' +
                ", LINENUMBER='" + LINENUMBER + '\'' +
                ", QUANTITY='" + QUANTITY + '\'' +
                ", EXTENDEDPRICE='" + EXTENDEDPRICE + '\'' +
                '}';
    }
}
