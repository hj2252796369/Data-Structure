package com.demo.structure.sort;

/**
 * 给定一个数组arr，和一个整数num。请把小于等于num的数放在数组的左边，大于num的数放在数组的右边
 * 额外空间复杂度O(1)，时间复杂度O(N)
 *
 * @author by        hujie
 * @class_name QuickSort
 * @description 快速排序
 * @create_date 20:17 2020-05-22
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 9, 7, 1, 6, 8, 5};
        quickSort(arr);
    }

    public static void quickSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process(arr, 0, arr.length);
    }

    private static void process(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }

        int lessEqual = R-1;
        int index = L;
        while (index < R) {
            if(arr[index] <= arr[R]){
//                swap(arr, index, R);
            }
        }


    }
}
