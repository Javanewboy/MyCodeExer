package com.example.mycodeexer;

import java.util.*;
import java.util.stream.Collectors;

public class ListRemoveDuplicates {
    public static void main(String[] args) {
//        m1();
//        m2();
//        m3();
//        m4();
        m5();
    }

    /**
     * for循环遍历 去重
     */
    private static void m1() {
        List<Integer> initList = Arrays.asList(70, 70, 3, 6, 7, 13, 7, 11, 5, 6, 18);
        List<Integer> arrayList = new ArrayList<>(initList);
        List<Integer> newList = new ArrayList<>();

        for (int i = 0; i < arrayList.size(); i++) {
            Integer tempValue = arrayList.get(i);
            if (!newList.contains(tempValue)) {
                newList.add(tempValue);
            }
        }
        System.out.println(newList);
    }

    /**
     * HashSet或LinkedHashS去重
     */
    private static void m2() {
        List<Integer> initList = Arrays.asList(70, 70, 3, 6, 7, 13, 7, 11, 5, 6, 18);
//       List<Integer> newList = new ArrayList<>(new HashSet<>(initList));
        List<Integer> newList = new ArrayList<>(new LinkedHashSet<>(initList));
        newList.forEach(s -> System.out.print(s + " "));
    }

    /**
     * Stream流式计算
     */
    private static void m3() {
        List<Integer> initList = Arrays.asList(70, 70, 3, 6, 7, 13, 7, 11, 5, 6, 18);
        List<Integer> arrayList = new ArrayList<>(initList);
        List<Integer> newList = new ArrayList<>();

        newList = arrayList.stream().distinct().collect(Collectors.toList());

        newList.forEach(s -> System.out.print(s + " "));
    }

    /**
     * 循环坐标去除重复,类似双指针,按照值找到下标
     * 如果下标不同,表示有重复需要删除
     */
    private static void m4() {
        List<Integer> initList = Arrays.asList(70, 70, 3, 6, 7, 13, 7, 11, 5, 6, 18);
        List<Integer> arrayList = new ArrayList<>(initList);
        List<Integer> newList = new ArrayList<>(initList);

        for (Integer element : arrayList) {
            if (newList.indexOf(element) != newList.lastIndexOf(element)) {
                newList.remove(newList.lastIndexOf(element));
            }
        }
        newList.forEach(s -> System.out.print(s + " "));
    }

    /**
     * 双循环对比,通过下标获得值,外层循环和内层循环对比,值相同去重复
     */
    private static void m5() {
        List<Integer> initList = Arrays.asList(70, 70, 3, 6, 7, 13, 7, 11, 5, 6, 18);
        List<Integer> arrayList = new ArrayList<>(initList);
        List<Integer> newList = new ArrayList<>(initList);

        for (int i = 0; i < newList.size() - 1; i++) {
            for (int j = newList.size() - 1; j > i; j--) {
                if (newList.get(j) == newList.get(i)) {
                    newList.remove(j);
                }
            }
        }
        newList.forEach(s -> System.out.print(s + " "));

    }
}
