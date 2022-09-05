package p22;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();

        String line = in.nextLine();
        String[] arr = line.split(" ");
        int[] height = new int[arr.length];
        for (int i = 0; i < arr.length; i++) height[i] = Integer.parseInt(arr[i]);

        System.out.println(solution.maxArea(height));
    }
}

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;

        while (left < right) {
            int min = Math.min(height[left], height[right]);
            ans = Math.max(ans, (right - left) * min);
            if (height[left] < height[right]) left++;
            else right--;
        }

        return ans;
    }
}
