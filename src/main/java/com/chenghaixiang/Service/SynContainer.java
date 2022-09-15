package com.chenghaixiang.Service;

import java.util.ArrayList;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class SynContainer {
    // 业务执行结果汇总
    ArrayList<Res> sList = new ArrayList<>();
    // 业务执行完毕 提交方法【同步锁】
    public synchronized void submit(Res res) {
        sList.add(res);
    }
}
