package com.demo.structure.select;

/**
 * @program: Data-Structure
 * @ClassName BinarySearch
 * @description:
 * @author: huJie
 * @create: 2021-01-05 20:05
 **/
public class BinarySearch {

    public static boolean binarySearch(int[] sortedArr, int num){

        if(sortedArr == null || sortedArr.length==0){
            return false;
        }

        int L = 0;
        int R = sortedArr.length-1;
        int mid = 0;

        while (L < R){
            mid = L + ((R - L) >> 1);
            if(sortedArr[mid] == num){
                return true;
            }else if(sortedArr[mid] > num){  //中间数大于需要查找的数，在左区域查找
                R = mid-1;
            }else{//中间数小于需要查找的数，在左区域查找
                L = mid + 1;
            }
        }
        return sortedArr[L] == num;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 6, 8, 12, 25, 90};
        System.out.println( binarySearch(arr, 91));
    }
}
