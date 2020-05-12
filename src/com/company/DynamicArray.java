package com.company;

import java.util.*;
import java.util.function.Consumer;

public class DynamicArray {
    private int sizeSt;
    private Object[] current;

    public DynamicArray(){
        sizeSt = 0;
        current = null;
    }

    public DynamicArray(int size){
        this.sizeSt = size;
        current = new Object[size];
    }


    public int size() {
        return sizeSt;
    }

//установить элемент по индексу
    public void set(Object element, int index) throws Exception {
//        Iterator<Object> iterator = getIterator(current);
        if (index > sizeSt -1){
            throw new Exception("масив не достаточного размера");
        }else {
            current[index] = element;
        }
    }



    //получить элемент по индексу
    public Object get(int index) throws Exception {
        if (index > sizeSt -1){
            throw new Exception("масив не достаточного размера");
        }else{
            Object element = current[index];
            return element;
        }
    }

    public void add(Object element){
        if(current == null){
            current = new Object[1];
            current[0] = element;
            sizeSt ++;
        }else{
            Object[] array = new Object[sizeSt + 1];
            for (int i = 0; i < array.length-1 ; i++){
                array[i] = current[i];
            }
            array[sizeSt] = element;
            current = array;
            sizeSt = sizeSt + 1;
        }

    }
    //вставка элемента- опционально
    public void insertAt(Object element, int index) throws Exception {
        Object[] array = new Object[sizeSt+1];
        if(index > sizeSt){
            throw new Exception("масив не дотаточного размера");
        }else {
            for(int i = 0; i< index; i++){
                array[i] = current[i];
            }
            array[index] = element;
            for (int i = index+1; i< array.length; i++){
                array[i]= current[i-1];
            }
            sizeSt = sizeSt +1;
            current = array;
        }
    }

    // удаление элемента- опционально
    public void removeAt(int index) throws Exception {
        Object[] array = new Object[sizeSt-1];
        if(index > sizeSt){
            throw new Exception("масив не дотаточного размера");
        }else {
            for(int i = 0; i< index; i++){
                array[i] = current[i];
            }
            for (int i = index+1; i< array.length; i++){
                array[i]= current[i+1];
            }
            sizeSt = sizeSt -1;
            current = array;
        }
    }

    public Iterator<Object> getIterator( ){
        return new Iterator<Object>() {
            private int index = 0;
            private int len = current.length;
            @Override
            public boolean hasNext() {
                 return index < len;
            }

            @Override
            public Object next() {
                if (index < len) {
                    return current[index++];
                } else {
                    throw  new NoSuchElementException("No such element.");
                }
            }
        };
    }
}
