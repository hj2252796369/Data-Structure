package com.demo.structure.sort;

/**
 * @author by        hujie
 * @class_name InsertSort
 * @description 插入排序
 *              从第一个数开始排序，在对下一个数的排序时，保证这个数之前的数组是有序的，在通过比较数值的大小比较，找到该数在小型有序数组的位置
 * @create_date 20:37 2020-05-22
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = {3,2,9,7,1,6,8,5};
        insertSort(arr);

        System.out.print("arr====  ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    private static void insertSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i-1; j >=0 && arr[j] > arr[j+1]; j--) {
                swap(arr, j, j+1);
            }
        }

    }

    private static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
