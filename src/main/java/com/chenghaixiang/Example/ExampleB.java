package com.chenghaixiang.Example;

import com.chenghaixiang.Service.Res;
import com.chenghaixiang.Service.SynContainer;
import com.chenghaixiang.entiy.Lineitem;
import com.chenghaixiang.entiy.Part;
import com.chenghaixiang.entiy.Total;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * @author 程海翔
 * @school 石家庄铁道大学
 */
public class ExampleB extends Thread{
    SynContainer container;

    public ExampleB(SynContainer container){
        this.container=container;
    }

    public HashMap<Integer, Part> map;
    public HashMap<Integer, Lineitem> Lmap;
    public HashMap<Integer,Integer> juhe;
    @Override
    public void run() {
        String filepath="D:\\中国软件杯\\因子5数据集\\part2.txt";
        BufferedReader bufferedReader=null;
        map=new HashMap<>();
        long startTime = System.currentTimeMillis();
        try {

            System.out.println("B开始导入数据");
            bufferedReader=new BufferedReader(new FileReader(filepath));
            String s;

            while ((s = bufferedReader.readLine()) != null){
                int j=0;
                int jj=0;
                Part obj=new Part();
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i)=='|'&&jj==0){
                        obj.PARTKEY=Integer.parseInt(s.substring(j,i));
                        j=i+1;
                        jj++;
                    }else if (s.charAt(i)=='|'&&jj==1){
                        obj.NAME=s.substring(j,i);
                        j=i+1;
                        jj++;
                    }else if(s.charAt(i)=='|'&&jj==2){
                        obj.MFGR=s.substring(j,i);
                        j=i+1;
                        jj++;
                    }else if(s.charAt(i)=='|'&&jj==3){
                        obj.BRAND=s.substring(j,i);
                        j=i+1;
                        jj++;
                    }else if(s.charAt(i)=='|'&&jj==4){
                        obj.TYPE=s.substring(j,i);
                        j=i+1;
                        jj++;
                    }else if(s.charAt(i)=='|'&&jj==5){
                        obj.SIZE=Integer.parseInt(s.substring(j,i));
                        j=i+1;
                        jj++;
                    }else if(s.charAt(i)=='|'&&jj==6){
                        obj.CONTAINER=s.substring(j,i);
                        j=i+1;
                        jj++;
                    }else if(s.charAt(i)=='|'&&jj==7){
                        obj.RETAILPRICE=Double.parseDouble(s.substring(j,i));
                        j=i+1;
                        jj++;
                    }else if(s.charAt(i)=='|'&&jj==8){
                        obj.COMMENT=s.substring(j,i);
                        j=i+1;
                        jj++;
                    }
                }
                map.put(obj.PARTKEY, obj);
                obj=null;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }

        String filepath1="D:\\中国软件杯\\因子5数据集\\lineitem2.txt";
        BufferedReader bufferedReader1=null;
        Lmap=new HashMap<>();
        juhe=new HashMap<>();
        //销售总量
        int sum = 0;

        try {
            bufferedReader1=new BufferedReader(new FileReader(filepath1));
            String s;
            int ii=1;
            while ((s = bufferedReader1.readLine()) != null){
                int j=0;
                int jj=0;
                Lineitem lineitem=new Lineitem();
                for (int i = 0; i < s.length(); i++) {
                    if(s.charAt(i)=='|'&&jj==0){
                        lineitem.ORDERKEY=Integer.parseInt(s.substring(j,i));
                        j=i+1;
                        jj++;
                    }else if (s.charAt(i)=='|'&&jj==1){
                        lineitem.PARTKEY=Integer.parseInt(s.substring(j,i));
                        j=i+1;
                        jj++;
                    }else if(s.charAt(i)=='|'&&jj==2){
                        lineitem.SUPPKEY=Integer.parseInt(s.substring(j,i));
                        j=i+1;
                        jj++;
                    }else if(s.charAt(i)=='|'&&jj==3){
                        lineitem.LINENUMBER=Integer.parseInt(s.substring(j,i));
                        j=i+1;
                        jj++;
                    } else if(s.charAt(i)=='|'&&jj==4){
                        lineitem.QUANTITY=Integer.parseInt(s.substring(j,i));
                        j=i+1;
                        jj++;
                    } else if(s.charAt(i)=='|'&&jj==5){
                        lineitem.EXTENDEDPRICE=Double.parseDouble(s.substring(j,i));
                        j=i+1;
                        jj++;
                        break;
                    }

                }
                //聚合
                if(juhe.get(lineitem.PARTKEY)==null){
                    juhe.put(lineitem.PARTKEY,lineitem.QUANTITY);
                }else {
                    int temp=0;
                    temp=juhe.get(lineitem.PARTKEY)+lineitem.QUANTITY;
                    juhe.put(lineitem.PARTKEY,temp);
                }
                sum=lineitem.QUANTITY+sum;
                Lmap.put(ii,lineitem);
                lineitem=null;
                ii++;
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                bufferedReader1.close();
            }catch (IOException e){
                e.printStackTrace();
            }
            System.out.println("数据导入结束");
            long endTime1 = System.currentTimeMillis();
            //打印
            long time1= TimeUnit.MILLISECONDS.toSeconds((endTime1 - startTime));
            System.out.println("B程序导入数据时间：" + time1 + "s");
        }

        System.out.println("输入S开始查询:");
        Scanner scanner=new Scanner(System.in);
        String s=scanner.nextLine();

        long startTime1 = System.currentTimeMillis();
        Total[][] total=new Total[5][5];
        for (int i = 1; i <=5 ; i++) {
            for (int j=1;j<=5;j++){
                total[i-1][j-1]=new Total("",0);
                total[i-1][j-1].BRAND="Brand#"+i+j;
                total[i-1][j-1].QUANTITY=0;
            }
        }
//        System.out.println("开始遍历");
        int count=0;
        for(Integer id:Lmap.keySet()){
            if(map.get(Lmap.get(id).PARTKEY)!=null) {
                for (int i=0;i<5;i++) {
                    for (int j=0;j<5;j++) {
                        if (map.get(Lmap.get(id).PARTKEY).BRAND.equals(total[i][j].BRAND)) {
                            total[i][j].QUANTITY = total[i][j].QUANTITY + Lmap.get(id).EXTENDEDPRICE;
                            count++;
                            break;
                        }
                    }
                    if(count==1){
                        break;
                    }
                }
            }
        }
//        System.out.println("遍历结束");
        ArrayList<Total> arrayList=new ArrayList<>();
        for (int i = 0; i <5 ; i++) {
            for (int j=0;j<5;j++){
                arrayList.add(total[i][j]);
            }
        }

        Res res=new Res();
        res.name="线程B";
        res.code=200;
        res.err="查询成功";
        res.dataList=arrayList;
        res.sum=sum;
        res.partnumber=juhe.size();
        container.submit(res);

        long endTime = System.currentTimeMillis();
        //打印
        long time= TimeUnit.MILLISECONDS.toSeconds((endTime - startTime1));
        System.out.println("B程序计算时间：" + time + "s");
    }
}
