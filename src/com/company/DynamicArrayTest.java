package com.company;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Iterator;

public class DynamicArrayTest {
    DynamicArray<String> arr = new DynamicArray<String>();

    @Test
    void testAdd() throws Exception{
        arr.add("a");
        assertEquals("a", arr.get(0));
    }

    @Test
    void testSize(){
        arr.add("a");
        arr.add("b");
        assertEquals(2, arr.size());
    }

    @Test
    void testSet() throws Exception{
        arr.add("a");
        arr.set("b", 0);
        assertEquals("b", arr.get(0));
    }

    @Test
    void testGet()throws Exception{
        arr.add("a");
        String el = arr.get(0);
        assertEquals("a", el);
    }

    @Test
    void testInsertAt()throws Exception{
        arr.add("a");
        arr.add("b");
        arr.insertAt("c", 1);
        assertEquals("c", arr.get(1));
    }

    @Test
    void testRemoveAt() throws Exception{
        arr.add("a");
        arr.add("b");
        arr.removeAt(1);
        assertEquals(1, arr.size());
        assertEquals("a", arr.get(0));
    }

    @Test
    void testIterator()throws Exception{
        DynamicArray<Integer> ar = new DynamicArray<Integer>();
        ar.add(1);
        ar.add(2);
        ar.add(3);
        Iterator<Integer> iter = ar.getIterator();
        for (int i = 0; i <ar.size() -1; i++ ){
            Integer item = iter.next();
            if(item.equals(ar.get(0))){
                assertEquals(1, item);
            }else{
                if(item.equals(ar.get(1))){
                    assertEquals(2, item);
                }else {
                    assertEquals(3, item);
                }
            }
        }
    }
}
