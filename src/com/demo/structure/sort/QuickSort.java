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
        int mid = L + (int) (Math.random() * (R - L + 1));
        swap(arr, mid, R);
        int[] equalArea = netherlandsFlag(arr, L, R);

        process(arr, L, equalArea[0]-1);
        process(arr, equalArea[1]+1, R);
    }

    private static void swap(int[] arr, int mid, int r) {
        int temp = arr[mid];
        arr[mid] = arr[r];
        arr[r] = temp;
    }

    // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
    //  <arr[R]  ==arr[R]  > arr[R]
    public static int[] netherlandsFlag(int[] arr, int L, int R) {
        if (L > R) {
            return new int[] { -1, -1 };
        }
        if (L == R) {
            return new int[] { L, R };
        }
        int less = L - 1; // < 区 右边界
        int more = R;     // > 区 左边界
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else { // >
                swap(arr, index, --more);
            }
        }
        swap(arr, more, R);
        return new int[] { less + 1, more };
    }
}
