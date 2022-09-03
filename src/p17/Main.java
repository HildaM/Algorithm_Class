package p17;

import java.util.*;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = in.nextLine();
        System.out.println(solution.longestPalindrome(s));
    }
}


class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Map.Entry<Character, Integer>> list = new ArrayList(map.entrySet());


        // 1. 选取最大的奇数
        int ans = 0, index = -1;
        for (int i = 0; i < list.size(); i++) {
            int val = list.get(i).getValue();
            if (val % 2 != 0 && ans < val) {
                ans = val;
                index = i;
            }
        }
        if (index != -1) list.remove(index);

        // 2. 加上所有的偶数，再加上所有奇数字符减一的结果
        for (Map.Entry<Character, Integer> entry : list) {
            if (entry.getValue() % 2 == 0) {
                ans += entry.getValue();
            } else {
                ans += entry.getValue() - 1;
            }
        }

        return ans;
    }
}