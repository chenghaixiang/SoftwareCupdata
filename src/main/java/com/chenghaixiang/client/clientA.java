package com.chenghaixiang.client;
import com.chenghaixiang.Example.ExampleA;
import com.chenghaixiang.Example.ExampleB;
import com.chenghaixiang.Example.ExampleC;
import com.chenghaixiang.Example.ExampleD;
import com.chenghaixiang.Service.Executor;
import com.chenghaixiang.Service.Res;
import com.chenghaixiang.Service.SynContainer;
import com.chenghaixiang.entiy.Boom;
import com.chenghaixiang.entiy.Total;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class clientA {
    public static void main(String[] args) {
        Total[] totals=new Total[25];

        SynContainer container=new SynContainer();

        ExampleA exampleA=new ExampleA(container);
        ExampleB exampleB=new ExampleB(container);
        ExampleC exampleC=new ExampleC(container);
        ExampleD exampleD=new ExampleD(container);
        ArrayList<Thread> threadArrayList=new ArrayList<>();
        threadArrayList.add(exampleA);
        threadArrayList.add(exampleB);
        threadArrayList.add(exampleC);
        threadArrayList.add(exampleD);

        ArrayList<Res> resArrayList=new Executor(threadArrayList,container).run();


        for (int j=0;j<25;j++){
            totals[j]=new Total("",0);
        }
        System.out.println("---------------------------------------");
        //总销售量
        double Totalsum=0;
        Integer Tonumber=0;
        for (Res res:resArrayList){
            Totalsum=res.sum+Totalsum;
            Tonumber=res.partnumber+Tonumber;
        }
        //平均销售量
        double mean=0;
        mean=Totalsum/Tonumber;
        double meanbaifz30=0;
        meanbaifz30=mean*0.3;

        System.out.println("总销售量："+Totalsum);
        System.out.println("平均销售量："+mean);

        show(meanbaifz30,exampleA,exampleB,exampleC,exampleD);
    }

    public static void show(double meanbaifz30,ExampleA exampleA,ExampleB exampleB,ExampleC exampleC,ExampleD exampleD){
        boolean control=true;
        while (control) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            double xiaosum = 0;
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入品牌名查看，该品牌的非畅销零件和非畅销零件销售总量,输入exit退出");
            String sc = scanner.nextLine();
            if (sc.equals("exit")){
                control=false;
                break;
            }
            for (Integer key : exampleA.juhe.keySet()) {
                if (exampleA.juhe.get(key) < meanbaifz30) {
                    if (exampleA.map.get(key) != null) {
                        if (exampleA.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                    if (exampleB.map.get(key) != null) {
                        if (exampleB.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                    if (exampleC.map.get(key) != null) {
                        if (exampleC.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                    if (exampleD.map.get(key) != null) {
                        if (exampleD.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                }
            }
            for (Integer key : exampleB.juhe.keySet()) {
                if (exampleB.juhe.get(key) < meanbaifz30) {
                    if (exampleA.map.get(key) != null) {
                        if (exampleA.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                    if (exampleB.map.get(key) != null) {
                        if (exampleB.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                    if (exampleC.map.get(key) != null) {
                        if (exampleC.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                    if (exampleD.map.get(key) != null) {
                        if (exampleD.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                }
            }
            for (Integer key : exampleC.juhe.keySet()) {
                if (exampleC.juhe.get(key) < meanbaifz30) {
                    if (exampleA.map.get(key) != null) {
                        if (exampleA.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                    if (exampleB.map.get(key) != null) {
                        if (exampleB.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                    if (exampleC.map.get(key) != null) {
                        if (exampleC.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                    if (exampleD.map.get(key) != null) {
                        if (exampleD.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                }
            }
            for (Integer key : exampleD.juhe.keySet()) {
                if (exampleD.juhe.get(key) < meanbaifz30) {
                    if (exampleA.map.get(key) != null) {
                        if (exampleA.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                    if (exampleB.map.get(key) != null) {
                        if (exampleB.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                    if (exampleC.map.get(key) != null) {
                        if (exampleC.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                    if (exampleD.map.get(key) != null) {
                        if (exampleD.map.get(key).BRAND.equals(sc)) {
                            arrayList.add(key);
                            xiaosum = xiaosum + exampleA.juhe.get(key);
                            break;
                        }
                    }
                }
            }
            for (Integer key : arrayList) {
                System.out.println("零件号：" + key);
            }
            System.out.println("非畅销零件销售总量:" + xiaosum);
        }
    }

}
