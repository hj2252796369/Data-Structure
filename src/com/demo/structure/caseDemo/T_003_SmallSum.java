package com.demo.structure.caseDemo;

/**
 * 在一个数组中，一个数左边比它小的数的总和，叫数的小和，所有数的小和累加起来，叫数组小和。求数组小和。
 * 例子： [1,3,4,2,5]
 * 1左边比1小的数：没有
 * 3左边比3小的数：1
 * 4左边比4小的数：1、3
 * 2左边比2小的数：1
 * 5左边比5小的数：1、3、4、 2
 * 所以数组的小和为1+1+3+1+1+3+4+2=16
 *
 * @program: Data-Structure
 * @ClassName T_003_SmallSum
 * @description:
 * @author: huJie
 * @create: 2021-05-16 16:31
 **/
public class T_003_SmallSum {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2, 5};
        int smallSum = smallSum(arr, 0, arr.length - 1);
        System.out.println(smallSum);
    }
    // arr[L..R]既要排好序，也要求小和返回
    // 所有merge时，产生的小和，累加
    // 左 排序   merge
    // 右 排序  merge
    // merge
    private static int smallSum(int[] arr, int L, int R) {
        if (R == L) {
            return 0;
        }
        int M = L + ((R - L) >> 1);
        return smallSum(arr, L, M) + smallSum(arr, M + 1, R) + merge(arr, L, M, R);
    }

    private static int merge(int[] arr, int L, int M, int R) {
        int[] help = new int[R - L + 1];
        int index = 0;
        int p1 = L;
        int p2 = M + 1;
        int result = 0;
        while (p1 <= M && p2 <= R) {
            result = result + (arr[p1] < arr[p2] ? (R - p2 + 1) * arr[p1] : 0);
            help[index++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        while (p1 <= M) {
            help[index++] = arr[p1++];
        }
        while (p2 <= R) {
            help[index++] = arr[p2++];
        }
        for (int i = 0; i < help.length; i++) {
            arr[L + i] = help[i];
        }
        return result;
    }


}
