package com.company;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        DynamicArray arr = new DynamicArray();
        arr.add("1");
        arr.add("1");
        arr.add("1");
        arr.add("2");
        arr.set("e", 2);
//        Object el = arr.get(3);
//        arr.insertAt("0", 4);
//        for (int i = 0; i < 100; i++) {
//            arr.add(" " + i);
//        }
        System.out.println(arr.toString());
//        System.out.println(el);
    }
}
