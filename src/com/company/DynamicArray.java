package com.company;

import java.util.*;
import java.util.function.Consumer;

public class DynamicArray<T> {
    private int sizeSt;
    private T[] current;

    public DynamicArray(){
        sizeSt = 0;
        current = null;
    }

    @SuppressWarnings("unchecked")
    public DynamicArray(int size){
        this.sizeSt = size;
        current = (T[]) new Object[size];
    }


    public int size() {
        return sizeSt;
    }

//���������� ������� �� �������
    public void set(T element, int index) throws Exception {
        if (index > sizeSt -1){
            throw new Exception("�� �������� ���������� �������. �������� ������ ������� �� ������� �������.");
        }else {
            current[index] = element;
        }
    }



    //�������� ������� �� �������
    @SuppressWarnings("unchecked")
    public <T>T get(int index) throws Exception {
        if (index > sizeSt -1){
            throw new Exception("���������� �������� �������. �������� ������ ������� �� ������� �������.");
        }else{
            T element = (T) current[index];
            return element;
        }
    }

    @SuppressWarnings("unchecked")
    public void add(T element){
        if(current == null){
            current = (T[]) new Object[1];
            current[0] = element;
            sizeSt ++;
        }else{
            T[] array = (T[])new Object[sizeSt + 1];
            for (int i = 0; i < array.length-1 ; i++){
                array[i] = current[i];
            }
            array[sizeSt] =  element;
            current = (T[]) array;
            sizeSt = sizeSt + 1;
        }

    }
    //������� ��������- �����������
    @SuppressWarnings("unchecked")
    public void insertAt(T element, int index) throws Exception {
        T[] array =(T[]) new Object[sizeSt+1];
        if(index > sizeSt){
            throw new Exception("���������� �������� �������. �������� ������ ������� �� ������� �������.");
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

    // �������� ��������- �����������
    @SuppressWarnings("unchecked")
    public void removeAt(int index) throws Exception {
        T[] array = (T[])new Object[sizeSt-1];
        if(index > sizeSt){
            throw new Exception("���������� ������� �������. �������� ������ ������� �� ������� �������.");
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

    public Iterator<T> getIterator( ){
        return new Iterator<T>() {
            private int index = 0;
            private int len = current.length;
            @Override
            public boolean hasNext() {
                 return index < len;
            }

            @Override
            public T next() {
                if (index < len) {
                    return current[index++];
                } else {
                    throw  new NoSuchElementException("� ������� ��� ���������.");
                }
            }
        };
    }
}
