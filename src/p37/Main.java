package p37;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description:
 * date: 2022/10/26 下午 3:58
 *
 * @author Four
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // 清除首尾无效空格
        String[] str = in.nextLine().trim().split(" ");

        // 准确地获取合法数组
        List<Integer> nums = new ArrayList<>();
        for (String s : str) {
            if (s.length() == 0 || s.equals(" ")) continue;
            nums.add(Integer.parseInt(s));
        }

        System.out.println(new Solution().rob(nums.stream().mapToInt(Integer::valueOf).toArray()));
    }
}


class Solution {
    public int rob(int[] nums) {
        // 状态转移
        // dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i])

        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }
}

// 二维数组
class Solution02 {
    public int rob(int[] nums) {
        // 0: 不偷  1: 偷
        int n = nums.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }
}