package p13;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.method02());
    }
}

class Solution {
    static int n = 4;
    static int bagweight = 10;
    static int[] weight = new int[4];
    static int[] values = new int[4];
    static {
        weight[0] = 7;
        weight[1] = 3;
        weight[2] = 4;
        weight[3] = 5;
        values[0] = 42;
        values[1] = 12;
        values[2] = 40;
        values[3] = 25;
    }

    public int method01() {
        int[][] dp = new int[n][bagweight + 1];
        for (int i = weight[0]; i <= bagweight; i++) {
            dp[0][i] = values[0];
        }

        for (int i = 1; i < n; i++) {   // 遍历物品
            for (int j = 0; j <= bagweight; j++) {  // 遍历背包
                if (j < weight[i]) dp[i][j] = dp[i - 1][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + values[i]);
            }
        }

        return dp[n - 1][bagweight];
    }

    public int method02() {
        int[] dp = new int[bagweight + 1];
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = bagweight; j >= weight[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + values[i]);
            }
        }

        return dp[bagweight];
    }
}


