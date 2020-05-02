package com.company;

import java.util.Arrays;

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
//���������� ������� �� �������
    public void set(Object element, int index) throws Exception {
        if (index > sizeSt -1){
            throw new Exception("����� �� ������������ �������");
        }else {
            current[index] = element;
        }
    }

    //�������� ������� �� �������
    public Object get(int index) throws Exception {
        if (index > sizeSt -1){
            throw new Exception("����� �� ������������ �������");
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
    //������� ��������- �����������
    public void insertAt(Object element, int index) throws Exception {
        Object[] array = new Object[sizeSt+1];
        if(index > sizeSt){
            throw new Exception("����� �� ����������� �������");
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
    public void removeAt(int index) throws Exception {
        Object[] array = new Object[sizeSt-1];
        if(index > sizeSt){
            throw new Exception("����� �� ����������� �������");
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

    @Override
    public String toString() {
        return "DynamicArray{" +
                "sizeSt=" + sizeSt +
                ", current=" + Arrays.toString(current) +
                '}';
    }
}
