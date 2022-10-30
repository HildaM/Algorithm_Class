package p35;

import java.util.Scanner;

/**
 * Description:
 * date: 2022/10/26 下午 3:44
 *
 * @author Four
 */
public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String[] line = in.nextLine().split(" ");
        int[] nums = new int[line.length];
        for (int i = 0; i < line.length; i++) nums[i] = Integer.parseInt(line[i]);
        System.out.println(new Solution().canJump(nums));
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        if (n == 1) return true;

        int nextDis = 0, curDis = 0;
        for (int i = 0; i < n; i++) {
            nextDis = Math.max(nextDis, i + nums[i]);
            if (i == curDis) {
                if (curDis == n - 1) return true;
                curDis = nextDis;
                if (curDis >= n - 1) return true;
            }
        }

        return false;
    }
}
