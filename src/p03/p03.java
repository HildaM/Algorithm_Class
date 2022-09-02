package p03;

import java.awt.image.TileObserver;
import java.util.*;

public class p03 {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = in.nextInt();  // useless
        List<Integer> list = new ArrayList<>();
        while (n-- > 0) list.add(in.nextInt());
        int[] nums = list.stream().mapToInt(x -> x).toArray();

        System.out.print(solution.maxSubArray(nums));
    }

    private static int[] praseIntArray(String line) {
        String[] arr = line.split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
        return nums;
    }

}

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0, ans = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > ans) ans = sum;
            if (sum <= 0) sum = 0;
        }

        return ans;
    }
}


