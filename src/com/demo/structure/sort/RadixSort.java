package com.demo.structure.sort;

import java.util.Arrays;

/**
 * @program: Data-Structure
 * @ClassName RadixSort
 * @description: 基数排序
 * @author: huJie
 * @create: 2021-05-25 22:13
 **/
public class RadixSort {
    // only for no-negative value
    public static void radixSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        radixSort(arr, 0, arr.length - 1, maxbits(arr));
    }

    public static int maxbits(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int res = 0;
        while (max != 0) {
            res++;
            max /= 10;
        }
        return res;
    }

    // arr[l..r]排序  ,  digit
    // l..r    3 56 17 100    3
    public static void radixSort(int[] arr, int L, int R, int digit) {
        final int radix = 10;
        int i = 0, j = 0;
        // 有多少个数准备多少个辅助空间
        int[] help = new int[R - L + 1];
        for (int d = 1; d <= digit; d++) { // 有多少位就进出几次
            // 10个空间
            // count[0] 当前位(d位)是0的数字有多少个
            // count[1] 当前位(d位)是(0和1)的数字有多少个
            // count[2] 当前位(d位)是(0、1和2)的数字有多少个
            // count[i] 当前位(d位)是(0~i)的数字有多少个
            int[] count = new int[radix]; // count[0..9]
            for (i = L; i <= R; i++) {
                // 103  1   3
                // 209  1   9
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }
        }


    }

    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    public static void main(String[] args) {
        int[] arr = {3, 56, 13, 156, 867, 345, 2, 77};
        System.out.println(Arrays.toString(arr));
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
