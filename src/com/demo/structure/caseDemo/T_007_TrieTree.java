package com.demo.structure.caseDemo;

import java.util.HashMap;

/**
 * @program: Data-Structure
 * @ClassName T_007_TrieTree
 * @description: 前缀树
 * @author: huJie
 * @create: 2021-05-24 20:28
 **/
public class T_007_TrieTree {
    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1() {
            this.pass = 0;
            this.end = 0;
            this.nexts = new Node1[26];
        }
    }

    public static class Trie1 {
        private Node1 root;

        public Trie1() {
            root = new Node1();
        }

        @Override
        public String toString() {
            return "Trie1{" +
                    "root=" + root +
                    '}';
        }

        public void insert(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            char[] chars = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chars.length; i++) {  // 从左向右循环遍历存储
                index = chars[i] - 'a'; // 这里使用的是数组存储字母的ASCII值。
                if (node.nexts[index] == null) { // 判断当前的ASCII值的字母是否存在
                    node.nexts[index] = new Node1();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        public boolean search(String word) {
            if (word == null || word.length() == 0) {
                return true;
            }
            Node1 node = root;
            char[] chars = word.toCharArray();
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                index = chars[i] - 'a';
                if (node.nexts[index] == null) {
                    return false;
                }
                node = node.nexts[index];
                if (i == chars.length - 1 && node.end > 0) {
                    return true;
                }
            }
            return false;
        }

        public void delete(String word) {
            if (word == null || word.length() == 0) {
                return;
            }
            if (search(word)) {
                char[] chars = word.toCharArray();
                Node1 node = root;
                int index = 0;
                for (int i = 0; i < chars.length; i++) {
                    index = chars[i] - 'a';
                    if (node.nexts[index] == null) {
                        return;
                    }
                    node.pass--;
                    if (node.pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

        // 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = chs[i] - 'a';
                if (node.nexts[index] == null) {
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }
    }

    public static class Node2{
        public int pass;
        public int end;
        public HashMap<Integer, Node2> nexts;

        public Node2() {
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }
    public static class Trie2 {
        private Node2 root;

        public Trie2() {
            root = new Node2();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }
            char[] chs = word.toCharArray();
            Node2 node = root;
            node.pass++;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = (int) chs[i];
                if (!node.nexts.containsKey(index)) {
                    node.nexts.put(index, new Node2());
                }
                node = node.nexts.get(index);
                node.pass++;
            }
            node.end++;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                Node2 node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = (int) chs[i];
                    if (--node.nexts.get(index).pass == 0) {
                        node.nexts.remove(index);
                        return;
                    }
                    node = node.nexts.get(index);
                }
                node.end--;
            }
        }

        // word这个单词之前加入过几次
        public int search(String word) {
            if (word == null) {
                return 0;
            }
            char[] chs = word.toCharArray();
            Node2 node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = (int) chs[i];
                if (!node.nexts.containsKey(index)) {
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.end;
        }

        // 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }
            char[] chs = pre.toCharArray();
            Node2 node = root;
            int index = 0;
            for (int i = 0; i < chs.length; i++) {
                index = (int) chs[i];
                if (!node.nexts.containsKey(index)) {
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.pass;
        }
    }
    public static void main(String[] args) {
        Trie1 trie1 = new Trie1();
        String word = "abcdef";
        String word2 = "abc";
        trie1.insert(word);
        trie1.insert(word2);
        System.out.println(trie1);
        System.out.println(word + " 在Trie中 " + (trie1.search(word) ? "存在" : "不存在"));
        System.out.println(word2 + " 在Trie中 " + (trie1.search(word2) ? "存在" : "不存在"));

        System.out.println("abc在Trie中以前缀的形式存在： " + trie1.prefixNumber("abc"));

        trie1.delete(word);
        System.out.println(word + " 在Trie中 " + (trie1.search(word) ? "存在" : "不存在"));
        System.out.println(word2 + " 在Trie中 " + (trie1.search(word2) ? "存在" : "不存在"));
    }
}
