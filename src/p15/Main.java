package p15;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = in.nextInt();

        System.out.println(new Solution().maxSubArray(nums));
    }
}

class Solution {
    // 贪心算法

    public int maxSubArray(int[] nums) {
        int sum = 0, ans = Integer.MIN_VALUE;

        for (int i = 0, j = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > ans) ans = sum;
            if (sum < 0) sum = 0;
        }

        return ans;
    }
}
