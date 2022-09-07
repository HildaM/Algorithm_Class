package p14;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String s = in.nextLine();

        System.out.println(new Solution03().longestPalindrome(s));
    }
}


// 暴力法
// 时间复杂度 O(n*n)
class Solution01 {
    // dp[i]: 以s[i]结尾的最长回文子串长度为dp[i]
    //

    public String longestPalindrome(String s) {
        int len = 0, n = s.length();
        String ans = "";

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (sub.length() > len && isValid(sub)) {
                    ans = sub;
                    len = sub.length();
                }
            }
        }

        return ans;
    }

    private boolean isValid(String s) {
        if (s.length() == 1) return true;
        for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }
}


// 动态规划
// 二维dp
class Solution02 {
    // dp[i][j]: orgin[i]与reverse[j]连续相同的最大长度
    // 将orgin反转为reverse字符串，比对两者，相同处的最长子串就是答案

    public String longestPalindrome(String s) {
        String orgin = s, reverse = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int maxEnd = 0, maxLen = 0;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (orgin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                }
                // 判断：倒置前的头下标，是否等于倒置后的尾下表。
                // 因为即使orgin.charAt(i) == reverse.charAt(j)， 也不代表匹配到的子串是正确的
                if (dp[i][j] > maxLen) {
                    int beginRev = n - j - 1;
                    if (beginRev + dp[i][j] - 1 == i) {
                        maxLen = dp[i][j];
                        maxEnd = i;
                    }
                }
            }
        }

        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
}


// 动态规划
// 一维dp
class Solution03 {
    // dp[i][j]: orgin[i]与reverse[j]连续相同的最大长度
    // 将orgin反转为reverse字符串，比对两者，相同处的最长子串就是答案

    public String longestPalindrome(String s) {
        String orgin = s, reverse = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int maxEnd = 0, maxLen = 0;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            // 一维dp，二层循环倒序
            for (int j = n - 1; j >= 0; j--) {
                if (orgin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[j] = 1;
                    } else {
                        dp[j] = dp[j - 1] + 1;
                    }
                } else {
                    dp[j] = 0;
                }

                // 判断：倒置前的头下标，是否等于倒置后的尾下表。
                // 因为即使orgin.charAt(i) == reverse.charAt(j)， 也不代表匹配到的子串是正确的
                if (dp[j] > maxLen) {
                    int beginRev = n - j - 1;
                    if (beginRev + dp[j] - 1 == i) {
                        maxLen = dp[j];
                        maxEnd = i;
                    }
                }
            }
        }

        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }
}