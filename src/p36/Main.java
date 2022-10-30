package p36;

import java.util.Scanner;

/**
 * Description:
 * date: 2022/10/26 下午 3:53
 *
 * @author Four
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(in.nextInt()));
    }
}

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }

        return dp[n];
    }
}
