package com.demo.structure.sort;

import java.util.Arrays;

/**
 * @program: Data-Structure
 * @ClassName CountSort
 * @description:    计数排序
 * @author: huJie
 * @create: 2021-05-24 22:01
 **/
public class CountSort {
    public static void countSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        int i = 0;
        for (int j = 0; j < bucket.length; j++) {
            while (bucket[j]-- > 0) {
                arr[i++] = j;
            }
        }
    }

    public static int[] countSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int[] bucket = new int[max + 1];
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        for (int i = 1; i < bucket.length; i++) {
            bucket[i] = bucket[i] + bucket[i-1];
        }

        int[] result = new int[arr.length];
        for (int j = arr.length-1; j>=0; j--) {
            result[bucket[arr[j]]-1] = arr[j];
            bucket[arr[j]]--;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,5,8,6,3,1,6,3,9,3};
        System.out.println(Arrays.toString(arr));
        arr=countSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
