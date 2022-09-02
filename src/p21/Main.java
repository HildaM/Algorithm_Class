package p21;

import java.util.Scanner;

public class Main {
    private static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        Solution solution = new Solution();

        String num = in.next();
        int k = in.nextInt();

        System.out.println(solution.removeKdigits(num, k));
    }
}


class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            // 如果当前ch的前一个数较大，则移除它
            while (k > 0 && sb.length() != 0 && sb.charAt(sb.length() - 1) > ch) {
                sb.setLength(sb.length() - 1);
                k--;
            }
            if (ch == '0' && sb.length() == 0) continue;
            sb.append(ch);
        }

        int remain = sb.length() - k < 1 ? 0 : sb.length() - k;
        String ans = sb.substring(0, remain).toString();
        return ans.length() == 0 ? "0" : ans;
    }
}
