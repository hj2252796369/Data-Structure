package com.demo.structure.xor;

/**
 * 在不造成额外空间的情况下，交换数字
 *  a = a ^ b;
 *   b = a ^ b;
 *  a = a ^ b;
 * 异或运算
 */
public class Xor {
    public static void main(String[] args) {
        int a = 11;
        int b = 90;

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a == " + a);
        System.out.println("b == " + b);

        /**
         * 如果两个值在同一个空间，异或之后输出0
         */
        int[] arr = {11};
        arr[0] = arr[0] ^ arr[0];
        arr[0] = arr[0] ^ arr[0];
        arr[0] = arr[0] ^ arr[0];
        System.out.println("arr = " + arr[0]);
    }
}