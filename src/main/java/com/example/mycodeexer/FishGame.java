package com.example.mycodeexer;


import java.util.Scanner;


public class FishGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        boolean[] isKoi = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            int koiPosition = scanner.nextInt();
            isKoi[koiPosition] = true;
        }
        boolean result = canGoldyeWin(n, isKoi);
        if (result) {
            System.out.println("Xiaozhu Hahaha");
        } else {
            System.out.println("Goldye");
        }
    }

    private static boolean canGoldyeWin(int n, boolean[] isKoi) {
        // 如果只有一条鱼，判断是否为锦鲤
        if (n == 1) {
            return isKoi[1];
        }
        // 创建二维数组用于动态规划
        boolean[][] dp = new boolean[n + 1][n + 1];
        for (int len = 1; len <= n; len++) {
            for (int start = 1; start + len - 1 <= n; start++) {
                int end = start + len - 1;
                if (len == 1) {
                    dp[start][end] = isKoi[start];
                } else {
                    // 如果小猪取左边的鱼，狗爷可以选择右边的鱼，或者小猪取右边的鱼，狗爷选择左边的鱼
                    dp[start][end] =!dp[start + 1][end] ||!dp[start][end - 1];
                }
            }
        }
        return dp[1][n];
    }
}