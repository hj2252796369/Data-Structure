package com.demo.structure.sort;

/**
 * 1）整体是递归，左边排好序+右边排好序+merge让整体有序
 * 2）让其整体有序的过程里用了排外序方法
 * 3）利用master公式来求解时间复杂度
 * 4）当然可以用非递归实现
 *
 * @program: Data-Structure
 * @ClassName MergeSort
 * @description:
 * @author: huJie
 * @create: 2021-05-16 14:06
 **/
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 2, 9, 7, 1, 6, 8, 5};
        printArr(arr);
        //  递归方法
//        mergeSort(arr, 0, arr.length - 1);
        mergeSortWithCycle(arr);
        printArr(arr);
    }

    /**
     * 非递归实现
     * 通过对数组不断的细分，以mergeSize为一个比较单位，与相邻大小的mergeSize的数组进行比较个merge，从而覆盖到整个数组
     *
     * @param arr
     */
    private static void mergeSortWithCycle(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }

        int N = arr.length;
        int mergeSize = 1; // 当前有序的，左组长度
        while (mergeSize < N) {
            int L = 0;  // 左组的位置
            while (L < N) {
                // L...M  左组（mergeSize）
                int M = L + mergeSize - 1;
                if (M >= N) {
                    break;
                }
                int R = Math.min(N - 1, M + mergeSize);
                //  L...M   M+1...R(mergeSize)
                merge(arr, L, M, R);
                L = R + 1;
            }
            // 避免越界
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize = mergeSize << 1;
        }
    }

    private static void printArr(int[] arr) {
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // 递归实现
    private static void mergeSort(int[] arr, int L, int R) {
        if (L == R)
            return;
        int mid = L + (R - L) / 2;

        mergeSort(arr, L, mid);
        mergeSort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] help = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= r) {
            help[i++] = arr[p1] >= arr[p2] ? arr[p2++] : arr[p1++];
        }

        // 这里 要么是p1 越界，要么是p2越界
        while (p1 <= mid) {
            help[i++] = arr[p1++];
        }
        while (p2 <= r) {
            help[i++] = arr[p2++];
        }

        // 将help的值填充到arr当中
        for (int j = 0; j < help.length; j++) {
            arr[l + j] = help[j];
        }

    }

}
