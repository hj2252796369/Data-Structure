package com.demo.structure.caseDemo;

/**
 * @program: Data-Structure
 * @ClassName T_008_GetMaxUseRecursion
 * @description:
 * @author: huJie
 * @create: 2021-01-05 21:03
 **/
public class T_008_GetMaxUseRecursion {
    // 求arr中的最大值
    public static int getMax(int[] arr) {
        return process(arr, 0, arr.length - 1);
    }

    private static int process(int[] arr, int L, int R) {
        if(L == R){
            return arr[L];
        }

        int mid = L + ((R-L) >> 1);
        int leftMax = process(arr, L, mid);
        int rightMax = process(arr, mid, R);

        return Math.max(leftMax, rightMax);
    }

}
