package com.chenghaixiang.Service;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class Executor {
    private final ArrayList<Thread> tList;
    private final SynContainer container;
    public Executor(ArrayList<Thread> tList, SynContainer container) {
        this.tList = tList;
        this.container = container;
    }

    public ArrayList<Res> run(){
        System.out.println("输入load开始加载数据");
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s.equals("load")) {
            for (Thread service : this.tList) {
                service.start();
            }

            for (Thread service : this.tList) {
                Thread.State state = service.getState();
                while (state != Thread.State.TERMINATED) {
                    state = service.getState();
//                System.out.println("当前线程状态："+state);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else {
            return this.container.sList=null;
        }
        return this.container.sList;
    }
}
