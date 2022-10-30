package p38;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description:
 * date: 2022/10/27 上午 9:41
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

        System.out.println(new Solution().maxCoins(nums.stream().mapToInt(Integer::valueOf).toArray()));
    }
}

class Solution {
    public int maxCoins(int[] nums) {
        // 扩容nums，首尾加1
        int[] arr = new int[nums.length + 2];
        arr[0] = 1; arr[arr.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = nums[i];
        }

        nums = arr;
        int n = nums.length;

        // dp[i][j]: [i, j)开区间范围内，获取的最大金币个数
        int[][] dp = new int[n][n];

        // len表示开区间长度
        for (int len = 3; len <= n; len++) {
            // i表示开区间左端点下标
            for (int i = 0; i <= n - len; i++) {
                int res = 0;
                // k为开区间内的索引
                for (int k = i + 1; k < i + len - 1; k++) {
                    int left = dp[i][k];
                    int right = dp[k][i + len - 1];
                    res = Math.max(res, left + nums[i] * nums[k] * nums[i + len - 1] + right);
                }
                dp[i][i + len - 1] = res;
            }
        }

        return dp[0][n - 1];
    }
}