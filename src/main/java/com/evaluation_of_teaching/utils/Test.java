package com.evaluation_of_teaching.utils;


import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        System.out.println("2021,顺风顺水~");
    }



    public static List<Object> Demo(List<Object> list){
        List<Object> newList = new ArrayList<>();
        a:for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < newList.size(); j++){
                if(list.get(i).equals(newList.get(j))){
                    continue a;
                }
            }
            newList.add(list.get(i));
        }
        return newList;
    }

    public static class runableDemo implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < 30; i++) {
                System.out.println("卖票");
            }
        }
    }

}
