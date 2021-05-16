package com.demo.structure.caseDemo;

/**
 * 双向链表实现 栈和队列
 */
public class T_002_DoubleLinkedToStackAndQueue {

    public static class Node<T> {
        public T value;
        public Node<T> last;
        public Node<T> next;

        public Node(T data) {
            value = data;
        }
        Integer i =Integer.valueOf(1);
    }

}
