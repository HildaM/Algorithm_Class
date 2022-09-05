package p12;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = in.nextInt();
        System.out.println(solution.climbStairs(n));
    }
}

class Solution {
    public int climbStairs(int n) {
        // dp[i]: 走第i个台阶，有dp[i]种方法
        if (n == 1) return 1;
        if (n == 2) return 2;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
