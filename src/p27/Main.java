package p27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Solution2 solution = new Solution2();

        String line = in.nextLine();
        String[] arr = line.split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }

        int target = in.nextInt();

        System.out.println(solution.findTargetSumWays(nums, target));
    }
}

// 回溯法
class Solution {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;

        if (target > sum) return 0;
        if ((sum + target) % 2 != 0) return 0;

        int bageSize = (sum + target) / 2;
        Arrays.sort(nums);
        recursion(nums, 0, bageSize, 0);
        return ans;
    }

    private void recursion(int[] nums, int start, int target, int sum) {
        if (target == sum) ans++;

        for (int i = start; i < nums.length && sum + nums[i] <= target; i++) {
            recursion(nums, i + 1, target, sum + nums[i]);
        }
    }
}

// dp
class Solution2 {
    int ans = 0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int n : nums) sum += n;

        if (target > sum) return 0;
        if ((sum + target) % 2 != 0) return 0;

        int bageSize = (sum + target) / 2;
        if (bageSize < 0) bageSize = -bageSize;

        int[] dp = new int[bageSize + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = bageSize; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }

        return dp[bageSize];
    }
}
