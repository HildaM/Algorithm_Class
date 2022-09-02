package p02;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(solution.majorityElement(nums));
    }

}

class Solution {
    public int majorityElement(int[] nums) {
        int num = nums.length / 2 + 1;

        Arrays.sort(nums);
        int count = 1;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                count++;
                if (count == num) return nums[i];
            }
        }

        return nums[nums.length - 1];
    }
}