package com.base;

/**
 * @author liutao
 * Date 2021/2/9 5:04 下午
 * Description:
 * Version: 1.0
 **/
public class ArrayOperation {
    private int[] array;
    private int size;

    public ArrayOperation(int capacity) {
        this.array = new int[capacity];
        size = 0;

    }

    public static void main(String[] args) {
        ArrayOperation arrayOperation = new ArrayOperation(10);
        arrayOperation.insert(1, 0);
        arrayOperation.printArray();
        arrayOperation.insert(2, 1);
        arrayOperation.printArray();
        arrayOperation.insert(3, 2);
        arrayOperation.printArray();
        arrayOperation.insert(4, 3);
        arrayOperation.printArray();
        arrayOperation.insert(6 , 4);
        arrayOperation.insert(8 , 5);

        arrayOperation.remove(3);

        arrayOperation.printArray();
    }

    public void insert(int element, int index) {


        for (int i = size - 1; i >= index; i--) {

            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }


    public boolean remove(int index){
        if(index<0||index>size-1){
            return false;
        }

        for(int i=index;i<size-1;i++){
            array[i]=array[i+1];

        }
        size--;
        return true;
    }



    private void printArray() {
        System.out.println("=================");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
        }
        System.out.println("");
        System.out.println("=================");
    }


}
