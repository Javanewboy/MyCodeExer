package com.example.mycodeexer;

import java.util.ArrayList;
import java.util.List;

public class ArrayListResizeDebug {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= 50; i++) {
            list.add(i);
        }

        list.forEach(r -> System.out.print(r + " "));
    }
}
