package com.demo.structure.caseDemo;

import java.util.Arrays;

/**
 * @program: Data-Structure
 * @ClassName T_005_MaxHeap
 * @description: 大根堆
 * @author: huJie
 * @create: 2021-05-22 18:23
 **/
public class T_005_MaxHeap {

    static class MyHeap {
        private int[] heap;
        private int limit;
        private int heapSize;

        public MyHeap(int[] heap, int limit, int heapSize) {
            this.heap = heap;
            this.limit = limit;
            this.heapSize = heapSize;
        }

        public boolean isEmpty() {
            return heapSize == 0;
        }

        public boolean isFull() {
            return heapSize == limit;
        }

        /**
         * 向heap中插入值
         * 并且再次行程大根堆
         *
         * @param value
         */
        public void push(Integer value) {
            if (limit == heapSize) {
                throw new RuntimeException("heap is full");
            }
            // 将值放入heap中
            heap[heapSize] = value;
            // 调整heap形成大根堆
            heapInsert(heap, heapSize++);
        }

        private void heapInsert(int[] heap, int index) {
            while (heap[index] > heap[(index - 1) / 2]) {
                swap(heap, index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        private void swap(int[] heap, int index, int i) {
            int temp = heap[index];
            heap[index] = heap[i];
            heap[i] = temp;
        }

        @Override
        public String toString() {
            return "MyHeap{" +
                    "heap=" + Arrays.toString(heap) +
                    ", limit=" + limit +
                    ", heapSize=" + heapSize +
                    '}';
        }

        /**
         * pop获取第一个值
         * 内部操作：
         * 获取第一个值，然后将第一个值与最后一个值进行交换，再次对大根堆进行重排
         */
        public int pop() {
            int result = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return result;
        }

        private void heapify(int[] heap, int index, int heapSize) {
            int next = index * 2 + 1;
            while (next < heapSize) {
                // 找两个子节点最大的下标
                int swapIndex = next + 1 < heapSize && heap[next] < heap[next + 1] ? next + 1 : next;
                swapIndex = heap[swapIndex] > heap[index] ? swapIndex : index;
                // 下一个没有自己本身大
                if (swapIndex == index) {
                    break;
                }
                swap(heap, index, swapIndex);
                index = swapIndex;
                next = index * 2 + 1;
            }
        }
    }

    public static void main(String[] args) {
        int limit = 10;
        int[] heap = new int[limit];
        MyHeap myHeap = new MyHeap(heap, limit, 0);
        myHeap.push(2);
        System.out.println(myHeap);
        myHeap.push(4);
        System.out.println(myHeap);

        int result = myHeap.pop();
        System.out.println(result);
        System.out.println(myHeap);
    }
}
