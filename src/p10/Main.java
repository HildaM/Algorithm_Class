package p10;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    static int[] coins = new int[3];
    static {
        coins[0] = 2; coins[1] = 5; coins[2] = 7;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int amount = in.nextInt();

        System.out.println(solution.coinChange(coins, amount));
    }
}

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                if (dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}
