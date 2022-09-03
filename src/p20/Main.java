package p20;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();

        String line = in.nextLine();
        String[] arr = line.split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++)
            nums[i] = Integer.parseInt(arr[i]);

        System.out.println(solution.largestPerimeter(nums));
    }
}

class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 1] + nums[i - 2] > nums[i]) {
                return nums[i - 1] + nums[i - 2] + nums[i];
            }
        }

        return 0;
    }
}
