package com.demo.structure.sort;

/**
 * @program: Data-Structure
 * @ClassName BubbleSortFirst
 * @description:    冒泡排序  最好时间：O(n)  最坏时间：O(n^2)  平均时间：O(n^2)  额外空间：1  稳定性：稳定
 * @author: hujie
 * @create: 2020-05-20 17:34
 **/
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3,2,9,7,1,6,8,5};
//        sort1(arr);
//        int[] arr1 = {5,4,3,1,2};
//        sort2(arr1);
        sort3(arr);
    }

    /**
     * 冒泡排序（未优化） 时间：O(n^2)
     * @param arr
     */
    public static void sort1(int[] arr){
        // 定义一个临时值
        int temp = 0;
        // 要遍历的次数
        for (int i = 0; i < arr.length-1; i++) {
            System.out.format("第 %d 遍：\n", i+1);
            //依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] < arr[j+1]){
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
                System.out.format("第 %d 遍的第%d 次交换：", i+1,j+1);
                for(int count:arr) {
                    System.out.print(count);
                }
                System.out.println("");
            }
            System.out.format("第 %d 遍最终结果：", i+1);
            for(int count:arr) {
                System.out.print(count);
            }
            System.out.println("\n#########################");
        }
    }

    /**
     * 优化一
     * @param arr
     */
    public static void sort2(int[] arr){
        // 定义一个临时值
        int temp = 0;
        // 要遍历的次数
        for (int i = 0; i < arr.length-1; i++) {
            int flag = 1;
            System.out.format("第 %d 遍：\n", i+1);
            //依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] < arr[j+1]){
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag = 0;
                }
                System.out.format("第 %d 遍的第%d 次交换：", i+1,j+1);
                for(int count:arr) {
                    System.out.print(count);
                }
                System.out.println("");
            }
            System.out.format("第 %d 遍最终结果：", i+1);
            for(int count:arr) {
                System.out.print(count);
            }
            System.out.println("\n#########################");

            if(flag == 1){
                return;
            }

        }
    }


    /**
     * 优化二
     * @param arr
     */
    public static void sort3(int[] arr){
        // 定义一个临时值
        int temp = 0;
        int len = arr.length-1;
        // 记录最后一次交换的位置
        int tempPostion = 0;
        // 要遍历的次数
        for (int i = 0; i < arr.length-1; i++) {
            int flag = 1;
            System.out.format("第 %d 遍：\n", i+1);
            //依次的比较相邻两个数的大小，遍历一次后，把数组中第i小的数放在第i个位置上
            for (int j = 0; j < len-i; j++) {
                if(arr[j] < arr[j+1]){
                    temp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag = 0;
                    //记录交换的位置
                    tempPostion = j;
                }
                System.out.format("第 %d 遍的第%d 次交换：", i+1,j+1);
                for(int count:arr) {
                    System.out.print(count);
                }
                System.out.println("");
            }
            //把最后一次交换的位置给len，来缩减内循环的次数
            len = tempPostion;
            System.out.format("第 %d 遍最终结果：", i+1);
            for(int count:arr) {
                System.out.print(count);
            }
            System.out.println("\n#########################");

            if(flag == 1){
                return;
            }

        }
    }
}
