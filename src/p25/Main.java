package p25;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String[] line = in.nextLine().split(" ");
        int[] nums = new int[line.length];
        for (int i = 0; i < nums.length; i++) nums[i] = Integer.parseInt(line[i]);

        System.out.println(new Solution().subsetXORSum(nums));
    }
}


class Solution {
    int ans = 0;
    public int subsetXORSum(int[] nums) {
        if (nums.length == 1) return nums[0];
        recursion2(nums, 0, 0);

        return ans;
    }

    private void recursion2(int[] nums, int start, int xor_sum) {
        if (nums.length == start) {
            ans += xor_sum;
            return;
        }

        recursion2(nums, start + 1, xor_sum ^ nums[start]);
        recursion2(nums, start + 1, xor_sum);
    }
}
