package com.demo.structure.sort;

/**
 * @author by        hujie
 * @class_name SelectionSort
 * @description     选择排序
 *                  根据当前值，在数组中找最小值的下标  进行交换
 * @create_date 20:29 2020-05-22
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3,2,9,7,1,6,8,5};
        selectionSort(arr);

        System.out.print("arr====  ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
    }

    private static void selectionSort(int[] arr) {
        //如果为空  或者只有一个数 直接返回
        if(arr == null || arr.length < 2){
            return;
        }

        for (int i = 0; i < arr.length-1; i++) {
            //定义一个最小的坐标 最小值在哪个位置上  i～n-1
            int minIndex = i;
            for (int j = i+1; j < arr.length; j++) {
                // i ~ N-1 上找最小值的下标
                minIndex = arr[j] < arr[minIndex] ? j:minIndex;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap(int[] arr, int i, int minIndex) {
        int temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
