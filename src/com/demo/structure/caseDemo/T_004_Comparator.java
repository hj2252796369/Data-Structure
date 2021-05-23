package com.demo.structure.caseDemo;

import java.util.*;

/**
 * @program: Data-Structure
 * @ClassName T_004_Comparator
 * @description: 简单的自定义比较器
 * @author: huJie
 * @create: 2021-05-22 17:33
 **/
public class T_004_Comparator {
    public static void main(String[] args) {
        Student studentOne = new Student(1,"A", 28);
        Student studentTwo = new Student(2,"B", 62);
        Student studentThree = new Student(3,"C", 30);

        List list = new ArrayList<>();
        list.add(studentOne);
        list.add(studentTwo);
        list.add(studentThree);
        System.out.println(list);
        Collections.sort(list, new AgeComparator());
        System.out.println(list);
    }
}
class Student{
    private Integer id;
    private String name;
    private Integer age;

    public Student() {
    }

    public Student(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class AgeComparator implements Comparator<Student> {

    /**
     * 小于  负数
     * 等于  0
     * 大于  正数
     * @param o
     * @return
     */
    @Override
    public int compare(Student o1, Student o2) {
       return o1.getAge() - o2.getAge();
    }
}


class IdComparator implements Comparator<Student> {

    /**
     * 小于  负数
     * 等于  0
     * 大于  正数
     * @param o
     * @return
     */
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getId() - o2.getId();
    }
}
