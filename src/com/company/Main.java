package com.company;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws Exception {
        DynamicArray arr = new DynamicArray();
        arr.add("1");
        arr.add("1");
        arr.add("1");
        arr.add("2");

        Iterator<Object> iter = arr.getIterator();
        while (iter.hasNext())
        {
            Object item = iter.next();
            System.out.println(item);
        }

//        arr.removeAt( 5);
//        arr.set("e", 2);
//        Object el = arr.get(3);
//        arr.insertAt("0", 4);
//        for (int i = 0; i < 100; i++) {
//            arr.add(" " + i);
//        }
//        System.out.println(arr.toString());
//        System.out.println(el);
    }
}
