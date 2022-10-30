package p41;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Description:
 * date: 2022/10/30 下午 2:18
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

        // 使用Stream转换数组
        System.out.println(new Solution().wiggleMaxLength(nums.stream().mapToInt(Integer::valueOf).toArray()));
    }
}


class Solution {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n == 1) return 1;

        int ans = 1;
        int curDif = 0, preDif = 0;

        for (int i = 1; i < n; i++) {
            curDif = nums[i] - nums[i - 1];
            if ((curDif < 0 && preDif >= 0) || (curDif > 0 && preDif <= 0)) {
                ans++;
                preDif = curDif;
            }

        }

        return ans;
    }
}
