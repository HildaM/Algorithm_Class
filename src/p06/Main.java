package p06;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String s = in.next();
        int k = in.nextInt();

        Solution solution = new Solution();
        System.out.println(solution.longestSubstring(s, k));
    }
}

// 分治法
class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;

        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);

        int ans = 0;
        for (char c : map.keySet()) {
            if (map.get(c) < k) {
                for (String sub : s.split(String.valueOf(c))) {
                    ans = Math.max(ans, longestSubstring(sub, k));
                }
                return ans;
            }
        }

        return n;
    }
}

// 二分法
class Solution02 {
    public int longestSubstring(String s, int k) {
        char[] cs = s.toCharArray();
        int[] cnt = new int[26];
        int ans = 0;

        for (int p = 1; p <= 26; p++) {
            Arrays.fill(cnt, 0);

            // tot: 子串字符种类，sum: 至少出现k次的字符种类数
            for (int i = 0, j = 0, tot = 0, sum = 0; i < s.length(); i++) {
                int u = cs[i] - 'a';
                cnt[u]++;

                if (cnt[u] == 1) tot++;
                if (cnt[u] == k) sum++;

                // 当前字符数超过了循环规定的字符数 ---> 二分点
                while (tot > p) {
                    int t = cs[j++] - 'a';
                    cnt[t]--;

                    if (cnt[t] == 0) tot--;
                    if (cnt[t] == k - 1) sum--;
                }

                if (tot == sum) ans = Math.max(ans, i - j + 1);
            }
        }

        return ans;
    }
}
