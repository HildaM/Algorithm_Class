package p34;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = in.nextInt();

        System.out.println(new Solution().minOperations(nums));
    }
}


class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;

        int count = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (nums[i] < nums[i + 1]) continue;
            else if (nums[i] == nums[i + 1]) {
                nums[i + 1]++;
                count++;
            } else {
                int add = nums[i] - nums[i + 1] + 1;
                count += add;
                nums[i + 1] += add;
            }
        }

        return count;
    }
}
