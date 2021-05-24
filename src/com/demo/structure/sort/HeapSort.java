package com.demo.structure.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @program: Data-Structure
 * @ClassName HeapSort
 * @description: 堆排序
 * 这里以大根堆进行排序
 * @author: huJie
 * @create: 2021-05-23 12:32
 **/
public class HeapSort {


    public static void main(String[] args) {
        int[] heap = {3, 2, 8, 5, 1, 9, 45, 23, 90, 11, 4};
        System.out.println(Arrays.toString(heap));
        heapSort(heap);
        System.out.println(Arrays.toString(heap));
    }

    private static void heapSort(int[] heap) {
        if (heap == null || heap.length < 2) {
            return;
        }

        // 对heap中的每一个位置进行对比和排序
        for (int i = heap.length - 1; i >= 0; i--) {
            heapify(heap, i, heap.length);
        }

        int heapSize = heap.length;
        swap(heap, 0, --heapSize);
        // O(N*logN)
        while (heapSize > 0) { // O(N)
            heapify(heap, 0, heapSize); // O(logN)
            swap(heap, 0, --heapSize); // O(1)
        }
    }

    // arr[index]位置的数，能否往下移动
    private static void heapify(int[] heap, int index, int heapSize) {
        int leftChild = index * 2 + 1;
        while (leftChild < heapSize) {
            // 两个孩子中，谁的值大，把下标给largest
            // 1）只有左孩子，left -> largest
            // 2) 同时有左孩子和右孩子，右孩子的值<= 左孩子的值，left -> largest
            // 3) 同时有
            int largeIndex = leftChild + 1 < heapSize && heap[leftChild] < heap[leftChild + 1] ? leftChild + 1 : leftChild;
            largeIndex = heap[index] > heap[largeIndex] ? index : largeIndex;
            if (largeIndex == index) {
                break;
            }
            swap(heap, largeIndex, index);
            index = largeIndex;
            leftChild = index * 2 + 1;
        }
    }

    private static void swap(int[] heap, int index, int i) {
        int temp = heap[index];
        heap[index] = heap[i];
        heap[i] = temp;
    }
}
